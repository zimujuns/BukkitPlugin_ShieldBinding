package com.zimujun.ZMShieldBinding.events;

import com.zimujun.ZMShieldBinding.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemGui {
    private Inventory gui = Bukkit.createInventory(null ,54,"设置副手");

    public ItemGui() {
        main();
    }

    public void main(){
        int size = Main.configItemDataList.size();
        for(int i=0;i<size;i++){
            String itype = Main.configItemDataList.get(i);
            if(itype.equals("AIR")){
                gui.setItem(i,AirItem.Build());
                continue;
            }
            gui.setItem(i, new ItemStack(Material.valueOf(itype)));
        }
    }

    public Inventory getGui(){
        return gui;
    }
}
