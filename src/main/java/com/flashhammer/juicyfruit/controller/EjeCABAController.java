package com.flashhammer.juicyfruit.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flashhammer.juicyfruit.model.AccesosExpediente;
import com.flashhammer.juicyfruit.model.Actuacion;
import com.flashhammer.juicyfruit.model.ContenedorUltimaAccion;
import com.flashhammer.juicyfruit.model.Encabezado;
import com.flashhammer.juicyfruit.model.ExpedientesSolo;
import com.flashhammer.juicyfruit.model.Ficha;
import com.flashhammer.juicyfruit.model.Parte;
import com.flashhammer.juicyfruit.model.Root;
import com.flashhammer.juicyfruit.model.UltimaAccion;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RestController
@RequestMapping("caba")
public class EjeCABAController {

    private final String MAIN_URL = "https://eje.juscaba.gob.ar/iol-api/api/public/expedientes/";
    private final String PARAMS = "?";

    private final String NOMBRE = "LUNA HERALDO SAUL";

    @GetMapping("listaExpIdsYCuijs")
    public Map<Integer, String> traerExpIdsYCuijs(String nombre) {
        Map<Integer, String> responseMap = new HashMap<>();
        Root root = traerListaCompleta(nombre);
        List<Object> objetos = root.getObjects();
        for (Object objeto : objetos) {
            ExpedientesSolo expediente = (ExpedientesSolo) objeto;
            Integer expId = expediente.getExpId();
            Encabezado encabezado = traerEncabezado(expId);
            responseMap.put(expId, encabezado.getCuij());
        }
        return responseMap;
    }

    @GetMapping("listaExpIdsYEncabezados")
    public Map<Integer, Encabezado> traerExpIdsYEncabezados(String nombre) {
        Map<Integer, Encabezado> responseMap = new HashMap<>();
        Root root = traerListaCompleta(nombre);
        List<Object> objetos = root.getObjects();
        for (Object objeto : objetos) {
            ExpedientesSolo expediente = (ExpedientesSolo) objeto;
            Integer expId = expediente.getExpId();
            Encabezado encabezado = traerEncabezado(expId);
            responseMap.put(expId, encabezado);
        }
        return responseMap;
    }

    @GetMapping("accesosExpediente")
    public AccesosExpediente accesosExpediente(Integer expId) {
        AccesosExpediente response = new AccesosExpediente();
        String url = MAIN_URL + "accesosExpediente";
        String params = PARAMS + "expId=" + expId;
        HttpEntity respEntity = httpEntityDesdeUrl(url, params);
        if (respEntity != null) {
            // EntityUtils to get the response content
            ObjectMapper om = new ObjectMapper();
            try {
                response = om.readValue(EntityUtils.toString(respEntity), AccesosExpediente.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return response;
    }

    // DONE
    @GetMapping("listaEncabezado")
    public Encabezado traerEncabezado(Integer expId) {
        String url = MAIN_URL + "encabezado";
        String params = PARAMS + "expId=" + expId;
        Encabezado encabezadoResponse = new Encabezado();
        HttpEntity respEntity = httpEntityDesdeUrl(url, params);
        if (respEntity != null) {
            // EntityUtils to get the response content
            ObjectMapper om = new ObjectMapper();
            try {
                encabezadoResponse = om.readValue(EntityUtils.toString(respEntity), Encabezado.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return encabezadoResponse;
    }

    // DONE
    @GetMapping("listaUltimaAccion")
    public UltimaAccion traerUltimaAccion(Integer expId) {
        UltimaAccion ultimaAccion = new UltimaAccion();
        String url = MAIN_URL + "ultimaAccion";
        String params = PARAMS + "expId=" + expId;
        HttpEntity respEntity = httpEntityDesdeUrl(url, params);
        if (respEntity != null) {
            // EntityUtils to get the response ExpedientesSolo
            ObjectMapper om = new ObjectMapper();
            ContenedorUltimaAccion contenedorUltimaAccion = null;
            try {
                contenedorUltimaAccion = om.readValue(EntityUtils.toString(respEntity), ContenedorUltimaAccion.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(contenedorUltimaAccion.getUltimaAccion()!=null){
                ultimaAccion=contenedorUltimaAccion.getUltimaAccion();
            }
        }
        return ultimaAccion;
    }

    @GetMapping("listaFicha")
    public Ficha traerFicha(Integer expId) {
        Ficha ficha = new Ficha();
        String url = MAIN_URL + "ficha";
        String params = PARAMS + "expId=" + expId;
        HttpEntity respEntity = httpEntityDesdeUrl(url, params);
        if (respEntity != null) {
            // EntityUtils to get the response ExpedientesSolo
            ObjectMapper om = new ObjectMapper();
            try {
                ficha = om.readValue(EntityUtils.toString(respEntity, "UTF-8"), Ficha.class);
            } catch (IOException e) {
                System.out.printf(e.getMessage());
            }
        }
        return ficha;
    }

    // TODO
    @GetMapping("listaPartes")
    public Root traerPartes(Integer expId) {
        String accesoMinisterios = "false";
        String size = "1000";
        String params = PARAMS + "expId=" + expId + "&accesoMinisterios=" + accesoMinisterios + "&size=" + size;
        String url = MAIN_URL + "partes";
        Root partes = traerRootGet(params, url);
        if (partes.getTotalPages() > 1) {
            String paramsFor = params + "&page=";
            for (int i = 1; i < partes.getTotalPages(); i++) {
                paramsFor = paramsFor + i;
                Root forRespPartes = traerRootGet(paramsFor, url);
                if (forRespPartes != null) {
                    // EntityUtils to get the response ExpedientesSolo
                    List<Object> listaObjetos = new ArrayList<>();
                    if(partes.getObjects()!=null && !partes.getObjects().isEmpty()) {
                        listaObjetos.addAll(partes.getObjects());
                    }
                    if(forRespPartes.getObjects()!=null && !forRespPartes.getObjects().isEmpty()) {
                        listaObjetos.addAll(forRespPartes.getObjects());
                    }
                    ObjectMapper om = new ObjectMapper();
                    List<Parte> partesMap = om.convertValue(listaObjetos, new TypeReference<ArrayList<Parte>>() {
                    });
                    Stream<Parte> objects = partesMap.stream().distinct().sorted();
                    listaObjetos = objects.collect(Collectors.toList());
                    partes.setObjects(listaObjetos);
                    partes.setNumberOfElements(partes.getNumberOfElements() + forRespPartes.getNumberOfElements());
                    partes.setSize(partes.getSize() + forRespPartes.getSize());
                }
            }
        }
        return partes;
    }

    // TODO
    @GetMapping("listaActuaciones")
    public Root traerActuaciones(Integer expId) {
        String accesoMinisterios = "false";
        String filtro = "%7B%22cedulas%22:true,%22escritos%22:true,%22despachos%22:true,%22notas%22:true,%22expId%22:" + expId + ",%22accesoMinisterios%22:" + accesoMinisterios + "%7D";
        String size = "1000";
        String params = PARAMS + "size=" + size + "&filtro=" + filtro;
        String url = MAIN_URL + "actuaciones";
        Root actuaciones = traerRootGet(params, url);
        if (actuaciones.getTotalPages() > 1) {
            String paramsFor = params + "&page=";
            for (int i = 1; i < actuaciones.getTotalPages(); i++) {
                paramsFor = paramsFor + i;
                Root forRespActuaciones = traerRootGet(url, paramsFor);
                if (forRespActuaciones != null) {
                    // EntityUtils to get the response ExpedientesSolo
                    List<Object> listaObjetos = new ArrayList<>();
                    if(!actuaciones.getObjects().isEmpty()) {
                        listaObjetos.addAll(actuaciones.getObjects());
                    }
                    if(!forRespActuaciones.getObjects().isEmpty()) {
                        listaObjetos.addAll(forRespActuaciones.getObjects());
                    }
                    ObjectMapper om = new ObjectMapper();
                    List<Actuacion> actuacionesMap = om.convertValue(listaObjetos, new TypeReference<ArrayList<Actuacion>>() {
                    });
                    Stream<Actuacion> objects = actuacionesMap.stream().distinct().sorted();
                    listaObjetos = objects.collect(Collectors.toList());
                    actuaciones.setObjects(listaObjetos);
                    actuaciones.setNumberOfElements(actuaciones.getNumberOfElements() + forRespActuaciones.getNumberOfElements());
                    actuaciones.setSize(actuaciones.getSize() + forRespActuaciones.getSize());
                }
            }
        }
        return actuaciones;
    }

    // DONE
    @GetMapping("listaListaCompleta")
    public Root traerListaCompleta(String nombre) {
        String url = MAIN_URL + "lista";
        String numberOfElements = "1000";
        String pagina = "0";
        String paramsString = "{\"filter\":\"{\\\"identificador\\\":\\\"" + nombre + "\\\"}\",\"tipoBusqueda\":\"PAR\",\"page\":" + pagina + ",\"size\":" + numberOfElements + " }";
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("info", paramsString));
        Root finalResponse = traerRootPost(url, params);
        if (finalResponse.getTotalPages() > 1) {
            for (int i = 1; i < finalResponse.getTotalPages(); i++) {
                String paramsForString = "{\"filter\":\"{\\\"identificador\\\":\\\"" + nombre + "\\\"}\",\"tipoBusqueda\":\"PAR\",\"page\":" + i + ",\"size\":" + numberOfElements + " }";
                List<NameValuePair> paramsFor = new ArrayList<>();
                paramsFor.add(new BasicNameValuePair("info", paramsForString));
                Root forRespRoot = traerRootPost(url, paramsFor);
                if (forRespRoot != null) {
                    // EntityUtils to get the response ExpedientesSolo
                    List<Object> listaObjetos = new ArrayList<>();
                    listaObjetos.addAll(finalResponse.getObjects());
                    listaObjetos.addAll(forRespRoot.getObjects());
                    ObjectMapper om = new ObjectMapper();
                    List<ExpedientesSolo> expedientesSolos = om.convertValue(listaObjetos, new TypeReference<ArrayList<ExpedientesSolo>>() {
                    });
                    Stream<ExpedientesSolo> objects = expedientesSolos.stream().distinct().sorted();
                    listaObjetos = objects.collect(Collectors.toList());
                    finalResponse.setObjects(listaObjetos);
                    finalResponse.setNumberOfElements(finalResponse.getNumberOfElements() + forRespRoot.getNumberOfElements());
                    finalResponse.setSize(finalResponse.getSize() + forRespRoot.getSize());
                }
            }
        }
        return finalResponse;
    }

    private Root traerRootPost(String url, List<NameValuePair> params) {
        Root finalResponse = new Root();
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpPost httpPost = new HttpPost(url);
            // Request parameters and other properties.
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            /*
             * Execute the HTTP Request
             */
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity respEntity = response.getEntity();
            if (respEntity != null) {
                // EntityUtils to get the response ExpedientesSolo
                ObjectMapper om = new ObjectMapper();
                finalResponse = om.readValue(EntityUtils.toString(respEntity), Root.class);
            }
        } catch (IOException e) {
            // writing exception to log
            e.printStackTrace();

        }
        return finalResponse;
    }

    private Root traerRootGet(String paramsString, String url) {
        Root root = new Root();
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet httpGet = new HttpGet(url + paramsString);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity respEntity = response.getEntity();
            if (respEntity != null) {
                // EntityUtils to get the response ExpedientesSolo
                ObjectMapper om = new ObjectMapper();
                root = om.readValue(EntityUtils.toString(respEntity), Root.class);
            }
        } catch (IOException e) {
            System.out.println(paramsString);
            // writing exception to log
            e.printStackTrace();
        }
        return root;
    }

    private HttpEntity httpEntityDesdeUrl(String url, String params) {
        HttpEntity respEntity = null;
        SocketConfig socketConfig = SocketConfig.custom().setSoKeepAlive(true).setSoTimeout(30000).build(); //We need to set socket keep alive
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(360000).build();
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).
                setDefaultSocketConfig(socketConfig).build()) {
            HttpGet httpGet = new HttpGet(url + params);
            HttpResponse response = httpClient.execute(httpGet);
            respEntity = response.getEntity();
        } catch (IOException e) {
            // writing exception to log
            e.printStackTrace();
        }
        return respEntity;
    }

}

