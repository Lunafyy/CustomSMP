package me.lunafy.customsmp.events;

import me.lunafy.customsmp.types.SunaItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class InventoryOpen implements Listener {
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if(event.getInventory().getType() != InventoryType.CHEST) return;

        int slot = 0;
        for(ItemStack item : event.getInventory().getContents()) {
            if(item == null) continue;

            if(!SunaItem.isSunaItem(item)) {
                SunaItem sunaItem = new SunaItem(item);
                event.getInventory().setItem(slot, sunaItem.getItemStack());
            }

            slot++;
        }
    }

}
