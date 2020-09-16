package de.nov0cx.nov0cxapi.data;

import de.nov0cx.nov0cxapi.Nov0cxAPI;
import de.nov0cx.nov0cxapi.processor.Direction;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import lombok.Getter;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

@Getter
public class PlayerData {
    private final ChannelDuplexHandler cdh;
    private final Player player;

    public PlayerData(Player player) {
        this.player = player;
        cdh = new ChannelDuplexHandler() {
            @Override
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {
                Nov0cxAPI.getAPI().getPacketProcessor().process(packet, Direction.RECEIVE);
                super.channelRead(channelHandlerContext, packet);
            }

            @Override
            public void write(ChannelHandlerContext channelHandlerContext, Object packet, ChannelPromise channelPromise) throws Exception {
                Nov0cxAPI.getAPI().getPacketProcessor().process(packet, Direction.SEND);
                super.write(channelHandlerContext, packet, channelPromise);
            }
        };
        ChannelPipeline channelPipeline = ((CraftPlayer)player).getHandle().playerConnection.networkManager.channel.pipeline();
        channelPipeline.addBefore("packet_handler", player.getName(), cdh);
    }

}
