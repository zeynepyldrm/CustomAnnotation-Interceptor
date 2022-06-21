package com.example.customannotationinteceptor.annotations;

import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.RequestHeader;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface BscAuth {
    String username() default "zeynep";
    String password() default  "12345";
}
