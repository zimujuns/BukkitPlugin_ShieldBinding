package com.zimujun.ZMShieldBinding.utils;

import com.zimujun.ZMShieldBinding.Main;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class ConfigData {
    /**
     * 作为读取Config的类
     */
    public static Plugin plugin;
    private FileConfiguration fileConfiguration;
    private List<String> data;

    public ConfigData(Plugin plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        this.fileConfiguration = plugin.getConfig();
        this.data = (List<String>) fileConfiguration.get("item");
    }

    /**
     * 重载
     */
    public static void reload(){
        plugin.reloadConfig();
    }

    /**
     * 保存
     */
    public static void save(){
        plugin.saveConfig();
    }

    public List<String> getData() {
        return this.data;
    }

    public static void saveList(){
        FileConfiguration fileConfiguration = plugin.getConfig();
        fileConfiguration.set("item", Main.configItemDataList);
        save();
    }





}
