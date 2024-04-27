package me.lunafy.customsmp.types;

import me.lunafy.customsmp.CustomSMP;
import me.lunafy.customsmp.enums.ItemRarity;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SunaItem extends ItemStack {
    private final ItemStack item;
    public SunaItem(ItemStack item) {
        if(isSunaItem(item)) {
            this.item = item;
        } else {
            ItemMeta itemMeta = item.getItemMeta();
            List<String> lore = new ArrayList<String>();

            if(itemMeta.hasEnchants() || item.getType() == Material.ENCHANTED_BOOK || item.getType().toString().contains("SMITHING_TEMPLATE")) lore.add("");

            ItemRarity rarity = CustomSMP.queryItemRarity(item.getType());
            lore.add(rarity.color + "" + ChatColor.BOLD + rarity.toString().replace('_', ' '));

            itemMeta.setLore(lore);

            if(!itemMeta.hasDisplayName()) itemMeta.setDisplayName(rarity.color + WordUtils.capitalizeFully(item.getType().name().replace('_', ' ').toLowerCase()));


            item.setItemMeta(itemMeta);

            this.item = item;
        }

    }

    public ItemStack getItemStack() {
        return item;
    }

    public static boolean isSunaItem(ItemStack item) {
        ItemMeta sunaMeta = item.getItemMeta();

        if(!sunaMeta.hasLore()) return false;

        List<String> lore = sunaMeta.getLore();

        for(String string : lore) {
            if(string.matches(".*\\b(COMMON|UNCOMMON|RARE|VERY RARE|LEGENDARY)\\b.*")) {
                return true;
            }
        }

        return false;
    }
}
