package com.weekenddev.sfgdi.controllers;

import com.weekenddev.sfgdi.services.ContructorGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {
    public ConstructorInjectedController controller;

    @BeforeEach
    void setUp() {
        controller=new ConstructorInjectedController(new ContructorGreetingServiceImpl());
    }
    @Test
    void sayHello() {
        System.out.println(controller.sayHello());
    }
}