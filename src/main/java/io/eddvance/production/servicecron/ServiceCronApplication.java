package io.eddvance.production.servicecron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceCronApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCronApplication.class, args);
    }

}
