package com.bookLibrary.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.bookLibrary.web", "com,bookLibrary.service" })
public class BookLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookLibraryApplication.class, args);
    }
}
