package me.lunafy.customsmp.items;

import me.lunafy.customsmp.enums.AirdropType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;

import java.util.ArrayList;
import java.util.List;

public class CommonAirdrop extends Airdrop {
    public static LootTable getLootTable() {
        return LootTables.ABANDONED_MINESHAFT.getLootTable();
    }

    public static AirdropType getRarity() {
        return AirdropType.COMMON;
    }

    public static ItemStack getAirdropItem() {
        ItemStack commonAirdrop = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta commonAirdropMeta = commonAirdrop.getItemMeta();

        List<String> commonAirdropLore = new ArrayList<String>();
        commonAirdropLore.add(ChatColor.RED + "This airdrop contains valuable resources.");
        commonAirdropLore.add("");
        commonAirdropLore.add(ChatColor.translateAlternateColorCodes('&', "&fRarity: &7&lCOMMON"));

        commonAirdropMeta.setLore(commonAirdropLore);

        commonAirdropMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lAIRDROP FLARE"));

        commonAirdrop.setItemMeta(commonAirdropMeta);

        return commonAirdrop;
    }

    public static ChatColor inventoryTitleColour() {
        return ChatColor.GRAY;
    }
}
