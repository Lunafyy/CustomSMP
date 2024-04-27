package me.lunafy.customsmp.events;

import me.lunafy.customsmp.types.SunaItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;

public class FurnaceSmelt implements Listener {
    @EventHandler
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {
        event.setResult(new SunaItem(event.getResult()).getItemStack());
    }
}
