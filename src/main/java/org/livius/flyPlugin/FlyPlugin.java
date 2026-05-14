package org.livius.flyPlugin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.livius.flyPlugin.commands.FlyCommand;

import java.util.ArrayList;

public final class FlyPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        saveConfig();
        getCommand("fly").setExecutor(new FlyCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
