package org.livius.flyPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {
    private ArrayList<Player> listofflyingplayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p){
            if (args.length == 0) {
                if (listofflyingplayers.contains(p)) {
                    listofflyingplayers.remove(p);
                    p.setAllowFlight(false);
                    p.sendMessage("Flying disabled!");
                } else {
                    listofflyingplayers.add(p);
                    p.setAllowFlight(true);
                    p.sendMessage("Flying enabled!");
                }
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                if (Bukkit.getOnlinePlayers().contains(target)){
                    if (listofflyingplayers.contains(target)) {
                        listofflyingplayers.remove(target);
                        target.setAllowFlight(false);
                        target.sendMessage("Flying disabled!");
                    } else {
                        listofflyingplayers.add(target);
                        target.setAllowFlight(true);
                        target.sendMessage("Flying enabled!");
                    }
                }
            }
        }
        return true;
    }
}
