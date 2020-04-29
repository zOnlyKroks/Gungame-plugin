package de.zOnlyKroks.Gungame;

import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GunGameScoreBoard {
	
	public static void sendScoreboard(Player player) {
		int p = Bukkit.getOnlinePlayers().size();
	    int level = player.getLevel();
	    Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
	    Objective obj = (board.getObjective("aaa") != null) ? board.getObjective("aaa") : board.registerNewObjective("aaa", "bbb");
	    obj.setDisplayName("§bTrashNetwork.eu");
	    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
	    player.setScoreboard(board);
	    obj.getScore("§8•§7● §7Coins").setScore(1);
	    obj.getScore("§8•§7● §7K/D").setScore(4);
	    obj.getScore("§8•§7● §7Spieler").setScore(7);
	    obj.getScore("§8•§7● §7Map").setScore(10);
	    obj.getScore("§8•§7● §7Level").setScore(13);
	    obj.getScore(" ").setScore(14);
        obj.getScore("  ").setScore(11);
        obj.getScore("   ").setScore(8);
        obj.getScore("    ").setScore(5);
        obj.getScore("     ").setScore(2);
        Team Coins = board.registerNewTeam("Coins");
        Team Spieler = board.registerNewTeam("Spieler");
        Team KD = board.registerNewTeam("KD");
        Team Map = board.registerNewTeam("Map");
        Team Level = board.registerNewTeam("Level");
        Coins.setPrefix("§b");
        Coins.setSuffix("§b➟ Coins");
        Coins.addEntry(ChatColor.AQUA.toString());
        obj.getScore(ChatColor.AQUA.toString()).setScore(0); //Coins musst du noch nach belieben ändern
        Spieler.setPrefix("§b");
        Spieler.setSuffix("§b➟ " + p);
        Spieler.addEntry(ChatColor.BLUE.toString());
        obj.getScore(ChatColor.BLUE.toString()).setScore(6);
        KD.setPrefix("§b");
        KD.setSuffix("§b➟ " + getKD(player.getUniqueId().toString()));
        KD.addEntry(ChatColor.DARK_RED.toString());
        obj.getScore(ChatColor.DARK_RED.toString()).setScore(3);
        Map.setPrefix("§b");
        Map.setSuffix("§b➟ Map");
        Map.addEntry(ChatColor.RED.toString());
        obj.getScore(ChatColor.RED.toString()).setScore(9);
        Level.setPrefix("§b");
        Level.setSuffix("§b➟ " + level);
        Level.addEntry(ChatColor.GREEN.toString());
        obj.getScore(ChatColor.GREEN.toString()).setScore(12);
	}
	
	public static void updateScoreboard(Player player) {
		if (player.getScoreboard() != null) {
			int p = Bukkit.getOnlinePlayers().size();
		    int level = player.getLevel();
			Objective obj = (player.getScoreboard().getObjective("aaa") != null) ? player.getScoreboard().getObjective("aaa") : player.getScoreboard().registerNewObjective("aaa", "bbb");
			obj.getScoreboard().getTeam("Spieler").setSuffix("§b➟ " + p);
			obj.getScoreboard().getTeam("KD").setSuffix("§b➟ " + getKD(player.getUniqueId().toString()));
			obj.getScoreboard().getTeam("Map").setSuffix("§b➟ Map");
			obj.getScoreboard().getTeam("Level").setSuffix("§b➟ " + level);
			obj.getScoreboard().getTeam("Coins").setSuffix("§b➟ Coins"); //Coins musst du noch nach belieben ändern
		}
	}
    
    public static double getKD(String id) {
        double kd = 0.0;
        double kills = Gungame.database.get(id, "Kills");
        double deaths = Gungame.database.get(id, "Deaths");
        if (deaths == 0.0) {
            kd = kills;
        }
        else if (kills == 0.0) {
            kd = 0.0;
        }
        else {
            kd = kills / deaths;
        }
        kd = (double)(Math.round(100.0 * kd) / 100L);
        return kd;
    }
}
