package ru.otus.example.beansscopesdemo.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

public class AppMoodScope extends SessionScope {
    private static final String SONG_PARAMETER = "song";
    private static final int APP_MOOD_SCOPE = 100500;

    public static final String NAME = "appMood";

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        var attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        var mutex = RequestContextHolder.currentRequestAttributes().getSessionMutex();
        //noinspection SynchronizationOnLocalVariableOrMethodParameter
        synchronized (mutex) {
            var scopedObject = super.get(name, objectFactory);

            if (attributes.getRequest().getParameter(SONG_PARAMETER) != null) {
                scopedObject = objectFactory.getObject();
                attributes.setAttribute(name, scopedObject, getScope());
                var retrievedObject = attributes.getAttribute(name, getScope());
                if (retrievedObject != null) {
                    scopedObject = retrievedObject;
                }
            }
            return scopedObject;
        }
    }

    @Override
    protected int getScope() {
        return APP_MOOD_SCOPE;
    }
}
