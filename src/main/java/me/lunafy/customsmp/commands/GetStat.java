package me.lunafy.customsmp.commands;

import me.lunafy.customsmp.utils.AdvancementsHelper;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetStat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            player.sendMessage(String.valueOf(AdvancementsHelper.hasAdvancement(player, args[0])));
        }
        return true;
    }
}
