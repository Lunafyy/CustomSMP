package me.lunafy.customsmp.events;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import me.lunafy.customsmp.CustomSMP;
import me.lunafy.customsmp.enums.AirdropType;
import me.lunafy.customsmp.items.*;
import me.lunafy.customsmp.types.RepeatingTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import org.bukkit.scheduler.BukkitTask;

import java.util.Random;

public class ChangeBlock implements Listener {
    int task;

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

                        String formattedLocation = chest.getLocation().getBlockX() + "_" + chest.getLocation().getBlockY() + "_" + chest.getLocation().getBlockZ();
                        Hologram hologram = DHAPI.createHologram("airdrop_" + formattedLocation, chest.getLocation().add(0.5, 1.5, 0.5));
                        DHAPI.addHologramLine(hologram, ChatColor.translateAlternateColorCodes('&', "&d&lAIRDROP"));

                        switch(rarity) {
                            case BEGINNER:
                                DHAPI.addHologramLine(hologram, ChatColor.WHITE + "Rarity: " + BeginnerAirdrop.inventoryTitleColour() + "BEGINNER");

                                BeginnerAirdrop.getLootTable().fillInventory(chestInv, new Random(), context);
                                break;
                            case COMMON:
                                DHAPI.addHologramLine(hologram, ChatColor.WHITE + "Rarity: " + CommonAirdrop.inventoryTitleColour() + "COMMON");

                                CommonAirdrop.getLootTable().fillInventory(chestInv, new Random(), context);
                                break;
                            case UNCOMMON:
                                DHAPI.addHologramLine(hologram, ChatColor.WHITE + "Rarity: " + UncommonAirdrop.inventoryTitleColour() + "UNCOMMON");

                                UncommonAirdrop.getLootTable().fillInventory(chestInv, new Random(), context);
                                break;
                            case RARE:
                                DHAPI.addHologramLine(hologram, ChatColor.WHITE + "Rarity: " + RareAirdrop.inventoryTitleColour() + "RARE");

                                RareAirdrop.getLootTable().fillInventory(chestInv, new Random(), context);
                                break;
                            case LEGENDARY:
                                DHAPI.addHologramLine(hologram, ChatColor.WHITE + "Rarity: " + LegendaryAirdrop.inventoryTitleColour() + "LEGENDARY");

                                LegendaryAirdrop.getLootTable().fillInventory(chestInv, new Random(), context);
                                break;
                            case MYTHIC:
                                DHAPI.addHologramLine(hologram, ChatColor.WHITE + "Rarity: " + MythicAirdrop.inventoryTitleColour() + "MYTHIC");

                                MythicAirdrop.getLootTable().fillInventory(chestInv, new Random(), context);
                                break;
                            default:
                                return;
                        }

                        new RepeatingTask(CustomSMP.getInstance(), 0, 40) {
                            int iterations = 0;
                            @Override
                            public void run() {
                                Inventory chestInv = chest.getInventory();

                                if(chestInv.isEmpty() || iterations >= 15) {
                                    hologram.delete();

                                    chest.getLocation().getBlock().setType(Material.AIR);
                                    chest.getLocation().add(0, -1, 0).getBlock().setType(Material.AIR);

                                    chest.getLocation().getWorld().spawnParticle(Particle.EXPLOSION_HUGE, chest.getLocation(), 20);

                                    cancel();
                                }

                                iterations++;
                            }
                        };

                    }
                }, 20 * 3);

            }
        }
    }
}
