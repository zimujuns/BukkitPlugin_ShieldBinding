package com.zimujun.ZMShieldBinding.trigger;

import com.zimujun.ZMShieldBinding.Main;
import com.zimujun.ZMShieldBinding.events.ItemGui;
import com.zimujun.ZMShieldBinding.utils.ConfigData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.*;

import java.util.ArrayList;
import java.util.List;

public class OnPlayInventoryClose implements Listener {
    private Plugin plugin;

    public OnPlayInventoryClose(Plugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void main(InventoryCloseEvent inventoryCloseEvent){
        String title = inventoryCloseEvent.getInventory().getTitle();
        if(title.equals("设置副手")){
            Inventory inventory = inventoryCloseEvent.getInventory();
            ItemStack[] iItem = inventory.getContents();
            List<String> list = new ArrayList();
            for(int i=0;i<inventory.firstEmpty();i++){
                System.out.println("载入成功" + iItem[i].getType().toString());
                if(iItem[i].getItemMeta().getDisplayName()!=null && iItem[i].getItemMeta().getDisplayName().equals("AIR")){
                    list.add("AIR");
                    continue;
                }
                list.add(iItem[i].getType().toString());

            }
            Main.configItemDataList = list;
            ConfigData.saveList();
        }


    }

}
