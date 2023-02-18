package com.weekenddev.sfgdi.controllers;

import com.weekenddev.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {
    public ConstructorInjectedController(@Qualifier("contructorGreetingServiceImpl") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    private final GreetingService greetingService;

    public String sayHello(){
        return this.greetingService.sayGreeting();
    }


}
