package gq.arnu515.manhunt.commands;

import gq.arnu515.manhunt.Manhunt;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedRunner implements CommandExecutor {
    private Manhunt mh;

    public SpeedRunner(Manhunt mh) {
        this.mh = mh;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("manhunt.command.speedrunner")) {
            if (args.length != 1) {
                sender.sendMessage(ChatColor.RED + "Usage: /speedrunner <player>");
            } else {
                try {
                    Player p  = Bukkit.getPlayer(args[0]);
                    mh.speedRunner = p;
                    Bukkit.broadcastMessage(ChatColor.GREEN + "Speedrunner set to " + p.getName() + " by " + sender.getName());
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Player not found!");
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to do that");
        }
        return true;
    }
}
