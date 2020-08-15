package com.zimujun.ZMShieldBinding;

import com.zimujun.ZMShieldBinding.events.ItemGui;
import com.zimujun.ZMShieldBinding.trigger.*;
import com.zimujun.ZMShieldBinding.utils.ConfigData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class Main extends JavaPlugin {
//    public static Map<String, PlayData> ShieldEnduranceDate = new HashMap<String, PlayData>();
    public Inventory iList;

    public static List<String> configItemDataList;
    public static String permissionSetConfig,permissionReload;

    public static long time = 0L;

    public ConfigData configData = new ConfigData(this);

    @Override
    public void onEnable() {
        OnlinePlayRegister();
        //对副手的操作
        new OnPlayInventoryDrag(this);
        new OnPlayInventoryClick(this);
        new OnPlayInventoryClose(this);
        new OnPlaySwapHand(this);
        new OnPlayInventoryMove(this);
        setMainString();
        ItemGui iG = new ItemGui();
        iList = iG.getGui();

    }

    @Override
    public void onDisable() {
        configData.reload();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player) || sender.hasPermission(permissionReload)){
            if(args.length!=0&&args[0].equalsIgnoreCase("reload")){
                reloadConfig();
                configData = new ConfigData(this);
                setMainString();
                System.out.println(this.getName()+":插件已重载完毕~如有报错,请及时汇报嗷~");
                System.out.println("请勿倒卖 作者QQ:2727295521");
                return true;
            }
        }
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            try {
                if (args[0].equalsIgnoreCase("open") && player.hasPermission(permissionSetConfig)) {
                    player.openInventory(iList);
                    return true;
                }else{
                    player.sendMessage("你当前输入的指令有🌫[误]！");
                    return false;
                }
            }catch (ArrayIndexOutOfBoundsException e){
                player.sendMessage("你当前输入的指令有🌫[误]！请输入/zmpi open来打开设置背包");
                return false;
            }
        }
        return false;
    }






    public void OnlinePlayRegister(){
        for(Player player : Bukkit.getOnlinePlayers()){
            player.kickPlayer("服务器重启,请重新登入,谢谢");
        }
    }
    public void setMainString() {
        permissionReload = "ZMShieldBinding.reload";
        permissionSetConfig = "ZMShieldBinding.setGui";
        configItemDataList = configData.getData();
    }
}
