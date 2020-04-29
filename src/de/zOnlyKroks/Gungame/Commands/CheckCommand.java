package de.zOnlyKroks.Gungame.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CheckCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
            Player player = (Player) sender;
            player.getInventory().clear();
            player.getInventory().setArmorContents(null);
            player.setAllowFlight(true);
            
            ItemStack stick = new ItemStack(Material.STICK);
            ItemMeta stickMeta = stick.getItemMeta();
            stickMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
            stickMeta.setDisplayName("Velocity Überführer 3001");
            stick.setItemMeta(stickMeta);
            player.getInventory().setItem(0, stick);
	}
		return true;
	}

}
