package gq.arnu515.manhunt;

import gq.arnu515.manhunt.commands.Compass;
import gq.arnu515.manhunt.commands.SpeedRunner;
import gq.arnu515.manhunt.listeners.SpeedRunnerDead;
import gq.arnu515.manhunt.listeners.SpeedRunnerTrack;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Manhunt extends JavaPlugin {
    public Player speedRunner;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SpeedRunnerTrack(this), this);
        getServer().getPluginManager().registerEvents(new SpeedRunnerDead(this), this);
        getCommand("speedrunner").setExecutor(new SpeedRunner(this));
        getCommand("compass").setExecutor(new Compass(this));
    }
}
