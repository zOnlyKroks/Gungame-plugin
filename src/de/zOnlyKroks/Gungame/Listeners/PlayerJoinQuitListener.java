package de.zOnlyKroks.Gungame.Listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.zOnlyKroks.Gungame.GunGameScoreBoard;
import de.zOnlyKroks.Gungame.Gungame;

public class PlayerJoinQuitListener implements Listener{
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
    	String id = event.getPlayer().getUniqueId().toString();
    	Gungame.database.checkPlayer(id);
    	
    	Player player = event.getPlayer();
    	String p = event.getPlayer().getName().toString();
        event.setJoinMessage("§6" + p + " §6ist gejoint");
        player.getInventory().clear();
        GunGameScoreBoard.sendScoreboard(player);
        player.setGameMode(GameMode.ADVENTURE);
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String player = event.getPlayer().getName();
        event.setQuitMessage("§6" + player + " §6hat das Spiel verlassen");
        event.getPlayer().setLevel(1);
    }
}
