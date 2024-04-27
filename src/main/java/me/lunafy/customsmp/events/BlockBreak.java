package me.lunafy.customsmp.events;

import me.lunafy.customsmp.advancements.CropsFarmed;
import me.lunafy.customsmp.utils.AdvancementsHelper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if(event.getBlock().hasMetadata("airdrop")) {
            player.sendMessage(ChatColor.RED + "You cannot break airdrops!");
            event.setCancelled(true);
            return;
        }

        if(CropsFarmed.requirementsCheck(player)) {
            CropsFarmed.triggerAlert(player);
            CropsFarmed.giveRewards(player);
            AdvancementsHelper.giveAdvancement(player, CropsFarmed.getAdvancementUID());
        }
    }
}
