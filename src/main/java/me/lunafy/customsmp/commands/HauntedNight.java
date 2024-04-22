package me.lunafy.customsmp.commands;

import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class HauntedNight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            ((CraftPlayer)p).getHandle().connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.RAIN_LEVEL_CHANGE, Float.parseFloat(args[0])));
        }
        return false;
    }
}
