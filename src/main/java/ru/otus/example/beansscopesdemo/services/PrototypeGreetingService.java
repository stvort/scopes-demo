package ru.otus.example.beansscopesdemo.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope(scopeName = "prototype")
@Service
public class PrototypeGreetingService extends AbstractGreetingService {
}
