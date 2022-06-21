package com.example.customannotationinteceptor.interceptions;

import com.example.customannotationinteceptor.annotations.BscAuth;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

public class BasicAuthInterception  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;
        BscAuth bscAuth = method.getMethodAnnotation(BscAuth.class);

        if (bscAuth != null) {

            String value = request.getHeader("Authorization");
            response.setHeader("WWW-Authenticate", "Basic");
            if (value == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
               return  false;
            }
            if (!value.startsWith("Basic ")) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return  false;
            }
            String username = "", password = "";
            try {
                String base64EncodedCred = value.split(" ")[1];
                String decodedCreds = new String(Base64.getDecoder().decode(base64EncodedCred));
                username = decodedCreds.split(":")[0];
                password = decodedCreds.split(":")[1];
            } catch (Exception ex) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
            if(bscAuth.username().equals(username) && bscAuth.password().equals(password)){
                return  true;
            }
            if (!username.equals("zeynep") || !password.equals("12345")) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return  false; // controllere ulasma
            } else {
                 //return true; // controllere ulas
                return false;

            }
        }else {
            return  true;
        }

    }
}
