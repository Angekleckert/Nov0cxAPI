package de.nov0cx.nov0cxapi.example;

import de.nov0cx.nov0cxapi.annotation.Handle;
import de.nov0cx.nov0cxapi.event.Nov0cxListener;
import de.nov0cx.nov0cxapi.event.impl.PacketReceiveEvent;

public class ExampleListener implements Nov0cxListener {
    @Handle
    public void onReceive(PacketReceiveEvent event) {

    }
}
