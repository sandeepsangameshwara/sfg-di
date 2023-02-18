package com.weekenddev.sfgdi.controllers;

import com.weekenddev.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    @Qualifier("propertyGreetingServiceImpl")
    @Autowired
    GreetingService greetingService;
    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
