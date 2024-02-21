package com.housing.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmarketApplication.class, args);
	}

}
