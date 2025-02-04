package com.carlos.curso.springboot.app.interceptor.springbootinterceptor.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component("loadingTimeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

  @Override
  public boolean preHandle(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler
  ) throws Exception {
    HandlerMethod controller = ((HandlerMethod) handler);
    logger.info("LoadingTimeInterceptor: preHandle() entrando ... ".concat(controller.getMethod().getName()));
    long start = System.currentTimeMillis();
    request.setAttribute("start", start);
    Thread.sleep(new Random().nextInt(500));

//    Map<String, String> json = new HashMap<>();
//    json.put("error", "No tieens acceso a esta página");
//    json.put("date", new Date().toString());
//    response.setContentType("application/json");
//    response.setStatus(HttpStatus.UNAUTHORIZED.value());
//    response.getWriter().write(new ObjectMapper().writeValueAsString(json));

    return true;
  }

  @Override
  public void postHandle(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler,
    ModelAndView modelAndView
  ) throws Exception {
    long end = System.currentTimeMillis();
    long start = (long) request.getAttribute("start");
    long result = end - start;
    logger.info("Tiempo transcurrido: " + result + " milisegundos!");
    HandlerMethod controller = ((HandlerMethod) handler);
    logger.info("LoadingTimeInterceptor: postHandle() saliendo ...".concat(controller.getMethod().getName()));
  }



}
