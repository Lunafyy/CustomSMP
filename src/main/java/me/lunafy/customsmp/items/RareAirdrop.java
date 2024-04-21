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

public class RareAirdrop extends Airdrop {
    public static LootTable getLootTable() {
        return LootTables.DESERT_PYRAMID.getLootTable();
    }

    public static AirdropType getRarity() {
        return AirdropType.RARE;
    }

    public static ItemStack getAirdropItem() {
        ItemStack rareAirdrop = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta rareAirdropMeta = rareAirdrop.getItemMeta();

        List<String> rareAirdropLore = new ArrayList<String>();
        rareAirdropLore.add(ChatColor.RED + "This airdrop contains valuable resources.");
        rareAirdropLore.add("");
        rareAirdropLore.add(ChatColor.translateAlternateColorCodes('&', "&fRarity: &7&lRARE"));

        rareAirdropMeta.setLore(rareAirdropLore);

        rareAirdropMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lAIRDROP FLARE"));

        rareAirdrop.setItemMeta(rareAirdropMeta);

        return rareAirdrop;
    }
}
