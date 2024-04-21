package me.lunafy.customsmp.events;

import me.lunafy.customsmp.CustomSMP;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

public class PortalCreation implements Listener {
    @EventHandler
    public void onPortalCreate(PortalCreateEvent event) {
        CustomSMP.getInstance().getLogger().info(event.getEventName());
        CustomSMP.getInstance().getLogger().info(event.getReason().toString());

        for(BlockState blockState : event.getBlocks()) {
            if(blockState.getType() == Material.NETHER_PORTAL && event.getWorld() == Bukkit.getWorld("world") && event.getEntity() instanceof Player) {
                event.setCancelled(true);

                for(BlockState bs : event.getBlocks()) {
                    Location loc = bs.getBlock().getLocation();
                    Bukkit.getWorld("world").spawnParticle(Particle.EXPLOSION_HUGE, loc, 20);
                    Bukkit.getWorld("world").playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 0.2f, 1f);

                    bs.getBlock().setType(Material.AIR);
                }
            }
        }
    }
}
