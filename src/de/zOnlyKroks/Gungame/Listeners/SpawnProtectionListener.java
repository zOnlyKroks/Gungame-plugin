package de.zOnlyKroks.Gungame.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import de.zOnlyKroks.Gungame.Gungame;

public class SpawnProtectionListener implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
	FileConfiguration config = Gungame.getPlugin().getConfig();
	int Radius = config.getInt("Radius");
	Player p = (Player) e.getEntity();
	if(e.getEntity()instanceof Player && p.getLocation().distance(Bukkit.getWorld("world").getSpawnLocation()) < Radius) {
	e.setCancelled(true);
		}
	}
}
