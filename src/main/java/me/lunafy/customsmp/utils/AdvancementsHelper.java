package me.lunafy.customsmp.utils;

import me.lunafy.customsmp.CustomSMP;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class AdvancementsHelper {
    public static boolean hasAdvancement(Player player, String advancementUID) {
        if(CustomSMP.getDataManager().getConfig().getStringList("players." + player.getUniqueId()).contains(advancementUID)) return true;

        return false;
    }

    public static void giveAdvancement(Player player, String advancementUID) {
        if(CustomSMP.getDataManager().getConfig().contains("players." + player.getUniqueId())) {
            List<String> advancements = CustomSMP.getDataManager().getConfig().getStringList("players." + player.getUniqueId());
            advancements.add(advancementUID);

            CustomSMP.getDataManager().getConfig().set("players." + player.getUniqueId(), advancements);
        }

        CustomSMP.getDataManager().saveConfig();
    }
}
