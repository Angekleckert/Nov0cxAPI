package de.nov0cx.nov0cxapi.example;

import de.nov0cx.nov0cxapi.Nov0cxAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class ExampleMain extends JavaPlugin {

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        Nov0cxAPI.getAPI().getEventManager().registerListener(new ExampleListener());
    }
}
