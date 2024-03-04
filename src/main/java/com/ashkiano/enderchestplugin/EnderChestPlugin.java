package com.ashkiano.enderchestplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderChestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("EnderChestPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("EnderChestPlugin has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("enderchest")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be used by players.");
                return true;
            }

            Player player = (Player) sender;
            if (player.hasPermission("enderchest.use")) {
                player.openInventory(player.getEnderChest());
            } else {
                player.sendMessage("You do not have permission to use this command.");
            }
            return true;
        }
        return false;
    }
}