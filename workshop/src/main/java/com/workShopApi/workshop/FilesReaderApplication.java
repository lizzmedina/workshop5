package com.workShopApi.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FilesReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilesReaderApplication.class, args);
	}

}
