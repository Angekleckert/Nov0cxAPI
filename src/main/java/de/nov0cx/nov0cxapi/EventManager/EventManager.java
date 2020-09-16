package de.nov0cx.nov0cxapi.EventManager;

import de.nov0cx.nov0cxapi.Nov0cxAPI;
import de.nov0cx.nov0cxapi.annotation.Handle;
import de.nov0cx.nov0cxapi.event.Nov0cxEvent;
import de.nov0cx.nov0cxapi.event.Nov0cxListener;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class EventManager {

    private final HashMap<Nov0cxListener, ArrayList<Method>> registeredMethods = new HashMap<>();

    public void registerListener(@NotNull Nov0cxListener nov0cxListener) {
        for(Method method : nov0cxListener.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(Handle.class)) {
                if(method.getParameters().length == 1 && method.getParameterTypes()[0].equals(Nov0cxEvent.class)) {
                    if(!registeredMethods.containsKey(nov0cxListener)) {
                        ArrayList<Method> methods = new ArrayList<>();
                        methods.add(method);
                        registeredMethods.put(nov0cxListener, methods);
                        return;
                    } else {
                        ArrayList<Method> methods = registeredMethods.get(nov0cxListener);
                        methods.add(method);
                        registeredMethods.replace(nov0cxListener, methods);
                    }
                }
            }
        }
    }

    public void call(Nov0cxEvent event) {
        for(Nov0cxListener nov0cxListener : registeredMethods.keySet()) {
            for(Method method : registeredMethods.get(nov0cxListener)) {
                Handle handle = method.getAnnotation(Handle.class);
                Runnable invoke = new Runnable() {
                    @SneakyThrows
                    @Override
                    public void run() {
                        method.invoke(nov0cxListener, event);
                    }
                };

                switch (handle.synchronization()) {
                    case SYNC: {
                        Bukkit.getScheduler().runTask(Nov0cxAPI.getAPI(), invoke);
                        break;
                    }
                    case ASYNC: {
                        Bukkit.getScheduler().runTaskAsynchronously(Nov0cxAPI.getAPI(), invoke);
                        break;
                    }
                }
            }
        }
    }
}
