package com.example.demo;

import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntityA {
	
	@Id
	private String id;

	private String name;
		
	private Set<EntityB> bees;
	
}
