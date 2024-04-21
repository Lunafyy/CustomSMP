package me.lunafy.customsmp.events;

import me.lunafy.customsmp.CustomSMP;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Chest;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTables;
import org.bukkit.metadata.MetadataValue;

import java.util.Random;

public class ChangeBlock implements Listener {
    @EventHandler
    public void onChangeBlock(EntityChangeBlockEvent event) {
        if(event.getEntity() instanceof FallingBlock) {
            FallingBlock fb = (FallingBlock) event.getEntity();
            fb.setDropItem(false);

            if(fb.getMaterial() == Material.BEACON && fb.hasMetadata("airdrop")) {
                Bukkit.getScheduler().runTaskLater(CustomSMP.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        event.setCancelled(true);

                        event.getBlock().getWorld().spawnParticle(Particle.EXPLOSION_HUGE, event.getBlock().getLocation(), 10, null);

                        event.getBlock().setType(Material.CHEST);

                        Chest chest = (Chest) event.getBlock().getState();
                        Inventory chestInv = chest.getInventory();

                        LootContext context = new LootContext.Builder(chest.getLocation()).build();

                        LootTables.VILLAGE_WEAPONSMITH.getLootTable().fillInventory(chestInv, new Random(), context);
                    }
                }, 20 * 3);

            }
        }
    }
}
