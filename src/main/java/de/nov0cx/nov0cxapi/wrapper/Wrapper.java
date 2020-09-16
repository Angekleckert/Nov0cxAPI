package de.nov0cx.nov0cxapi.wrapper;

import de.nov0cx.nov0cxapi.annotation.WrappedPacket;
import de.nov0cx.nov0cxapi.exceptions.FieldNotFoundException;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

@Getter
public class Wrapper {
    private final Field[] fields;
    private final Object packet;
    private final String name;

    public Wrapper(@NotNull Object packet) {
        this.packet = packet;
        fields = packet.getClass().getDeclaredFields();
        WrappedPacket wrappedPacket = this.getClass().getAnnotation(WrappedPacket.class);
        name = wrappedPacket.name();
    }

    public Field getField(Class<?> type, int index) throws FieldNotFoundException {
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
}
