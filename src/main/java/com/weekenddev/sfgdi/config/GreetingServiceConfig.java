package com.weekenddev.sfgdi.config;

import com.weekenddev.pets.services.PetService;
import com.weekenddev.pets.services.PetServiceFactory;
import com.weekenddev.sfgdi.datasource.FakeDataSource;
import com.weekenddev.sfgdi.repositories.EnglishGreetingRepository;
import com.weekenddev.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.weekenddev.sfgdi.services.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@EnableConfigurationProperties(SfgConstructorConfig.class)
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(SfgConstructorConfig sfgConstructorConfig){
        FakeDataSource fakeDataSource=new FakeDataSource();
        fakeDataSource.setUserName(sfgConstructorConfig.getUserName());
        fakeDataSource.setPassword(sfgConstructorConfig.getPassword());
        fakeDataSource.setJdbcUrl(sfgConstructorConfig.getJdbcUrl());
        return fakeDataSource;
    }
    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }
    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    @Profile({"dog", "default"})
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }
    @Profile({"ES"})
    @Bean
    I18nESGreetingServiceImpl i18nService(){
        return new I18nESGreetingServiceImpl();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }
    @Profile({"EN","default"})
    @Bean("i18nService")
    I18nENGreetingServiceImpl I18nENGreetingServiceImpl( EnglishGreetingRepository   englishGreetingRepository ){
        return new I18nENGreetingServiceImpl(englishGreetingRepository);
    }
    @Primary
    @Bean
    PrimaryGreetingServiceImpl primaryGreetingServiceImpl(){
        return new PrimaryGreetingServiceImpl();
    }
    @Bean
    SetterGreetingServiceImpl setterGreetingServiceImpl(){
        return new SetterGreetingServiceImpl();
    }
/*

    @Bean
    ContructorGreetingServiceImpl contructorGreetingServiceImpl(){
        return new ContructorGreetingServiceImpl();
    }
*/

    @Bean
    PropertyGreetingServiceImpl propertyGreetingServiceImpl(){
        return new PropertyGreetingServiceImpl();
    }
}
