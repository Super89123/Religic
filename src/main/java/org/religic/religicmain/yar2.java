package org.religic.religicmain;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class yar2 implements CommandExecutor {
    private ReligicMain plugin;
    public yar2(ReligicMain plugin){
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(command.getName().equalsIgnoreCase("yar2")) { // Если игрок ввёл /basic тогда делаем следующее...

            boolean b = commandSender.hasPermission("yar");
            int yarik = this.plugin.getConfig().getInt("yarik");
            String name = commandSender.getName();
            if (b) {
                if (yarik >= 2) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give " + name + " minecraft:absorption 300 0 true");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give " + name + " minecraft:regeneration 300 4 true");
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
