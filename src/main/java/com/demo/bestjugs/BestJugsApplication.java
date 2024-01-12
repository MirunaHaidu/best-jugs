package com.demo.bestjugs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.demo.bestjugs.model")
public class BestJugsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestJugsApplication.class, args);
	}

}
