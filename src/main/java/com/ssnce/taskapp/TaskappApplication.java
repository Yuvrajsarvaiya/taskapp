package com.ssnce.taskapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskappApplication {

	public static void main(String[] args) {
		System.out.println("Starting server");
		SpringApplication.run(TaskappApplication.class, args);
	}

}
