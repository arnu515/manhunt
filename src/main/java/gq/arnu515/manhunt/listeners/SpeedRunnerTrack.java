package gq.arnu515.manhunt.listeners;

import gq.arnu515.manhunt.Manhunt;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SpeedRunnerTrack implements Listener {
    private Manhunt mh;

    public SpeedRunnerTrack(Manhunt mh) {
        this.mh = mh;
    }

    @EventHandler
    public void onCompassClick(PlayerInteractEvent e) {
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Speedrunner tracker")) {
            if (e.getPlayer().hasPermission("manhunt.trackspeedrunner")) {
                if (mh.speedRunner == null) {
                    e.getPlayer().sendMessage(ChatColor.RED + "Set a speedrunner first using the /speedrunner command");
                } else {
                    if (e.getPlayer().getName().equalsIgnoreCase(mh.speedRunner.getName())) {
                        e.getPlayer().sendMessage(ChatColor.RED + "You're a speedrunner. You can't do that");
                    } else {
                        Location speedrunnerLoc = mh.speedRunner.getLocation();
                        e.getPlayer().setCompassTarget(speedrunnerLoc);
                        e.getPlayer().sendMessage(ChatColor.GREEN + "Now targetting the speedrunner, " + mh.speedRunner.getName());
                        e.getPlayer().sendMessage(ChatColor.YELLOW + "" + mh.speedRunner.getName() + " is " + speedrunnerLoc.distance(e.getPlayer().getLocation()) + " block(s) away.");
                    }
                }
            } else {
                e.getPlayer().sendMessage(ChatColor.RED + "You don't have permission to do that");
            }
        }
    }
}
