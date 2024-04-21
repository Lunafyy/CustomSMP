package me.lunafy.customsmp.items;

import me.lunafy.customsmp.enums.AirdropType;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;

public class CommonAirdrop extends Airdrop {
    public static LootTable getLootTable() {
        return LootTables.ABANDONED_MINESHAFT.getLootTable();
    }

    public static AirdropType getRarity() {
        return AirdropType.COMMON;
    }
}
