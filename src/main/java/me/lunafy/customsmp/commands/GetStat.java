package me.lunafy.customsmp.commands;

import me.lunafy.customsmp.CustomSMP;
import me.lunafy.customsmp.items.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class GetStat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            switch(args[0].toLowerCase()) {
                case "beginner":
                    player.getInventory().addItem(BeginnerAirdrop.getAirdropItem());
                    break;
                case "common":
                    player.getInventory().addItem(CommonAirdrop.getAirdropItem());
                    break;
                case "uncommon":
                    player.getInventory().addItem(UncommonAirdrop.getAirdropItem());
                    break;
                case "rare":
                    player.getInventory().addItem(RareAirdrop.getAirdropItem());
                    break;
                case "legendary":
                    player.getInventory().addItem(LegendaryAirdrop.getAirdropItem());
                    break;
                case "mythic":
                    player.getInventory().addItem(MythicAirdrop.getAirdropItem());
                    break;
            }


        }
        return true;
    }
}
