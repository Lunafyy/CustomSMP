package me.lunafy.customsmp.events;

import me.lunafy.customsmp.CustomSMP;
import me.lunafy.customsmp.advancements.FirstJoin;
import me.lunafy.customsmp.utils.AdvancementsHelper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(FirstJoin.requirementsCheck(player)) {
            AdvancementsHelper.registerNewPlayer(player);
            AdvancementsHelper.giveAdvancement(player, FirstJoin.getAdvancementUID());

            Bukkit.getScheduler().runTaskLater(CustomSMP.getInstance(), new Runnable() {
                @Override
                public void run() {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 19 * 20, 255));
                    player.playSound(player.getLocation(), "custom.voicelines.intro", 1f, 1f);

                    Bukkit.getScheduler().runTaskLater(CustomSMP.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            FirstJoin.triggerAlert(player);
                            FirstJoin.giveRewards(player);
                        }
                    }, 20 * 19);
                }
            }, 20 * 2);
        }

        CustomSMP.getAdvancementManager().saveConfig();
    }
}
