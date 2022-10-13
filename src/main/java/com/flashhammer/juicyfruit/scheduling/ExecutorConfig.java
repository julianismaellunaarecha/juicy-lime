package com.flashhammer.juicyfruit.scheduling;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flashhammer.juicyfruit.controller.EjeCABAController;
import com.flashhammer.juicyfruit.controller.MongoController;
import com.flashhammer.juicyfruit.model.AccesosExpediente;
import com.flashhammer.juicyfruit.model.Encabezado;
import com.flashhammer.juicyfruit.model.Expediente;
import com.flashhammer.juicyfruit.model.ExpedientesSolo;
import com.flashhammer.juicyfruit.model.ExpedientesSoloNew;
import com.flashhammer.juicyfruit.model.Ficha;
import com.flashhammer.juicyfruit.model.Parte;
import com.flashhammer.juicyfruit.model.Root;
import com.flashhammer.juicyfruit.model.UltimaAccion;
import com.flashhammer.juicyfruit.model.UltimaAccionNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@EnableScheduling
public class ExecutorConfig implements AsyncConfigurer {

    private static final String NOMBRE = "LUNA HERALDO SAUL";
    private static final String IN_BOTH = "AMBOS";
    private static final String ONLY_DB = "SOLOLOCAL";
    private static final String ONLY_EJE = "SOLOEJE";
    @Autowired
    EjeCABAController ejeCABAController;
    @Autowired
    MongoController mongoController;
    @Value("${async.executor.corePoolSize:8}")
    private int corePoolSize;

    @Value("${async.executor.maxPoolSize:2000}")
    private int maxPoolSize;

    @Value("${async.executor.queueCapacity:5000}")
    private int queueCapacity;

    @Override
    public Executor getAsyncExecutor() {
        return taskExecutor();
    }

    @Bean(name = "threadPoolExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(queueCapacity);
        taskExecutor.setThreadNamePrefix("Async Executor -");
        System.out.println("Properties " +
                "- corePoolSize: " + taskExecutor.getCorePoolSize() +
                ", maxPoolSize: " + taskExecutor.getMaxPoolSize() +
                ", poolSize: " + taskExecutor.getPoolSize() +
                ", activeCount: " + taskExecutor.getActiveCount());
        return taskExecutor;
    }

    @Scheduled(initialDelay = 6000, fixedRate = 300000) // 60000 miliseconds - 1 minute
    public void doLista() {
        long t = System.currentTimeMillis();
        impactarLista(NOMBRE);
        System.out.printf("time taken for task: %s , %s%n",
                NOMBRE,
                (System.currentTimeMillis() - t));
    }

    @Scheduled(initialDelay = 12000, fixedRate = 120000) // 60000 miliseconds - 1 minute
    public void doTasks() {
        long t = System.currentTimeMillis();
        impactarEncabezados();
        impactarUltimasAcciones();
        impactarFichas();
        impactarPartes();
        System.out.printf("time taken for task: %s , %s%n",
                "tasks",
                (System.currentTimeMillis() - t));
    }

    public void impactarLista(String nombre) {
        System.out.println("impactarLista()");
        // Trae lista en objeto desde EJE.
        Root result = ejeCABAController.traerListaCompleta(nombre);
        // Transforma la lista de eje a una Lista de objetos.
        List<Object> objetos = result.getObjects();
        // Crea Mapa para rellenar con EJE de ID (id de expediente del sistema EJE) y Objeto ExpedienteSolo. HashMap<Integer,ExpedientesSolo> osea Mapa(ID,ExpedienteSolo).
        Map<Integer,ExpedientesSolo> expedientesIdEje = new HashMap<>();
        // Rellena Mapa con datos de lista de EJE iterando cada objeto en la lista.
        for (Object objeto : objetos) {
            // Crea ExpedientesSolo individual para esta iteracion .
            ExpedientesSolo expedientesSolo = (ExpedientesSolo) objeto;
            // Rellena Mapa con ExpedientesSolo individual para esta iteracion.
            expedientesIdEje.put(expedientesSolo.getExpId(),expedientesSolo);
        }
        // Trae lista de ExpedientesSolo desde Base de datos local de forma reactiva del DB Local.
        Flux<ExpedientesSolo> expedientesSolosMongo = mongoController.getExpedientesSolo();
        // Se subscribe a la lista anterior reactiva del DB Local.
        expedientesSolosMongo.subscribe();
        // Crea Lista Iterable de ExpedientesSolo desde la lista reactiva del DB Local.
        Iterable<ExpedientesSolo> expedientesSolosIterable = expedientesSolosMongo.toIterable();
        // Crea Mapa para rellenar con Base de datos local de ID (id de expediente del sistema EJE) y Objeto ExpedienteSolo. HashMap<Integer,ExpedientesSolo> osea Mapa(ID,ExpedienteSolo).
        Map<Integer,ExpedientesSolo> expedientesIdLocal = new HashMap<>();
        // Rellena Mapa con datos de lista de Base de datos local iterando cada objeto en la lista.
        expedientesSolosIterable.forEach(expedientesMongo -> {
            // Rellena Mapa con ExpedientesSolo individual para esta iteracion.
            expedientesIdLocal.put(expedientesMongo.getExpId(),expedientesMongo);
        });
        Map<Integer,String> expedientesIdMapPresent = new HashMap<>();
        AtomicInteger contadorBajas = new AtomicInteger();
        AtomicInteger contadorAltas = new AtomicInteger();
        // Chequea cuales ID de expediente estan en la base de datos y cuales estan en el EJE.
        expedientesIdLocal.forEach((integerExpId, expedientesSolo) -> {
            if(expedientesIdEje.containsKey(integerExpId)){
                expedientesIdMapPresent.put(integerExpId,IN_BOTH);
            } else {
                expedientesIdMapPresent.put(integerExpId,ONLY_DB);
                contadorBajas.getAndIncrement();
                System.out.printf("ID baja de EJE: " + integerExpId + "%n");
            }
        });
        expedientesIdEje.forEach((integerExpId, expedientesSolo) -> {
            if(expedientesIdLocal.containsKey(integerExpId)){
                expedientesIdMapPresent.put(integerExpId,IN_BOTH);
            } else {
                expedientesIdMapPresent.put(integerExpId,ONLY_EJE);
                Mono<ExpedientesSolo> returnedValSolo = mongoController.putExpedientesSoloByValue(expedientesSolo);
                returnedValSolo.subscribe();
                ExpedientesSoloNew expedientesSoloNew = new ExpedientesSoloNew();
                expedientesSoloNew.setExpId(expedientesSolo.getExpId());
                expedientesSoloNew.setFechaFavorito(expedientesSolo.getFechaFavorito());
                Mono<ExpedientesSoloNew> returnedValSoloNew = mongoController.putExpedientesSoloNewByValue(expedientesSoloNew);
                returnedValSoloNew.subscribe();
                contadorAltas.getAndIncrement();
                System.out.printf("ID alta de EJE: " + integerExpId + "%n");
                expedientesIdMapPresent.put(integerExpId,IN_BOTH);
            }
        });
        System.out.printf("Cuenta de lista en EJE: " + expedientesIdEje.size() + ". Cuenta de lista en Lime: " + expedientesIdLocal.size() + "%n");
        System.out.printf("Bajas de EJE: " + contadorBajas + ". Altas de EJE: " + contadorAltas + "%n");
    }

    private void impactarEncabezados(Integer id) {
            Encabezado encabezado = ejeCABAController.traerEncabezado(id);
            encabezado.setExpId(id);
            Mono<Boolean> encabezadoCheck = mongoController.getEncabezadoPresente(id);
            encabezadoCheck.subscribe(encabezadoChecked -> {
                if (!encabezadoChecked) {
                    Mono<Encabezado> putEncabezado = mongoController.putEncabezadoByValue(encabezado);
                    putEncabezado.subscribe();
                }
            });
            Mono<Encabezado> encabezadoMongo = mongoController.getEncabezadoById(id);
        encabezadoMongo.subscribe(
                encabezadoMongoSubs -> {
                    if(checkEncabezado(encabezado,encabezadoMongoSubs)){
                        mongoController.updateEncabezadoByValue(encabezado);
                    }
                }
        );
    }

    private boolean checkEncabezado(Encabezado encabezado, Encabezado encabezadoMongoSubs) {
        boolean anio = encabezadoMongoSubs.getAnio() != encabezado.getAnio();
        boolean caratula = !encabezadoMongoSubs.getCaratula().equalsIgnoreCase(encabezado.getCaratula());
        boolean cuij = !encabezadoMongoSubs.getCuij().equalsIgnoreCase(encabezado.getCuij());
        boolean esPrivado = encabezadoMongoSubs.getEsPrivado() != encabezado.getEsPrivado();


        return anio && caratula && cuij && esPrivado;
    }

    private void impactarUltimasAcciones(Integer id) {
            AccesosExpediente accesosExpediente = ejeCABAController.accesosExpediente(id);
            if(accesosExpediente.getTieneAccesoEstricto()
                    || accesosExpediente.getTieneAccesoLogueado()
                    || accesosExpediente.getTieneAccesoPublico()
                    || accesosExpediente.getTieneAccesoRadicado()
                    || accesosExpediente.getTieneAccesoPorAutorizacion()
            ) {
                UltimaAccion ultimaAccion = ejeCABAController.traerUltimaAccion(id);
                ultimaAccion.setExpId(id);
                Mono<Boolean> ultimaAccionPresenteChecked = mongoController.getUltimaAccionPresente(id);
                ultimaAccionPresenteChecked.subscribe(ultimaAccionPresente -> {
                    UltimaAccionNew ultimaAccionNew = new UltimaAccionNew();
                    ultimaAccionNew.setDescripcion(ultimaAccion.getDescripcion());
                    ultimaAccionNew.setFecha(ultimaAccion.getFecha());
                    ultimaAccionNew.setTipo(ultimaAccion.getTipo());
                    ultimaAccionNew.setExpId(ultimaAccion.getExpId());
                    if (!ultimaAccionPresente) {
                        Mono<UltimaAccion> putUltimaAccion = mongoController.putUltimaAccionByValue(ultimaAccion);
                        putUltimaAccion.subscribe();
                        Mono<UltimaAccionNew> putUltimaAccionNew = mongoController.putUltimaAccionNewByValue(ultimaAccionNew);
                        putUltimaAccionNew.subscribe();
                    } else {
                        Mono<UltimaAccion> ultimaAccionCheck = mongoController.getUltimaAccionById(id);
                        ultimaAccionCheck.subscribe(ultimaAccionChecked -> {
                            if (ultimaAccion.getFecha() != ultimaAccionChecked.getFecha()) {
                                Mono<UltimaAccion> updateUltimaAccion = mongoController.updateUltimaAccionByValue(ultimaAccion);
                                updateUltimaAccion.subscribe();
                                Mono<UltimaAccionNew> putUltimaAccionNew = mongoController.putUltimaAccionNewByValue(ultimaAccionNew);
                                putUltimaAccionNew.subscribe();
                            }
                        });
                    }
                });
            } else {

            }
    }

    private void impactarFichas(Integer id) {
            Mono<Boolean> fichaCheck = mongoController.getFichaPresente(id);
            fichaCheck.subscribe(fichaChecked -> {
                if (!fichaChecked) {
                    Ficha ficha = ejeCABAController.traerFicha(id);
                    ficha.setExpId(id);
                    Mono<Ficha> putFicha = mongoController.putFichaByValue(ficha);
                    putFicha.subscribe();
                }
            });
    }

    private void impactarPartes(Integer id) {
        List<Parte> allPartes = new ArrayList<>();
            Root parteRoot = ejeCABAController.traerPartes(id);
            List<Object> partesObjects = parteRoot.getObjects();
            ObjectMapper om = new ObjectMapper();
            List<Parte> parteInds = om.convertValue(partesObjects, new TypeReference<ArrayList<Parte>>() {
            });
            if(parteInds!=null) {
                for (Parte parteInd : parteInds) {
                    parteInd.setExpId(id);
                    allPartes.add(parteInd);
                }
            }
        List<Parte> listaPartes = new ArrayList<>();
        Flux<Parte> partesMongo = mongoController.getParteAll();
        partesMongo.filter(parte -> parte.getExpId()==id).subscribe(listaPartes::add);
        for(Parte allParte : allPartes) {
            if (!listaPartes.isEmpty()) {
                boolean found = false;
                for (Parte listaParte : listaPartes) {
                    if (listaParte.getExpId() == allParte.getExpId() && listaParte.getPerId() == allParte.getPerId() && listaParte.getVinculo().equalsIgnoreCase(allParte.getVinculo())) {
                        found = true;
                        Mono<Parte> updateParte = mongoController.updateParteByValue(allParte);
                        updateParte.subscribe();
                    }
                }
                if (!found) {
                    Mono<Parte> putParte = mongoController.putParteByValue(allParte);
                    putParte.subscribe();
                }
            } else {
                Mono<Parte> putParte = mongoController.putParteByValue(allParte);
                putParte.subscribe();
            }
        }

    }

}