package com.mindtree.movie.booking.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException extends RuntimeException{

	private String entityName;
	private String entityID;
	private Object idValue;
	private String name;
	
	public ResourceNotFoundException(String entityName, String entityID, long idValue) {
		super(String.format("No data is available with this %s = %s in %s Database", entityID, idValue, entityName));
		this.entityName = entityName;
		this.entityID = entityID;
		this.idValue = idValue;
	}
	public ResourceNotFoundException(String entityName, String entityID, String name) {
		super(String.format("No data is available with this %s = %s in %s Database", entityID, name, entityName));
		this.entityName = entityName;
		this.entityID = entityID;
		this.idValue = idValue;
	}
	
}
