package org.religic.religicmain;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class yar10 implements CommandExecutor {
    private ReligicMain plugin;
    public yar10(ReligicMain plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(command.getName().equalsIgnoreCase("yar10")){
            boolean b = commandSender.hasPermission("yar");
            int yarik = this.plugin.getConfig().getInt("yarik");
            String name = commandSender.getName();
            if (b) {
                if (yarik >= 10) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+ name+ " permission set *");
                    Bukkit.dispatchCommand(commandSender, "effect give @a[sort=arbitrary,distance=0..15,gamemode=survival,team=yarik] minecraft:strength 180 2 true");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+ name+ " permission unset *");

                } else {
                    commandSender.sendMessage("Ваша религия еще недостаточно сильна");
                }

            } else {
                commandSender.sendMessage("Вы причислены не к этой религии!");

            }
            return true;



        }
        return false;
    }
}
