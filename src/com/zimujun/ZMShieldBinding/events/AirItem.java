package com.zimujun.ZMShieldBinding.events;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class AirItem {
    private ItemStack i = new ItemStack(Material.BOOK);

    public static ItemStack Build(){
        AirItem air = new AirItem();
        ItemStack i = air.getI();
        ItemMeta im = i.getItemMeta();
        List<String> lore = new ArrayList<String>();
        lore.add("这是用来当作空气的书");
        lore.add("将他放在第一个位置就可以");
        im.setDisplayName("AIR");
        im.setLore(lore);
        i.setItemMeta(im);
        return i;
    }

    public ItemStack getI() {
        return i;
    }
}
