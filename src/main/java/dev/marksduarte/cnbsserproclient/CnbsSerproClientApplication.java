package dev.marksduarte.cnbsserproclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CnbsSerproClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CnbsSerproClientApplication.class, args);
    }

}
