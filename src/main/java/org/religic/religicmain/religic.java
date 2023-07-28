package org.religic.religicmain;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
/*
Боже, когда я зканочу писать религии...
Я бьюсь над ними уже 5 час...
Я верю осталось немного
Всего лишь надо написать проверку прав у игроков...
И если у них будут эти права
И если в какой либо религии будет определенное число последователей
То в ТЕОРИИ ВСЕ ДОЛЖНО ЗАРАБОТАТЬ!!!!

...
Уже 30 часов позади
Но я только начал.
Сейчас я наверно пойду спать
А завтра наконец то разберусь с конфигом.
 */
public class religic implements Listener {
    private ReligicMain plugin;

    public religic(ReligicMain plugin) {
        this.plugin = plugin;
    }



    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        int test = 1;
        int satana = this.plugin.getConfig().getInt("satana");
        int genshin = this.plugin.getConfig().getInt("genshin");
        int yarik = this.plugin.getConfig().getInt("yarik");

        Random rand = new Random();
        int max = 3, min = 1;
        int random = rand.nextInt(max - min + 1) + min;
        Player p  = event.getPlayer();
        String name = p.getName();
        if(!p.hasPlayedBefore()){
            if(random == 1){
                satana++;
                plugin.getConfig().set("satana", satana);
                plugin.saveConfig();
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + name + " parent set sata");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team join satana "+ name);
                p.chat("!&6Ура, я пресоседенился к религии &9Сатанистов!");
            }
            else if (random == 2) {
                genshin++;
                plugin.getConfig().set("genshin", genshin);
                plugin.saveConfig();
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + name + " parent set gensh");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team join genshin "+ name);
                p.chat("!&6Ура, я пресоседенился к религии &9Архонтов!");

            }
            else {
                yarik++;
                plugin.getConfig().set("yarik", yarik);
                plugin.saveConfig();
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + name + " parent set yar");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team join yarik "+ name);
                p.chat("!&6Ура, я пресоседенился к религии &9Ярика!");
            }

        }
        plugin.reloadConfig();
        if(yarik >= 15 && p.hasPermission("yar")){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give "+p.getName()+" minecraft:night_vision infinite 255 true");


        }






    }








    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent e){
        int yarik = this.plugin.getConfig().getInt("yarik");
        Player player = e.getPlayer();
        if(yarik >= 1){
            if(player.hasPermission("yar")){
                player.setWalkSpeed(0.5f);
            }
        }
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Entity en = e.getEntity().getKiller();
        int yarik = this.plugin.getConfig().getInt("yarik");
        int satana = plugin.getConfig().getInt("satana");
        if(e.getPlayer().hasPermission("yar") && yarik >= 15){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give "+e.getPlayer().getName()+" minecraft:night_vision infinite 255 true");

        }


            if(en.getType() == EntityType.PLAYER) {
                String lala = en.getName();
                Random rand = new Random();
                int max = 9, min = 0, round = 0;
                int random = rand.nextInt(max - min + 1) + min;
                int random2 = rand.nextInt(max - min + 1) + min;
                int random3 = rand.nextInt(max - min + 1) + min;
                int random4 = rand.nextInt(max - min + 1) + min;
                int random5 = rand.nextInt(max - min + 1) + min;
                String s = "Успех, вы повысили свой урон на 0.33!";
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "attribute " + lala + " minecraft:generic.attack_damage modifier add CB3F55D3-645C-4F38-A497-9C1" + random5 + "A" + random4 + random3 + "DB" + random2 + "C" + random + " sss 0.33 add");
                en.sendMessage(s);




                } else if (en.hasPermission("satana") && satana >= 10) {
                    String lala = en.getName();
                    Random rand = new Random();
                    int max = 9, min = 0, round = 0;
                    int random = rand.nextInt(max - min + 1) + min;
                    int random2 = rand.nextInt(max - min + 1) + min;
                    int random3 = rand.nextInt(max - min + 1) + min;
                    int random4 = rand.nextInt(max - min + 1) + min;
                    int random5 = rand.nextInt(max - min + 1) + min;
                    String s = "Успех, вы повысили свой урон на 0.66!";
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "attribute " + lala + " minecraft:generic.attack_damage modifier add CB3F55D3-645C-4F38-A497-9C1" + random5 + "A" + random4 + random3 + "DB" + random2 + "C" + random + " sss 0.66 add");
                    en.sendMessage(s);

                } else if (en.hasPermission("satana") && satana >= 25) {
                    String lala = en.getName();
                    Random rand = new Random();
                    int max = 9, min = 0, round = 0;
                    int random = rand.nextInt(max - min + 1) + min;
                    int random2 = rand.nextInt(max - min + 1) + min;
                    int random3 = rand.nextInt(max - min + 1) + min;
                    int random4 = rand.nextInt(max - min + 1) + min;
                    int random5 = rand.nextInt(max - min + 1) + min;
                    String s = "Успех, вы повысили свой урон на 1.66!";
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "attribute " + lala + " minecraft:generic.attack_damage modifier add CB3F55D3-645C-4F38-A497-9C1" + random5 + "A" + random4 + random3 + "DB" + random2 + "C" + random + " sss 1.66 add");
                    en.sendMessage(s);

                }


            }
            @EventHandler
            public void onEntityTarget(EntityTargetLivingEntityEvent e){
            int yarik = plugin.getConfig().getInt("yarik");
            if(yarik >= 25) {
                Entity target = e.getTarget();
                if (target instanceof Player) {
                    Player player = (Player) target;
                    if(player.hasPermission("yar")){
                        Mob mob = (Mob) e.getEntity();
                        if(mob.getType() == EntityType.DROWNED){
                            e.setCancelled(true);
                        }

                    }
                }
            }


    }


}


