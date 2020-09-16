# Nov0cxAPI
 
 To make a listener you have to do that:
 
  public class ExampleListener implements Nov0cxListener {
  
     @Handle(/*You can change it to sync*/)
     public void onReceive(PacketReceiveEvent event) {
         if(event.getId().equals(Packet.Client.WrappedPacketPlayInFlying)) {
             WrappedPacketPlayInFlying wrappedPacketPlayInFlying = new WrappedPacketPlayInFlying(event.getNms());
         }
     }
 }
 
 
 You register the class like that:
 
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
 
 If you want to start and stop your plugin with ur plugin you have to do this:
 
 package de.nov0cx.nov0cxapi.example;

import de.nov0cx.nov0cxapi.Nov0cxAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class ExampleMain extends JavaPlugin {

    @Override
    public void onDisable() {
        Nov0cxAPI.getAPI().onDisable();
    }

    @Override
    public void onEnable() {
        Nov0cxAPI.getAPI().onEnable();
    }
}
 
 If you want to use some code you can do it. You have to give credits.
