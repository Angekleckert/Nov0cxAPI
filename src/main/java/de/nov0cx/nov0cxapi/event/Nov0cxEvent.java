package de.nov0cx.nov0cxapi.event;

import de.nov0cx.nov0cxapi.annotation.Async;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Nov0cxEvent {
    @Setter
    private boolean async;

    public Nov0cxEvent() {
        this.async = (this.getClass().isAnnotationPresent(Async.class));
    }
}
