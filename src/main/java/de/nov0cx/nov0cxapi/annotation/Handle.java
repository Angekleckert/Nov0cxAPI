package de.nov0cx.nov0cxapi.annotation;

import de.nov0cx.nov0cxapi.event.Synchronization;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Handle {
    Synchronization synchronization() default Synchronization.ASYNC;
}
