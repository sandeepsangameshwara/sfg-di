package com.weekenddev.sfgdi.services;

import com.weekenddev.sfgdi.repositories.EnglishGreetingRepository;

public class I18nENGreetingServiceImpl implements GreetingService {

    private final EnglishGreetingRepository englishGreetingRepository;
    public I18nENGreetingServiceImpl(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }


    @Override
    public String sayGreeting() {
        return englishGreetingRepository.getGreeting();
    }
}
