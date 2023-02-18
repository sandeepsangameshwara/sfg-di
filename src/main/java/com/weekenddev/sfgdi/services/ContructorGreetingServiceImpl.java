package com.weekenddev.sfgdi.services;

import org.springframework.stereotype.Service;

public class ContructorGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - Constructor";
    }
}
