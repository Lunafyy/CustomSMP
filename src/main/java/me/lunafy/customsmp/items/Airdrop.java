package me.lunafy.customsmp.items;

import me.lunafy.customsmp.enums.AirdropType;
import me.lunafy.customsmp.exceptions.StaticMethodNotImplementedException;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootTable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class Airdrop {
    public static LootTable getLootTable() throws StaticMethodNotImplementedException {
        throw new StaticMethodNotImplementedException("Loot tables must be defined for custom airdrops.");
    }

    public static AirdropType getRarity() throws StaticMethodNotImplementedException {
        throw new StaticMethodNotImplementedException("Rarity must be defined for custom airdrops.");
    }

    public static ItemStack getAirdropItem() throws StaticMethodNotImplementedException {
        throw new StaticMethodNotImplementedException("Airdrop ItemStack must be defined for custom airdrops.");
    }
}
