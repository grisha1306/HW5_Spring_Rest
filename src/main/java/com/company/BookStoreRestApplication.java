package com.company;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Book Store API", version = "1.0", description = "Book Store Web Service"))
public class BookStoreRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreRestApplication.class);
    }
}
