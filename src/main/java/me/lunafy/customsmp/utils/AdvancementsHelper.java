package me.lunafy.customsmp.utils;

import me.lunafy.customsmp.CustomSMP;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class AdvancementsHelper {
    public static boolean hasAdvancement(Player player, String advancementUID) {
        return CustomSMP.getAdvancementManager().getConfig().getStringList("players." + player.getUniqueId()).contains(advancementUID);
    }

    public static void giveAdvancement(Player player, String advancementUID) {
        if(CustomSMP.getAdvancementManager().getConfig().contains("players." + player.getUniqueId())) {
            List<String> advancements = CustomSMP.getAdvancementManager().getConfig().getStringList("players." + player.getUniqueId());
            advancements.add(advancementUID);

            CustomSMP.getAdvancementManager().getConfig().set("players." + player.getUniqueId(), advancements);
        }

        CustomSMP.getAdvancementManager().saveConfig();
    }

    public static void registerNewPlayer(Player player) {
        if(!CustomSMP.getAdvancementManager().getConfig().contains("players." + player.getUniqueId())) {

            CustomSMP.getAdvancementManager().getConfig().set("players." + player.getUniqueId(), new ArrayList<String>());

            CustomSMP.getAdvancementManager().saveConfig();
        }
    }
}
