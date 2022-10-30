package ru.otus.example.beansscopesdemo.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope(scopeName = "singleton")
@Service
public class SingletonGreetingService extends AbstractGreetingService {
}
