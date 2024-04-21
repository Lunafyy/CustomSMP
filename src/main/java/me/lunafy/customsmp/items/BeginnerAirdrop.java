package me.lunafy.customsmp.items;

import me.lunafy.customsmp.enums.AirdropType;
import me.lunafy.customsmp.types.loottables.BeginnerLoot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;

import java.util.ArrayList;
import java.util.List;

public class BeginnerAirdrop extends Airdrop {
    public static LootTable getLootTable() {
        return new BeginnerLoot();
    }

    public static AirdropType getRarity() {
        return AirdropType.BEGINNER;
    }

    public static ItemStack getAirdropItem() {
        ItemStack beginnerAirdrop = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta beginnerAirdropMeta = beginnerAirdrop.getItemMeta();

        List<String> beginnerAirdropLore = new ArrayList<String>();
        beginnerAirdropLore.add(ChatColor.RED + "This airdrop contains valuable resources.");
        beginnerAirdropLore.add("");
        beginnerAirdropLore.add(ChatColor.translateAlternateColorCodes('&', "&fRarity: &d&lBEGINNER"));

        beginnerAirdropMeta.setLore(beginnerAirdropLore);

        beginnerAirdropMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lAIRDROP FLARE"));

        beginnerAirdrop.setItemMeta(beginnerAirdropMeta);

        return beginnerAirdrop;
    }
}
