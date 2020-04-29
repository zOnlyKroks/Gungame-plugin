package de.zOnlyKroks.Gungame.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerWaterListener implements Listener{
	
	@EventHandler
	  public void touchWater(PlayerMoveEvent e) {
	    Player p = e.getPlayer();
	    if(p.isFlying()) {
	    	return;
	    }
	    if (p.getLocation().getBlock().getType() == Material.WATER || p.getLocation().getBlock().getType() == Material.STATIONARY_WATER)
	      p.damage(40.0D); 
	  }
}
