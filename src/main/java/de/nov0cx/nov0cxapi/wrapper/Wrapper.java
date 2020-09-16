package de.nov0cx.nov0cxapi.wrapper;

import de.nov0cx.nov0cxapi.annotation.WrappedPacket;
import de.nov0cx.nov0cxapi.exceptions.FieldNotFoundException;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

@Getter
public class Wrapper {
    private final Field[] fields;
    private final Object rawPacket;
    private final String name;

    public Wrapper(@NotNull Object packet) {
        this.rawPacket = packet;
        fields = packet.getClass().getDeclaredFields();
        WrappedPacket wrappedPacket = this.getClass().getAnnotation(WrappedPacket.class);
        name = wrappedPacket.name();
    }

    public Object getField(Class<?> type, int index) throws FieldNotFoundException {
        int i = 0;
        for(Field field : fields) {
            if(field.getType().equals(type)) {
                if(i == index) {
                    return field;
                } else i++;
            }
        }
        throw new FieldNotFoundException("The field couldn't be found: " + type + " with the index: " + index + ".");
    }

    public int getInt(int index){
        try {
            return (int) getField(int.class, index);
        } catch (FieldNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public float getFloat(int index) {
        try {
            return (float) getField(float.class, index);
        } catch (FieldNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public double getDouble(int index) {
        try {
            return (double) getField(double.class, index);
        } catch (FieldNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean getBoolean(int index) {
        try {
            return (boolean) getField(boolean.class, index);
        } catch (FieldNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public long getLong(int index) {
        try {
            return (long) getField(long.class, index);
        } catch (FieldNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
