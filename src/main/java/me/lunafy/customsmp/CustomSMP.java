package me.lunafy.customsmp;

import me.lunafy.customsmp.commands.GetStat;
import me.lunafy.customsmp.events.BlockBreak;
import me.lunafy.customsmp.events.PlayerJoin;
import me.lunafy.customsmp.utils.DataManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomSMP extends JavaPlugin {
    private static DataManager dataManager;

    @Override
    public void onEnable() {
        dataManager = new DataManager(this);

        registerCommands();
        registerEvents();
    }

    private void registerCommands() {
        getCommand("getstat").setExecutor(new GetStat());
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
    }

    public static DataManager getDataManager() {
        return dataManager;
    }
}
