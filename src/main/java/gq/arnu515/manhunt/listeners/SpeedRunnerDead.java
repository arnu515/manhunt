package gq.arnu515.manhunt.listeners;

import gq.arnu515.manhunt.Manhunt;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class SpeedRunnerDead implements Listener {
    private Manhunt mh;

    public SpeedRunnerDead(Manhunt mh) {
        this.mh = mh;
    }

    @EventHandler
    public void onSpeedRunnerDeath(PlayerDeathEvent e) {
        if (mh.speedRunner == null) return;
        if (e.getEntity().getName().equalsIgnoreCase(mh.speedRunner.getName())) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (!p.getName().equalsIgnoreCase(mh.speedRunner.getName())) {
                    p.sendMessage(ChatColor.GREEN + "Victory! You killed the speedrunner");
                    p.sendTitle(ChatColor.GREEN + "Victory", ChatColor.GREEN + "You killed the speedrunner", 10, 5, 10);
                    p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
                }
            }
        }
    }
}
