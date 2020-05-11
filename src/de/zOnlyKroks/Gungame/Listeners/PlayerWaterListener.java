package de.zOnlyKroks.Gungame.Listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerWaterListener implements Listener{
	
	@EventHandler
	  public void touchWater(PlayerMoveEvent e) {
	    Player p = e.getPlayer();
	    if(p.getGameMode().equals(GameMode.CREATIVE)) {
	    	return;
	    }
	    if (p.getLocation().getBlock().getType() == Material.WATER || p.getLocation().getBlock().getType() == Material.STATIONARY_WATER)
	      p.damage(40.0D); 
	  }
	
	@EventHandler
	public void hungerEvent(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	
}
