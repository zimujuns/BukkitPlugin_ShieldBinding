package com.zimujun.ZMShieldBinding.trigger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.plugin.Plugin;

public class OnPlayInventoryMove implements Listener {

    public OnPlayInventoryMove(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void main(InventoryMoveItemEvent e){
        e.setCancelled(true);

    }
}
