package org.religic.religicmain;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class firebeam implements CommandExecutor {
    private ReligicMain plugin;
    public firebeam(ReligicMain plugin){this.plugin = plugin;}
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (command.getName().equalsIgnoreCase("firebeam") && sender.hasPermission("gensh")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Команда только для игроков!");
                return true;
            }

            Player player = (Player) sender;
            Location playerEyeLocation = player.getEyeLocation();
            Location targetLocation = playerEyeLocation.add(playerEyeLocation.getDirection().multiply(10));

            // Создаем луч из частиц огня
            for (int i = 0; i < 10; i++) {
                playerEyeLocation.getWorld().spawnParticle(Particle.FLAME, playerEyeLocation, 1);
                playerEyeLocation.add(playerEyeLocation.getDirection());

                // Получаем всех окружающих сущностей в радиусе 1 блок от промежуточной точки
                for (Entity entity : playerEyeLocation.getWorld().getNearbyEntities(playerEyeLocation, 1, 1, 1)) {
                    if (entity instanceof LivingEntity && entity != player) {
                        LivingEntity livingTarget = (LivingEntity) entity;
                        livingTarget.setFireTicks(100); // Поджигаем врага на 1сек (20 тиков)
                        livingTarget.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 3 * 20, 0)); // Накладываем эффект тошноты на 3 секунды
                        livingTarget.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 3 * 20, 1)); // Накладываем эффект замедления на 3 секунды
                    }
                }
            }

            return true;
        }


        return false;
    }


}
