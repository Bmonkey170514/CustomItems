package me.bmonkey.items.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class AddRp implements Listener {

    @EventHandler
    public void addRp(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.setResourcePack("https://www.dropbox.com/sh/mr2jmzz42681453/AABCsHlEoFMuv-FCI7dzZKS-a?dl=1");
    }
}
