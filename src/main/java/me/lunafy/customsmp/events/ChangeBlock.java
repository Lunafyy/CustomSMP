package me.lunafy.customsmp.events;

import me.lunafy.customsmp.CustomSMP;
import me.lunafy.customsmp.enums.AirdropType;
import me.lunafy.customsmp.items.*;
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

                        AirdropType rarity = (AirdropType) fb.getMetadata("airdrop").get(0).value();

                        Chest chest = (Chest) event.getBlock().getState();
                        Inventory chestInv = chest.getInventory();

                        LootContext context = new LootContext.Builder(chest.getLocation()).build();

                        switch(rarity) {
                            case BEGINNER:
                                BeginnerAirdrop.getLootTable().fillInventory(chestInv, new Random(), context);
                                break;
                            case COMMON:
                                CommonAirdrop.getLootTable().fillInventory(chestInv, new Random(), context);
                                break;
                            case UNCOMMON:
                                UncommonAirdrop.getLootTable().fillInventory(chestInv, new Random(), context);
                                break;
                            case RARE:
                                RareAirdrop.getLootTable().fillInventory(chestInv, new Random(), context);
                                break;
                            case LEGENDARY:
                                LegendaryAirdrop.getLootTable().fillInventory(chestInv, new Random(), context);
                                break;
                            case MYTHIC:
                                MythicAirdrop.getLootTable().fillInventory(chestInv, new Random(), context);
                                break;
                        }

                    }
                }, 20 * 3);

            }
        }
    }
}
