package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private EntityARepo aRepo;
	
	@Autowired
	private EntityBRepo bRepo;

	@EventListener(ApplicationReadyEvent.class)
	public void doSomething() {
		 bRepo.save(EntityB.builder().name("B1").build());
		 bRepo.save(EntityB.builder().name("B2").build());
		 bRepo.save(EntityB.builder().name("B3").build());
		 
		 aRepo.save(EntityA.builder().name("A1").build());
	}

}
