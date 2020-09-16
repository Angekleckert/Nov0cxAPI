package de.nov0cx.nov0cxapi.packet;

import de.nov0cx.nov0cxapi.Nov0cxAPI;
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
        Nov0cxAPI.getAPI().getDataManager().insert(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Nov0cxAPI.getAPI().getDataManager().remove(player);
        Channel channel = ((CraftPlayer)player).getHandle().playerConnection.networkManager.channel;
        channel.eventLoop().submit(() -> {
           channel.pipeline().remove(player.getName());
           return null;
        });

    }
}
