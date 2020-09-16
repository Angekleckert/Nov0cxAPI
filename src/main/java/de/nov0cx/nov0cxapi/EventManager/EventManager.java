package de.nov0cx.nov0cxapi.EventManager;

import de.nov0cx.nov0cxapi.annotation.Handle;
import de.nov0cx.nov0cxapi.event.Nov0cxEvent;
import de.nov0cx.nov0cxapi.event.Nov0cxListener;
import lombok.Getter;

import java.lang.reflect.Method;
import java.util.ArrayList;

@Getter
public class EventManager {

    private final ArrayList<Method> listenerMethods = new ArrayList<>();

    public void registerListener(Nov0cxListener nov0cxListener) {
        for(Method method : nov0cxListener.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(Handle.class)) {
                if(method.getParameters().length == 1 && method.getParameterTypes()[0].equals(Nov0cxEvent.class)) {
                    listenerMethods.add(method);
                }
            }
        }
    }
}
