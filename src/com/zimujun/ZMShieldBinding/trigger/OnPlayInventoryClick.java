package com.zimujun.ZMShieldBinding.trigger;

import com.zimujun.ZMShieldBinding.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;

import org.bukkit.plugin.*;

public class OnPlayInventoryClick implements Listener {
    private static final InventoryType invType = InventoryType.PLAYER;

    public OnPlayInventoryClick(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void main(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getClickedInventory() == null) {
            return;
        }
        switch (inventoryClickEvent.getClick()){
            case LEFT:
            case SHIFT_LEFT:
            case RIGHT:
            case SHIFT_RIGHT:
                InventoryType type = inventoryClickEvent.getClickedInventory().getType();
                int slot = inventoryClickEvent.getRawSlot();
                if(type == invType){
                    switch (slot){
                        case 45:
                        case 52:
                            if (isItem(inventoryClickEvent.getCursor()) || isItem(inventoryClickEvent.getCurrentItem()))
                                inventoryClickEvent.setCancelled(true);
                            break;

                    }
                }
                break;
            case NUMBER_KEY:
                inventoryClickEvent.setCancelled(true);
                break;
        }


    }


    public Boolean isItem(ItemStack i){
        String type = i.getType().toString();
        if(Main.configItemDataList.contains(type)){
            return false;
        }
        return true;

    }
}
