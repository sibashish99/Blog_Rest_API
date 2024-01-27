package com.blog.proj.exceptions;

import lombok.Getter;
import lombok.Setter;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	@Getter
	@Setter
	private static long serialVersionUID = 1L;
	
    String resourceName;
    String fieldName;
    long fieldValue;
    
    public ResourceNotFoundException( String resourceName,
    String fieldName,
    long fieldValue) {
    	super(String.format("%s not found with %s : %l", resourceName, fieldName, fieldValue));
    	this.resourceName=resourceName;
    	this.fieldName=fieldName;
    	this.fieldValue=fieldValue;
    }
    
    
    
    
}
