package me.lunafy.customsmp.advancements;

import me.lunafy.customsmp.exceptions.StaticMethodNotImplementedException;
import org.bukkit.entity.Player;

public abstract class CustomAdvancement {
    public static String getAdvancementUID() throws StaticMethodNotImplementedException {
        throw new StaticMethodNotImplementedException("You must implement the method to return an advancement UID.");
    }

    public static void triggerAlert(Player player) throws StaticMethodNotImplementedException {
        throw new StaticMethodNotImplementedException("You must implement the method to trigger an alert.");
    }

    public static boolean requirementsCheck(Player player) throws StaticMethodNotImplementedException {
        throw new StaticMethodNotImplementedException("You must implement the method to check the requirements.");
    }

    public static void giveRewards(Player player) throws StaticMethodNotImplementedException {
        throw new StaticMethodNotImplementedException("You must implement the method to give the rewards.");
    }
}

