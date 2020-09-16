package de.nov0cx.nov0cxapi.wrapper.impl.client;

import de.nov0cx.nov0cxapi.annotation.WrappedPacket;
import de.nov0cx.nov0cxapi.wrapper.Wrapper;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@WrappedPacket(name = "WrappedPacketPlayInFlying")
public class WrappedPacketPlayInFlying extends Wrapper {

    private final double x, y, z;
    private final float yaw, pitch;
    private final boolean pos, look, onGround;

    private final Type flyingType;

    public WrappedPacketPlayInFlying(@NotNull Object packet) {
        super(packet);

        x = getDouble(0);
        y = getDouble(1);
        z = getDouble(2);
        yaw = getFloat(0);
        pitch = getFloat(1);
        pos = getBoolean(1);
        look = getBoolean(2);
        onGround = getBoolean(0);

        if (pos && look) {
            flyingType = Type.POSITION_LOOK;
        } else if (pos) {
            flyingType = Type.POSITION;
        } else if (look) {
            flyingType = Type.LOOK;
        } else flyingType = Type.NONE;
    }

    public enum Type {
        LOOK, POSITION, POSITION_LOOK, NONE
    }
}
