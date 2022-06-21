package com.example.customannotationinteceptor.interceptions;

import com.example.customannotationinteceptor.annotations.BscAuth;
import com.example.customannotationinteceptor.annotations.Write;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteInterception  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //return HandlerInterceptor.super.preHandle(request, response, handler);
        HandlerMethod method=(HandlerMethod) handler;
        Write write=method.getMethodAnnotation(Write.class);
        if(write != null){
            if(write.name().equals("admin")){
                return true;
            }
            else{
                return false;
            }
        }else{
            return  false;
        }


    }
}
