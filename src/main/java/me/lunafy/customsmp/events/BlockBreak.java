package me.lunafy.customsmp.events;

import me.lunafy.customsmp.advancements.CropsFarmed;
import me.lunafy.customsmp.utils.AdvancementsHelper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if(CropsFarmed.requirementsCheck(player)) {
            CropsFarmed.triggerAlert(player);
            CropsFarmed.giveRewards(player);
            AdvancementsHelper.giveAdvancement(player, CropsFarmed.getAdvancementUID());
        }
    }
}
