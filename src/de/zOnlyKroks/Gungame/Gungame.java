package de.zOnlyKroks.Gungame;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.zOnlyKroks.Gungame.Commands.BuildCommand;
import de.zOnlyKroks.Gungame.Commands.CheckCommand;
import de.zOnlyKroks.Gungame.Listeners.JoinQuitListener;
import de.zOnlyKroks.Gungame.Listeners.PlayerDeathListener;
import de.zOnlyKroks.Gungame.Listeners.PlayerWaterListener;

public class Gungame extends JavaPlugin implements Listener{
	
public static MySQL database;
    
public void onEnable() {
    	plugin = this;
        System.out.println("Das Plugin wurde aktiviert");
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerWaterListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new SpawnProtectionListener(), this);
        this.getCommand("build").setExecutor(new BuildCommand());
        this.getCommand("check").setExecutor(new CheckCommand());
        Gungame.database = new MySQL("85.209.51.238", 3306, "mc19", "mc19", "54e0401cdc");
        counter();
        
        FileConfiguration config = Gungame.getPlugin().getConfig();
        if(!config.contains("Spawnschutz")) {
        	config.set("Breite + Länge", 8);
        	config.set("Höhe", 8);
        	Gungame.getPlugin().saveConfig();
        }else {
        	return;
        }
    }
    
    public static Gungame getPlugin() {
		return plugin;
	}
    
    public void onDisable() {
        System.out.println("Das Plugin wurde deaktiviert");
        Gungame.database.disconnect();
    }
    
    public void counter() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    GunGameScoreBoard.updateScoreboard(p);
                }
            }
        }, 0L, 20L);
    }
	
}
