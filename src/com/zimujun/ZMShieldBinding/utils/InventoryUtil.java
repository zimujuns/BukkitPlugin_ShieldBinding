package com.zimujun.ZMShieldBinding.utils;
import org.bukkit.Material;

import java.util.List;

public class InventoryUtil {
    public static Boolean main(List<String> list, Material material){
        for(String item:list){
            if(material == Material.valueOf(item)){
                return true;
            }
        }
        return false;
    }
}
