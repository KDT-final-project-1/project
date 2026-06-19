package com.pixcel.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.pixcel.app.**.mapper")
public class PixcelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixcelApplication.class, args);
	}

}
