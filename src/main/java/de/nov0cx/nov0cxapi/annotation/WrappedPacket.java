package de.nov0cx.nov0cxapi.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WrappedPacket {
    String name();
}
