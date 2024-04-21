package me.lunafy.customsmp;

import me.lunafy.customsmp.commands.GetStat;
import me.lunafy.customsmp.events.*;
import me.lunafy.customsmp.utils.DataManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomSMP extends JavaPlugin {
    private static CustomSMP instance;
    private static DataManager dataManager;

    @Override
    public void onEnable() {
        instance = this;

        dataManager = new DataManager(this);

        registerCommands();
        registerEvents();

        getLogger().info("Online");
    }

    private void registerCommands() {
        getCommand("getstat").setExecutor(new GetStat());
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new ChangeBlock(), this);
        getServer().getPluginManager().registerEvents(new ItemInteract(), this);
        getServer().getPluginManager().registerEvents(new PortalCreation(), this);
    }

    public static CustomSMP getInstance() { return instance; }
    public static DataManager getDataManager() {
        return dataManager;
    }
}
