package com.vaib.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages={
"com.vaib.demo", "com.vaib.demo.beans"})
public class NumeroAlphaAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumeroAlphaAssignmentApplication.class, args);
	}

}
 