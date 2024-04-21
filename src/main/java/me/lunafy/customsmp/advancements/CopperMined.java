package me.lunafy.customsmp.advancements;

import me.lunafy.customsmp.utils.AdvancementsHelper;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CopperMined {
    public static String getAdvancementUID() {
        return "CSTM_COPPER_MINED";
    }

    public static void triggerAlert(Player player) {
        String alertMessage = "COPPER ISN'T SO BAD";
        player.sendTitle(ChatColor.translateAlternateColorCodes('&', "&a&l&kA &a&l" + alertMessage + "&a&l&kA"), ChatColor.GREEN + "New advancement unlocked", 20, 20 * 5, 20);
    }

    public static boolean requirementsCheck(Player player) {
        if(AdvancementsHelper.hasAdvancement(player, getAdvancementUID())) return false;

        int copperMined = player.getStatistic(Statistic.MINE_BLOCK, Material.COPPER_ORE);

        if(copperMined >= 500) return true;

        return false;
    }

    public static void giveRewards(Player player) {
        ArrayList<ItemStack> rewards = new ArrayList<>();
        rewards.add(new ItemStack(Material.NETHERITE_HOE));

        for(ItemStack item : rewards) {
            player.getInventory().addItem(item);
        }
    }
}
