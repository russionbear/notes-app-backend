package com.russionbear.notesapp.backend.article.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/article")
public class ShutdownController implements ApplicationContextAware {
    private ApplicationContext context;

    @PostMapping("/shutdown")
    public void shutdownContext(HttpServletRequest request) {
        System.out.println(request.getServerName());
        if(request.getServerName().contains("localhost")||request.getServerName().contains("127.0.0.1")){
            ((ConfigurableApplicationContext) context).close();
        }
    }
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.context = ctx;
    }
}
