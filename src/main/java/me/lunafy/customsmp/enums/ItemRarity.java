package me.lunafy.customsmp.enums;

import org.bukkit.ChatColor;

public enum ItemRarity {
    COMMON(ChatColor.WHITE),
    UNCOMMON(ChatColor.GREEN),
    RARE(ChatColor.BLUE),
    VERY_RARE(ChatColor.DARK_PURPLE),
    LEGENDARY(ChatColor.GOLD);

    public final ChatColor color;

    ItemRarity(ChatColor chatColor) {
        this.color = chatColor;
    }
}
