package com.zimujun.ZMShieldBinding.trigger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.*;

public class OnPlayInventoryDrag implements Listener {
    private InventoryType iType = InventoryType.CRAFTING;
    private Plugin plugin;

    public OnPlayInventoryDrag(Plugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void main(InventoryDragEvent inventoryDragEvent){
        InventoryType pType = inventoryDragEvent.getInventory().getType();
        String type = inventoryDragEvent.getInventory().getTitle();
        if(pType==iType || type.equals("Chest")){
            if(inventoryDragEvent.getRawSlots().contains(52) || inventoryDragEvent.getRawSlots().contains(45)){
                inventoryDragEvent.setCancelled(true);
            }
        }


    }
}
