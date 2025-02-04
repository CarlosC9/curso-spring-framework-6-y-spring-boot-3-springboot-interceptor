package com.carlos.curso.springboot.app.interceptor.springbootinterceptor.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
    return true;
  }

  @Override
  public void postHandle(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler,
    ModelAndView modelAndView
  ) throws Exception {
    HandlerMethod controller = ((HandlerMethod) handler);
    logger.info("LoadingTimeInterceptor: postHandle() saliendo ...".concat(controller.getMethod().getName()));
  }



}
