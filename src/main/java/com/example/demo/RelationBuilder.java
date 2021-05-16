package com.example.demo;

import java.util.Set;
import java.util.stream.Collectors;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveCallback;
import org.springframework.data.util.StreamUtils;
import org.springframework.stereotype.Component;

@Component
public class RelationBuilder implements BeforeSaveCallback<EntityA> {

	@Autowired
	private EntityBRepo bRepo;

	@Override
	public EntityA onBeforeSave(EntityA entity, Document document, String collection) {
		Set<EntityB> allBees = StreamUtils.createStreamFromIterator(bRepo.findAll().iterator())
				.collect(Collectors.toSet());
		entity.setBees(allBees);
		return entity;
	}

}
