package org.livius.flyPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.livius.flyPlugin.FlyPlugin;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private ArrayList<Player> listoflyingplayers = new ArrayList<>();

    private static FlyPlugin plugin;
    public FlyCommand(FlyPlugin plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p){
            if (args.length == 0) {
                playerFly(p, listoflyingplayers);
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                if (Bukkit.getOnlinePlayers().contains(target)){
                    playerFly(target, listoflyingplayers);
                }
            }
        }
        return true;
    }
    private static void playerFly(Player p, ArrayList listoflyingplayers) {
        if (listoflyingplayers.contains(p)) {
            listoflyingplayers.remove(p);
            p.setAllowFlight(false);
            String disableMessage = plugin.getConfig().getString("fly-disable-message");
            if (disableMessage != null){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', disableMessage));
            }
        } else {
            listoflyingplayers.add(p);
            p.setAllowFlight(true);
            String enableMessage = plugin.getConfig().getString("fly-enable-message");
            if (enableMessage != null){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', enableMessage));
            }
        }
    }
}
