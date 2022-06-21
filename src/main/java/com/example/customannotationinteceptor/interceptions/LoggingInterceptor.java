package com.example.customannotationinteceptor.interceptions;

import com.example.customannotationinteceptor.annotations.Logging;
import com.example.customannotationinteceptor.annotations.Write;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

public class LoggingInterceptor implements HandlerInterceptor {
    private HandlerMethod method;
    private Logging logging;
    private Logger logger = Logger.getLogger("auditLogger");
    private String user;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        method = (HandlerMethod) handler;
        logging = method.getMethodAnnotation(Logging.class);
        if (logging != null) {
            if (request.getRequestURI().endsWith("user")) {
                if (request.getMethod().equals("GET")) {
                    logger.info("Pre handle :GET "+getCurrentTime()+request.getLocalName());
                }
                if (request.getMethod().equals("POST")) {
                    user = request.getRemoteUser();
                    System.out.println("pre handle: post");
                    logger.info("Pre handle :get "+getCurrentTime()+user);
                }

            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        method=(HandlerMethod) handler;
        logging=method.getMethodAnnotation(Logging.class);
        if(logging!=null) {
            if (request.getRequestURI().endsWith("user")) {

                if (request.getMethod().equals("GET")) {
                    //
                    logger.info("postHandle : GET request");
                }

                if (request.getMethod().equals("POST")) {
                    logger.info("postHandle : POST request "+getCurrentTime());
                }
            }
        }
    }
    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }
}
