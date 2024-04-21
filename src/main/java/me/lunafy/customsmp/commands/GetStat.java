package me.lunafy.customsmp.commands;

import me.lunafy.customsmp.CustomSMP;
import me.lunafy.customsmp.items.BeginnerAirdrop;
import me.lunafy.customsmp.items.CommonAirdrop;
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

            player.getInventory().addItem(BeginnerAirdrop.getAirdropItem());


        }
        return true;
    }
}
