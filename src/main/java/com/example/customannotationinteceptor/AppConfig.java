package com.example.customannotationinteceptor;

import com.example.customannotationinteceptor.interceptions.BasicAuthInterception;
import com.example.customannotationinteceptor.interceptions.LoggingInterceptor;
import com.example.customannotationinteceptor.interceptions.WriteInterception;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new BasicAuthInterception());
        registry.addInterceptor(new WriteInterception());
        registry.addInterceptor(new LoggingInterceptor());
    }
}
