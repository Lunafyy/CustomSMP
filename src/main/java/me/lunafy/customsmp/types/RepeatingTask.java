package me.lunafy.customsmp.types;

import me.lunafy.customsmp.CustomSMP;
import org.bukkit.Bukkit;

public abstract class RepeatingTask implements Runnable {
    private int taskId;

    public RepeatingTask(CustomSMP plugin, int arg1, int arg2) {
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this, arg1, arg2);
    }

    public void cancel() {
        Bukkit.getScheduler().cancelTask(taskId);
    }
}
