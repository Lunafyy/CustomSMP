package me.lunafy.customsmp.events;

import me.lunafy.customsmp.CustomSMP;
import me.lunafy.customsmp.enums.ItemRarity;
import me.lunafy.customsmp.types.SunaItem;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemCreated implements Listener {
    @EventHandler
    public void onItemCreated(ItemSpawnEvent event) {
        ItemStack item = event.getEntity().getItemStack();
        ItemMeta meta = item.getItemMeta();

        if(!meta.hasLore()) {
            SunaItem newItem = new SunaItem(item);

            event.getLocation().getWorld().dropItem(event.getLocation(), newItem.getItemStack());

            event.setCancelled(true);
        }

    }
}
