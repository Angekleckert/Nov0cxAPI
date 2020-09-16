package de.nov0cx.nov0cxapi.packet;

import de.nov0cx.nov0cxapi.Nov0cxAPI;
import de.nov0cx.nov0cxapi.event.impl.InjectEvent;
import de.nov0cx.nov0cxapi.event.impl.UninjectEvent;
import io.netty.channel.Channel;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Handler implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Nov0cxAPI.getAPI().getDataManager().insert(player);
        Nov0cxAPI.getAPI().getEventManager().call(new InjectEvent(player));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Nov0cxAPI.getAPI().getDataManager().remove(player);
        uninject(player);
        Nov0cxAPI.getAPI().getEventManager().call(new UninjectEvent(player));
    }

    public void uninject(Player player) {
        Channel channel = ((CraftPlayer)player).getHandle().playerConnection.networkManager.channel;
        channel.eventLoop().submit(() -> {
            channel.pipeline().remove(player.getName());
            return null;
        });
    }
}
