package com.flashhammer.juicyfruit.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableScheduling
public class ExecutorConfigFile implements AsyncConfigurer {

    private static final String NOMBRE = "NOMBREDEABOGADO";
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
        Long.MAX_VALUE
    }
}
