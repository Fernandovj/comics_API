package com.example.demo.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DoBValidator implements ConstraintValidator<DoB, String>{
	
	

    @Override
    public void initialize(DoB constraintAnnotation) {

    }

    @Override
    public boolean isValid(String dob, ConstraintValidatorContext context) {
    	
    	try {
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    	LocalDate dobLocalDate = LocalDate.parse(dob, formatter);
	    	System.out.println(dobLocalDate);
	    	LocalDate today = LocalDate.now();
	    	
	    	if (dobLocalDate.compareTo(today) < 0) {
			    //before today
			    //System.out.println("before");
			    return true;
			}
			else {
				//System.out.println("after");
				return false;
		}
    	}catch (Exception e) {
			// TODO: handle exception
    		return false;
		}
		

    }

}
