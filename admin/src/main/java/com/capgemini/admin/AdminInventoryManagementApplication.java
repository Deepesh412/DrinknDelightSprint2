package com.capgemini.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AdminInventoryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminInventoryManagementApplication.class, args);
	}

}
