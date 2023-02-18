package com.weekenddev.sfgdi.controllers;

import com.weekenddev.sfgdi.services.ContructorGreetingServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {
    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller=new PropertyInjectedController();
        controller.greetingService=new ContructorGreetingServiceImpl();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void sayHello() {
        System.out.println(controller.sayHello());
    }
}