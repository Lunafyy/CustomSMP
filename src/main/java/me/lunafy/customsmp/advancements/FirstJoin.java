package me.lunafy.customsmp.advancements;

import me.lunafy.customsmp.CustomSMP;
import me.lunafy.customsmp.utils.AdvancementsHelper;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class FirstJoin extends SunaAdvancement {
    public static String getAdvancementUID() {
        return "CSTM_FIRST_JOIN";
    }

    public static void triggerAlert(Player player) {
        String alertMessage = "WELCOME!";
        player.sendTitle(ChatColor.translateAlternateColorCodes('&', "&a&l&kA &a&l" + alertMessage + " &a&l&kA"), ChatColor.GREEN + "New advancement unlocked", 20, 20 * 5, 20);
    }

    public static boolean requirementsCheck(Player player) {
        if(AdvancementsHelper.hasAdvancement(player, getAdvancementUID())) return false;

        return player.isOnline() && !CustomSMP.getAdvancementManager().getConfig().contains("players." + player.getUniqueId());
    }

    public static void giveRewards(Player player) {
        ArrayList<ItemStack> rewards = new ArrayList<>();
        rewards.add(new ItemStack(Material.COMPASS));
        rewards.add(new ItemStack(Material.MAP));

        for(ItemStack item : rewards) {
            player.getInventory().addItem(item);
        }
    }
}
