package com.carlos.curso.springboot.app.interceptor.springbootinterceptor.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class FooController {

  @GetMapping("/foo")
  public Map<String, String> foo() {
    return Collections.singletonMap("message", "handler foo dle controlador");
  }

  @GetMapping("/bar")
  public Map<String, String> bar() {
    return Collections.singletonMap("message", "handler bar dle controlador");
  }

  @GetMapping("/baz")
  public Map<String, String> baz() {
    return Collections.singletonMap("message", "handler baz dle controlador");
  }

}
