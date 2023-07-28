package org.religic.religicmain;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class ReligicMain extends JavaPlugin {

    FileConfiguration config = this.getConfig();




public boolean tick = true;
    @Override
    public void onEnable() {
        tick = true;
        getConfig().addDefault("satana" , 0);
        getConfig().addDefault("yarik", 0);
        getConfig().addDefault("genshin", 0);

        config.options().copyDefaults(true);
        this.saveDefaultConfig();









        getServer().getPluginManager().registerEvents(new religic(this),this);
        getServer().getPluginCommand("yar2").setExecutor(new yar2(this));
        getServer().getPluginCommand("yar10").setExecutor(new yar10(this));
        getServer().getPluginCommand("configset").setExecutor(new forConfig(this));
        getServer().getPluginCommand("firebeam").setExecutor(new firebeam(this));



        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        tick = false;
        this.saveConfig();
    }


}
