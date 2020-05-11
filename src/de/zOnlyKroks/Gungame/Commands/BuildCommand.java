package de.zOnlyKroks.Gungame.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	    if (!sender.hasPermission("gungame.build"))
	      return true; 
	    if (sender instanceof Player) {
	      Player player = (Player)sender;
	      if (player.getGameMode().equals(GameMode.ADVENTURE)) {
	        player.setGameMode(GameMode.CREATIVE);
	      } else if (player.getGameMode().equals(GameMode.CREATIVE)) {
	        player.setGameMode(GameMode.ADVENTURE);
	        player.setHealth(20.0D);
	      } else if (!(sender instanceof Player)) {
	        System.out.println("Die Konsole kann das nicht :)");
	      } 
	    } 
	    return true;
	  }
	
}
