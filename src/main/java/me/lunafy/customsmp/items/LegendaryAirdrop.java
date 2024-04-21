package me.lunafy.customsmp.items;

import me.lunafy.customsmp.enums.AirdropType;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;

public class LegendaryAirdrop extends Airdrop {
    public static LootTable getLootTable() {
        return LootTables.BASTION_TREASURE.getLootTable();
    }

    public static AirdropType getRarity() {
            return AirdropType.LEGENDARY;
    }
}
