package ru.otus.example.beansscopesdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.example.beansscopesdemo.services.PrototypeGreetingService;
import ru.otus.example.beansscopesdemo.services.RequestGreetingService;
import ru.otus.example.beansscopesdemo.services.SessionGreetingService;
import ru.otus.example.beansscopesdemo.services.SingletonGreetingService;

@Controller
@RequiredArgsConstructor
public class GreetingController {
    private final SingletonGreetingService singletonGreetingService;
    private final PrototypeGreetingService prototypeGreetingService1;
    private final PrototypeGreetingService prototypeGreetingService2;
    private final SessionGreetingService sessionGreetingService;
    private final RequestGreetingService requestGreetingService;


    @GetMapping("/")
    public String greetingPage(Model model) {
        model.addAttribute("singletonGreeting", singletonGreetingService.greeting());
        model.addAttribute("sessionGreeting", sessionGreetingService.greeting());
        model.addAttribute("requestGreeting", requestGreetingService.greeting());
        model.addAttribute("prototype1Greeting", prototypeGreetingService1.greeting());
        model.addAttribute("prototype2Greeting", prototypeGreetingService2.greeting());
        return "index";
    }
}
