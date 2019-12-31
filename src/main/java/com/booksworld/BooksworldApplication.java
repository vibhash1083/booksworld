package com.booksworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.booksworld")
public class BooksworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksworldApplication.class, args);
	}
}
