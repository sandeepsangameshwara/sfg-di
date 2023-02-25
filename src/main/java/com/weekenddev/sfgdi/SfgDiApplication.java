package com.weekenddev.sfgdi;

import com.weekenddev.sfgdi.config.SfgConfiguration;
import com.weekenddev.sfgdi.controllers.*;
import com.weekenddev.sfgdi.datasource.FakeDataSource;
import com.weekenddev.sfgdi.services.PrototypeBean;
import com.weekenddev.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SfgDiApplication.class, args);
		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		MyController myController=(MyController)ctx.getBean("myController");
		System.out.println("Greeting:"+myController.sayHello());

		System.out.println("-------------- Property Injected");
		PropertyInjectedController propertyInjectedController=(PropertyInjectedController)ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.sayHello());

		System.out.println("-------------- Setter Injected");
		SetterInjectedController setterInjectedController=(SetterInjectedController)ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.sayHello());

		System.out.println("-------------- Contructor Injected");
		ConstructorInjectedController constructorInjectedController=(ConstructorInjectedController)ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.sayHello());

		System.out.println("-------------- Profile Example");
		I18nController i18nController=(I18nController)ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		System.out.println("-------------- Bean Scope test");
		SingletonBean singletonBean1=ctx.getBean(SingletonBean.class);
		singletonBean1.getBeanScope();
		SingletonBean singletonBean2=ctx.getBean(SingletonBean.class);
		singletonBean2.getBeanScope();

		PrototypeBean prototypeBean1=ctx.getBean(PrototypeBean.class);
		prototypeBean1.getBeanScope();
		PrototypeBean prototypeBean2=ctx.getBean(PrototypeBean.class);
		prototypeBean2.getBeanScope();

		System.out.println("-------------- Accessing properties from Property file");
		FakeDataSource fakeDataSource=ctx.getBean(FakeDataSource.class);
		System.out.println("Username :"+fakeDataSource.getUserName());
		System.out.println("Password :"+fakeDataSource.getPassword());
		System.out.println("JDBCUrl :"+fakeDataSource.getJdbcUrl());

		System.out.println("-------------- Accessing properties from Property file");
		SfgConfiguration sfgConfiguration=ctx.getBean(SfgConfiguration.class);
		System.out.println("Username :"+sfgConfiguration.getUserName());
		System.out.println("Password :"+sfgConfiguration.getPassword());
		System.out.println("JDBCUrl :"+sfgConfiguration.getJdbcUrl());

	}

}
