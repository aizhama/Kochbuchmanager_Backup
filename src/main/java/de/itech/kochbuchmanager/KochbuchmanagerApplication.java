package de.itech.kochbuchmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
        //(exclude = {DataSourceAutoConfiguration.class}) NUR POSTGRESSSSSS
public class KochbuchmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KochbuchmanagerApplication.class, args);
    }

}
