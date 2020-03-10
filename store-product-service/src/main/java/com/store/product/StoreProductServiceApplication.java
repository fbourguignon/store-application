package com.store.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StoreProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreProductServiceApplication.class, args);
	}

}
