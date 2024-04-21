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

public class UncommonAirdrop extends Airdrop {
    public static LootTable getLootTable() {
        return LootTables.STRONGHOLD_CORRIDOR.getLootTable();
    }

    public static AirdropType getRarity() {
        return AirdropType.UNCOMMON;
    }

    public static ItemStack getAirdropItem() {
        ItemStack uncommonAirdrop = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta uncommonAirdropMeta = uncommonAirdrop.getItemMeta();

        List<String> uncommonAirdropLore = new ArrayList<String>();
        uncommonAirdropLore.add(ChatColor.RED + "This airdrop contains valuable resources.");
        uncommonAirdropLore.add("");
        uncommonAirdropLore.add(ChatColor.translateAlternateColorCodes('&', "&fRarity: &a&lUNCOMMON"));

        uncommonAirdropMeta.setLore(uncommonAirdropLore);

        uncommonAirdropMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lAIRDROP FLARE"));

        uncommonAirdrop.setItemMeta(uncommonAirdropMeta);

        return uncommonAirdrop;
    }

    public static ChatColor inventoryTitleColour() {
        return ChatColor.GREEN;
    }
}
