package me.lunafy.customsmp.events;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemInteract implements Listener {
    @EventHandler
    public void onItemInteract(PlayerInteractEvent event) {
        if(event.getClickedBlock() != null) {
            if(event.getClickedBlock().getType() == Material.END_PORTAL_FRAME && event.getPlayer().getInventory().getItemInMainHand().getType() == Material.ENDER_EYE) {
                World world = event.getClickedBlock().getWorld();
                world.spawnParticle(Particle.SMOKE_LARGE, event.getClickedBlock().getLocation().add(0.5, 1, 0.5), 30, 0.1, 0.1, 0.1, 0.1, null);

                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);

                event.setCancelled(true);
            }
        }

        event.getPlayer().sendMessage(event.getItem().getType().toString());
    }
}
