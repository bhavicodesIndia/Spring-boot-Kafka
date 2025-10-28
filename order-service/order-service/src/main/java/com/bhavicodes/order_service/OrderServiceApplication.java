package com.bhavicodes.order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {
//configure kafka producer in the order Service application
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
