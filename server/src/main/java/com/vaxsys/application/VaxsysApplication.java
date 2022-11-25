package com.vaxsys.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({ "com.vaxsys.repository" })
@ComponentScan({ "com.vaxsys.service" })
@ComponentScan(basePackageClasses = VaxsysController.class)
@EnableMongoRepositories(basePackages = "com.vaxsys.repository")
public class VaxsysApplication {
	public static void main(String[] args) {
		SpringApplication.run(VaxsysApplication.class, args);
	}
}