package me.lunafy.customsmp.utils;

import me.lunafy.customsmp.CustomSMP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataManager {
    private final CustomSMP instance;
    private File configFile;
    private YamlConfiguration dataConfig;

    public DataManager(CustomSMP instance) {
        this.instance = instance;

        saveDefaultConfig();
    }

    public void reloadConfig() {
        if(this.configFile == null) {
            this.configFile = new File(this.instance.getDataFolder(), "advancements.yml");
        }

        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.instance.getResource("advancements.yml");

        if(defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }

        System.out.println("RELOADED");
    }

    public FileConfiguration getConfig() {
        if(this.dataConfig == null) {
            reloadConfig();
        }

        System.out.println("GOTTEN");

        return this.dataConfig;
    }

    public void saveConfig() {
        if(this.dataConfig == null || this.configFile == null) {
            return;
        }

        try {
            this.getConfig().save(this.configFile);
        } catch (IOException e) {
            instance.getLogger().severe("Could not save config to " + this.configFile + e);
        }

        System.out.println("SAVED");
    }

    public void saveDefaultConfig() {
        if(this.configFile == null) {
            this.configFile = new File(this.instance.getDataFolder(), "advancements.yml");
        }

        if(!this.configFile.exists()) {
            this.instance.saveResource("advancements.yml", false);
        }

        System.out.println("SAVED DEFAULT");
    }
}
