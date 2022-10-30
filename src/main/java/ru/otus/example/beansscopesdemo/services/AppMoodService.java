package ru.otus.example.beansscopesdemo.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.otus.example.beansscopesdemo.scope.AppMoodScope;

import java.util.concurrent.atomic.AtomicInteger;

@Scope(value = AppMoodScope.NAME, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class AppMoodService {
    private final AtomicInteger appMoodLevel = new AtomicInteger(100);

    public int getAppMoodLevel() {
        return appMoodLevel.get();
    }

    public void decreaseAppMoodLevel() {
        var currentLevel = appMoodLevel.get();
        var newLevel = Math.max(currentLevel - 10, 0);
        appMoodLevel.compareAndSet(currentLevel, newLevel);
    }
}
