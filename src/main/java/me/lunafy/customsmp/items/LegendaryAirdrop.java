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

public class LegendaryAirdrop extends Airdrop {
    public static LootTable getLootTable() {
        return LootTables.BASTION_TREASURE.getLootTable();
    }

    public static AirdropType getRarity() {
            return AirdropType.LEGENDARY;
    }

    public static ItemStack getAirdropItem() {
        ItemStack legendaryAirdrop = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta legendaryAirdropMeta = legendaryAirdrop.getItemMeta();

        List<String> legendaryAirdropLore = new ArrayList<String>();
        legendaryAirdropLore.add(ChatColor.RED + "This airdrop contains valuable resources.");
        legendaryAirdropLore.add("");
        legendaryAirdropLore.add(ChatColor.translateAlternateColorCodes('&', "&fRarity: &e&lLEGENDARY"));

        legendaryAirdropMeta.setLore(legendaryAirdropLore);

        legendaryAirdropMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lAIRDROP FLARE"));

        legendaryAirdrop.setItemMeta(legendaryAirdropMeta);

        return legendaryAirdrop;
    }

    public static ChatColor inventoryTitleColour() {
        return ChatColor.YELLOW;
    }
}
