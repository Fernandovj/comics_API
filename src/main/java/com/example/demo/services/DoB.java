package com.example.demo.services;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, PARAMETER })
@Constraint(validatedBy = DoBValidator.class)
public @interface DoB {
	public String message() default "Please, type a valid date of birth";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};

}
