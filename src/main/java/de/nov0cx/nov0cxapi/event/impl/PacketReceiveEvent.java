package de.nov0cx.nov0cxapi.event.impl;

import de.nov0cx.nov0cxapi.event.Nov0cxEvent;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class PacketReceiveEvent extends Nov0cxEvent {

    private final String id;
    private final Player player;
    private final Object nms;

    public PacketReceiveEvent(Player player, Object packet, String id) {
        this.player = player;
        nms = packet;
        this.id = id;
    }
}
