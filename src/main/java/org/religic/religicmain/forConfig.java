package org.religic.religicmain;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class forConfig implements CommandExecutor {
    public ReligicMain plugin;
    public forConfig(ReligicMain plugin){
        this.plugin = plugin;

    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        int satana = plugin.getConfig().getInt("satana");
        int genshin = plugin.getConfig().getInt("genshin");
        int yarik = plugin.getConfig().getInt("yarik");
        String ss = "satana";
        String sss = "genshin";
        String ssss = "yarik";
        int test = Integer.parseInt(args[1]);
        if (command.getName().equalsIgnoreCase("configset") && sender.hasPermission("verhov")) {
            if (args[0].equalsIgnoreCase(ss)) {
                plugin.getConfig().set("satana", test);
                plugin.saveConfig();
                return true;
            }
            if(args[0].equalsIgnoreCase(sss)){
                plugin.getConfig().set(sss, test);
                return  true;
            }
            if(args[0].equalsIgnoreCase(ssss)){
                plugin.getConfig().set(ssss, test);
            }

            return true;
        }
        else {
            return false;
        }
    }
}





