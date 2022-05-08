package com.vinamra.microservices.complete.skeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MicroservicesCompleteSkeletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCompleteSkeletonApplication.class, args);
	}

	@GetMapping("")
	public String hello(){
		return ("Hello world");
	}
}
