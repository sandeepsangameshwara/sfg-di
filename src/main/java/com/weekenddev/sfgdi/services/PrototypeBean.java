package com.weekenddev.sfgdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("In PrototypeBean constructor");
    }
    
    public void getBeanScope(){
        System.out.println("In PrototypeBean Scope");
    }
}
