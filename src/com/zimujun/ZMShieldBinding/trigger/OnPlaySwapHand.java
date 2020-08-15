package com.zimujun.ZMShieldBinding.trigger;


import com.zimujun.ZMShieldBinding.Main;
import com.zimujun.ZMShieldBinding.utils.InventoryUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.Plugin;

public class OnPlaySwapHand implements Listener {
    public Plugin plugin;

    public OnPlaySwapHand(Plugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void main(PlayerSwapHandItemsEvent playerSwapHandItemsEvent){
        if(!InventoryUtil.main(Main.configItemDataList,playerSwapHandItemsEvent.getOffHandItem().getType())){
            playerSwapHandItemsEvent.setCancelled(true);
        }
    }
}
