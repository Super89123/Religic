package org.religic.religicmain;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class yarultimate {
    private ReligicMain plugin;
    public  yarultimate(ReligicMain plugin){this.plugin = plugin;}


//    @Override
//    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
//        int yarik = plugin.getConfig().getInt("yarik");
//        if(command.getName().equalsIgnoreCase("yarultimate") && sender.hasPermission("yarik")){
//            if(yarik >= 30){
//                Player player = (Player) sender;
//                for (Player target : Bukkit.getOnlinePlayers()) {
//                    if (sender instanceof Player && target.equals(sender))
//                        continue; // Пропускаем отправителя команды
//
//                    if (target.getLocation().distance(sender.getLocation()) <= 100 &&
//                            (target.hasPermission("sata") || target.hasPermission("gensh"))) {
//                        launchPlayer(target, 250);
//                    }
//                }
//
//                return true;
//            }
//
//            private void launchPlayer(Player player, int height) {
//                player.setVelocity(new Vector(0, height, 0));
//
//
//            }
//
//
//        }
//        return false;
//    }

    public void throwPlayers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("sata") || player.hasPermission("gensh")) {
                Location location = player.getLocation();
                location.add(0, 250, 0);
                player.teleport(location);
            }
        }
    }
}
