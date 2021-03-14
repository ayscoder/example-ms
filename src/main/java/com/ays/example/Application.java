package com.ays.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    /**
     * #1
     * We may want to initialize database with some fixed schema (DDL) and insert default data (DML) into tables before
     * the application is ready is run business use cases.
     *
     * We can achieve this by putting sql files into resources folder (/src/main/resources/).
     *
     * schema.sql – To initialize the schema ie.create tables and dependencies.
     * data.sql – To insert default data rows.
     *
     * #2
     * Start the spring boot application and access the console in browser with URL : http://localhost:8080/h2.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
