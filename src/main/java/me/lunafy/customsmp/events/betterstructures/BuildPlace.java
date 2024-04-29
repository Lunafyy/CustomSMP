package me.lunafy.customsmp.events.betterstructures;

import com.magmaguy.betterstructures.api.BuildPlaceEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BuildPlace implements Listener {
    @EventHandler
    public void onBuildPlaced(BuildPlaceEvent event) {
        event.getFitAnything().getLocation();
    }
}
