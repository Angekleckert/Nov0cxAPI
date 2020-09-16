package de.nov0cx.nov0cxapi.event.impl;

import de.nov0cx.nov0cxapi.event.Nov0cxEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

@Getter
@RequiredArgsConstructor
public class InjectEvent extends Nov0cxEvent {
    private final Player player;
}
