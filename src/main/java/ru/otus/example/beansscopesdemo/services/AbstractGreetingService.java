package ru.otus.example.beansscopesdemo.services;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractGreetingService {

    private final AtomicInteger counter= new AtomicInteger(0);

    public String greeting() {
        return currentGreeting();
    }

    private String currentGreeting() {
        return String.format("Привет! Это наша встреча №%d. Меня зовут: %s",
                counter.incrementAndGet(), Integer.toHexString(hashCode()));
    }
}
