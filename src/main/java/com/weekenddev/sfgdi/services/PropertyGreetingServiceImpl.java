package com.weekenddev.sfgdi.services;

import org.springframework.stereotype.Service;

public class PropertyGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - Property";
    }
}
