package de.nov0cx.nov0cxapi.data;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;

@Getter
public class DataManager {
    private final ArrayList<PlayerData> dataArrayList = new ArrayList<>();

    public void insert(Player player) {
        dataArrayList.add(new PlayerData(player));
    }

    public PlayerData get(Player player) {
        return dataArrayList.stream().filter(data -> data.getPlayer().equals(player)).findFirst().orElse(null);
    }

    public void remove(Player player) {
        dataArrayList.remove(get(player));
    }
}
