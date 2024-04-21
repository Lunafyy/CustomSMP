package me.lunafy.customsmp.items;

import me.lunafy.customsmp.enums.AirdropType;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;

public class MythicAirdrop extends Airdrop {
    public static LootTable getLootTable() {
        return LootTables.END_CITY_TREASURE.getLootTable();
    }

    public static AirdropType getRarity() {
        return AirdropType.MYTHIC;
    }
}
