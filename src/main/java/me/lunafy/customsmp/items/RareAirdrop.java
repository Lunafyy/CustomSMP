package me.lunafy.customsmp.items;

import me.lunafy.customsmp.enums.AirdropType;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;

public class RareAirdrop extends Airdrop {
    public static LootTable getLootTable() {
        return LootTables.DESERT_PYRAMID.getLootTable();
    }

    public static AirdropType getRarity() {
        return AirdropType.RARE;
    }
}
