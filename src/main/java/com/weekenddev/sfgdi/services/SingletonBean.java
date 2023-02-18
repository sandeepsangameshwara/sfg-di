package com.weekenddev.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    public SingletonBean() {
        System.out.println("In SingletonBean constructor");
    }

    public void getBeanScope(){
        System.out.println("In Singleton Scope");
    }
}
