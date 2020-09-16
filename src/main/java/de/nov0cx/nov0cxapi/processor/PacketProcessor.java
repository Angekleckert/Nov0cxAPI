package de.nov0cx.nov0cxapi.processor;

import de.nov0cx.nov0cxapi.Nov0cxAPI;
import de.nov0cx.nov0cxapi.event.impl.PacketReceiveEvent;
import net.minecraft.server.v1_8_R3.PacketPlayInFlying;
import org.bukkit.entity.Player;

public class PacketProcessor {
    public void process(Object packet, Direction direction, Player player) {
        switch(direction) {
            case SEND: {
                break;
            }
            case RECEIVE: {
                if(packet.getClass().getSimpleName().equalsIgnoreCase(PacketPlayInFlying.class.getSimpleName())) {
                    Nov0cxAPI.getAPI().getEventManager().call(new PacketReceiveEvent(player, packet, "WrappedPacketPlayInFlying"));
                }
                break;
            }
        }
    }
}
