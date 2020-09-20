package gq.arnu515.manhunt.commands;

import gq.arnu515.manhunt.Manhunt;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Compass implements CommandExecutor {

    private Manhunt mh;

    public Compass(Manhunt mh) {
        this.mh = mh;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("manhunt.getcompass")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (mh.speedRunner == null) {
                    sender.sendMessage(ChatColor.RED + "Set a speedrunner first using the /speedrunner command");
                    return true;
                }
                if (p.getName().equalsIgnoreCase(mh.speedRunner.getName())) {
                    sender.sendMessage(ChatColor.RED + "You're a speedrunner. You can't have access to the compass");
                    return true;
                }
                ItemStack compass = new ItemStack(Material.COMPASS, 1);
                ItemMeta compassIM = compass.getItemMeta();
                compassIM.setDisplayName(ChatColor.GREEN + "Speedrunner tracker");
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.GRAY + "RightClick to track the speedrunner");
                compassIM.setLore(lore);
                compassIM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                compassIM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                compass.setItemMeta(compassIM);
                p.getInventory().addItem(compass);
                p.sendMessage(ChatColor.GREEN + "Received speedrunner tracker");
            } else {
                sender.sendMessage(ChatColor.RED + "Only players can do that");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to do that");
        }
        return true;
    }
}
