package de.zOnlyKroks.Gungame.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CheckCommand implements CommandExecutor{
	
	public static ArrayList<CommandSender> check = new ArrayList<>();
	  
	@Override
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	    if (!sender.hasPermission("gungame.check")) {
	      sender.sendMessage("UngenRechte");
	      return true;
	    } 
	    if (sender instanceof Player && !check.contains(sender)) {
	      Player player = (Player)sender;
	      check.add(sender);
	      player.getInventory().clear();
	      player.getInventory().setArmorContents(null);
	      player.setAllowFlight(true);
	      for (Player all : Bukkit.getOnlinePlayers()) {
	        if (all != player)
	          all.hidePlayer(player); 
	      } 
	      ItemStack stick = new ItemStack(Material.STICK);
	      ItemMeta stickMeta = stick.getItemMeta();
	      stickMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
	      stickMeta.setDisplayName("Velocity 3001");
	      stick.setItemMeta(stickMeta);
	      player.getInventory().setItem(0, stick);
	    } else if (!(sender instanceof Player)) {
	      System.out.println("Die Konsole kann das nicht :)");
	    } else if (sender instanceof Player && check.contains(sender)) {
	      Player player = (Player)sender;
	      check.remove(sender);
	      player.getInventory().clear();
	      player.getInventory().setArmorContents(null);
	      player.setAllowFlight(false);
	      player.setGameMode(GameMode.ADVENTURE);
	      player.setHealth(20.0D);
	      for (Player all : Bukkit.getOnlinePlayers()) {
	        if (all != player)
	          all.showPlayer(player); 
	      } 
	    } 
	    return true;
	  }
	
}
