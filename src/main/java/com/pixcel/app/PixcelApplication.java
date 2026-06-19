package com.pixcel.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PixcelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixcelApplication.class, args);
	}

}
