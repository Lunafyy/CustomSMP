package me.lunafy.customsmp.commands;

import me.lunafy.customsmp.CustomSMP;
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
            Location plrLoc = player.getLocation();

            player.getWorld().spawnFallingBlock(plrLoc.add(0, 46, 0), Material.OAK_FENCE, (byte)0);

            FallingBlock beacon = player.getWorld().spawnFallingBlock(plrLoc.add(0, 50, 0), Material.BEACON, (byte)0);
            beacon.setMetadata("airdrop", new FixedMetadataValue(CustomSMP.getInstance(), true));


        }
        return true;
    }
}
