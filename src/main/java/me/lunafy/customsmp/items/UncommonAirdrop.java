package me.lunafy.customsmp.items;

import me.lunafy.customsmp.enums.AirdropType;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;

public class UncommonAirdrop extends Airdrop {
    public static LootTable getLootTable() {
        return LootTables.STRONGHOLD_CORRIDOR.getLootTable();
    }

    public static AirdropType getRarity() {
        return AirdropType.UNCOMMON;
    }
}
