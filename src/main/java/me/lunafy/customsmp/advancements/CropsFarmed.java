package me.lunafy.customsmp.advancements;

import me.lunafy.customsmp.utils.AdvancementsHelper;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CropsFarmed {
    public static String getAdvancementUID() {
        return "CSTM_CROPS_FARMED";
    }

    public static void triggerAlert(Player player) {
        String alertMessage = "W FARMER";
        player.sendTitle(ChatColor.translateAlternateColorCodes('&', "&a&l&kA &a&l" + alertMessage + "&a&l&kA"), ChatColor.GREEN + "New advancement unlocked", 40, 60, 40);
    }

    public static boolean requirementsCheck(Player player) {
        if(AdvancementsHelper.hasAdvancement(player, getAdvancementUID())) return false;

        int potatoesMined = player.getStatistic(Statistic.MINE_BLOCK, Material.POTATOES);
        int wheatMined = player.getStatistic(Statistic.MINE_BLOCK, Material.WHEAT);
        int carrotsMined = player.getStatistic(Statistic.MINE_BLOCK, Material.CARROTS);

        if(potatoesMined >= 1 && wheatMined >= 1 && carrotsMined >= 1) return true;

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
