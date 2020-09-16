package de.nov0cx.nov0cxapi.example;

import de.nov0cx.nov0cxapi.annotation.Handle;
import de.nov0cx.nov0cxapi.event.Nov0cxListener;
import de.nov0cx.nov0cxapi.event.impl.PacketReceiveEvent;
import de.nov0cx.nov0cxapi.packet.Packet;
import de.nov0cx.nov0cxapi.wrapper.impl.client.WrappedPacketPlayInFlying;

public class ExampleListener implements Nov0cxListener {
    @Handle(/*You can change it to sync*/)
    public void onReceive(PacketReceiveEvent event) {
        if(event.getId().equals(Packet.Client.WrappedPacketPlayInFlying)) {
            WrappedPacketPlayInFlying wrappedPacketPlayInFlying = new WrappedPacketPlayInFlying(event.getNms());
        }
    }
}
