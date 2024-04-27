package me.lunafy.customsmp.events;

import me.lunafy.customsmp.CustomSMP;
import me.lunafy.customsmp.enums.AirdropType;
import me.lunafy.customsmp.exceptions.StaticMethodNotImplementedException;
import me.lunafy.customsmp.items.*;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.List;
import java.util.Set;

public class ItemInteract implements Listener {
    //@SuppressWarnings("all")
    @EventHandler
    public void onItemInteract(PlayerInteractEvent event) throws StaticMethodNotImplementedException {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();


        if(item == null) return;
        // Anything that requires a valid item to exist
        if(event.getClickedBlock() != null) {
            if(event.getClickedBlock().getType() == Material.END_PORTAL_FRAME && player.getInventory().getItemInMainHand().getType() == Material.ENDER_EYE) {
                World world = event.getClickedBlock().getWorld();
                world.spawnParticle(Particle.SMOKE_LARGE, event.getClickedBlock().getLocation().add(0.5, 1, 0.5), 30, 0.1, 0.1, 0.1, 0.1, null);

                player.playSound(event.getPlayer().getLocation(), Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);

                event.setCancelled(true);
            }
        }

        if(item.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&d&lAIRDROP FLARE"))) {
            AirdropType type;

            List<String> lore = item.getItemMeta().getLore();
            String rarityLine = lore.get(lore.size() - 1);

            Location dropLocation;
            Block targetBlock = player.getTargetBlock(null, 100);

            if(targetBlock.getType() == Material.AIR) {
                dropLocation = player.getLocation();
            } else {
                dropLocation = targetBlock.getLocation();
            }

            
            // ps: this 1 for loop took about an hour
            // im going to kill myself now
            Location toCheck = dropLocation;
            for(int i = 1; i < 51; i++) {
                toCheck = toCheck.add(0, 1, 0);
                if(!toCheck.getBlock().getType().isAir()) {
                    player.sendMessage(ChatColor.RED + "The airdrop can't reach here!");
                    return;
                }
            }

            if(rarityLine.contains("BEGINNER")) {
                type = AirdropType.BEGINNER;
                player.getInventory().removeItem(BeginnerAirdrop.getAirdropItem());
            } else if(rarityLine.contains("UNCOMMON")) {
                type = AirdropType.UNCOMMON;
                player.getInventory().removeItem(UncommonAirdrop.getAirdropItem());
            } else if (rarityLine.contains("COMMON")) {
                type = AirdropType.COMMON;
                player.getInventory().removeItem(CommonAirdrop.getAirdropItem());
            } else if (rarityLine.contains("RARE")) {
                type = AirdropType.RARE;
                player.getInventory().removeItem(RareAirdrop.getAirdropItem());
            } else if (rarityLine.contains("LEGENDARY")) {
                type = AirdropType.LEGENDARY;
                player.getInventory().removeItem(LegendaryAirdrop.getAirdropItem());
            } else if (rarityLine.contains("MYTHIC")) {
                type = AirdropType.MYTHIC;
                player.getInventory().removeItem(MythicAirdrop.getAirdropItem());
            } else {
                player.sendMessage(ChatColor.RED + "There has been an error with your airdrop, please report this to Lunafy");
                return;
            }

            FallingBlock beacon = player.getWorld().spawnFallingBlock(dropLocation.add(0, 50, 0), Material.BEACON, (byte)0);
            beacon.setMetadata("airdrop", new FixedMetadataValue(CustomSMP.getInstance(), type));

        }
    }
}
