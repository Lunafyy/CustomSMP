package me.lunafy.customsmp.events;

import me.lunafy.customsmp.CustomSMP;
import me.lunafy.customsmp.advancements.FirstJoin;
import me.lunafy.customsmp.utils.AdvancementsHelper;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(FirstJoin.requirementsCheck(player)) {
            AdvancementsHelper.giveAdvancement(player, FirstJoin.getAdvancementUID());

            FirstJoin.triggerAlert(player);
            FirstJoin.giveRewards(player);
        }

        CustomSMP.getDataManager().saveConfig();
    }
}
