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

public class MythicAirdrop extends Airdrop {
    public static LootTable getLootTable() {
        return LootTables.END_CITY_TREASURE.getLootTable();
    }

    public static AirdropType getRarity() {
        return AirdropType.MYTHIC;
    }

    public static ItemStack getAirdropItem() {
        ItemStack mythicAirdrop = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta mythicAirdropMeta = mythicAirdrop.getItemMeta();

        List<String> mythicAirdropLore = new ArrayList<String>();
        mythicAirdropLore.add(ChatColor.RED + "This airdrop contains valuable resources.");
        mythicAirdropLore.add("");
        mythicAirdropLore.add(ChatColor.translateAlternateColorCodes('&', "&fRarity: &5&lMYTHIC"));

        mythicAirdropMeta.setLore(mythicAirdropLore);

        mythicAirdropMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lAIRDROP FLARE"));

        mythicAirdrop.setItemMeta(mythicAirdropMeta);

        return mythicAirdrop;
    }
}
