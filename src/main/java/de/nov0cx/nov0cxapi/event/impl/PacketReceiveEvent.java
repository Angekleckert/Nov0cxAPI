package de.nov0cx.nov0cxapi.event.impl;

import de.nov0cx.nov0cxapi.annotation.Handle;
import de.nov0cx.nov0cxapi.event.Nov0cxEvent;
import de.nov0cx.nov0cxapi.event.Synchronization;
import de.nov0cx.nov0cxapi.wrapper.Wrapper;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Getter
public class PacketReceiveEvent extends Nov0cxEvent {

    private final Wrapper wrapper;
    private final Player player;

    public PacketReceiveEvent(@NotNull Handle handle, Wrapper wrapper, Player player) {
        this.wrapper = wrapper;
        this.player = player;
        setAsync((handle.synchronization() == Synchronization.ASYNC));
    }
}
