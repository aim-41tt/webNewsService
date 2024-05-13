package ru.example.WebNewsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class WebNewsServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(WebNewsServiceApp.class, args);
	}
}
