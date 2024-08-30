package com.instagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Instagram", version = "4-4.19.0", description = "This API provides a backend for an Instagram-like social networking platform. The application allows users to create, edit, delete, and view posts, manage user accounts, and interact with content through various endpoints. Features include user registration, post management, custom exceptions, global exception handling, and image storage. This API is built using Spring Boot and MySQL", contact = @Contact(name = "Venkateswaran R", email = "rvenkates98@gmail.com")))
public class InstagramApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstagramApplication.class, args);
	}

}
