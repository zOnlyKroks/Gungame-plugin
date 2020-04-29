
package de.zOnlyKroks.Gungame.Listeners;

import org.bukkit.inventory.meta.ItemMeta;

import de.zOnlyKroks.Gungame.Gungame;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.Listener;

public class PlayerDeathListener implements Listener
{
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (!(event.getEntity() instanceof Player && event.getEntity() != null)) {
            return;
        }
        
	    event.setDeathMessage(null);
        
        event.setDroppedExp(0);
        event.setKeepInventory(true);
        Player player = event.getEntity();
        Player killer = player.getKiller();
      
        String id = player.getUniqueId().toString();
        int wert = Gungame.database.get(id, "Deaths");
        Gungame.database.set(id, "Deaths", wert + 1);
        
        if(killer != null) {
        String id2 = killer.getUniqueId().toString();
        int wert2 = Gungame.database.get(id2, "Kills");
        Gungame.database.set(id2, "Kills", wert2 + 1);
        }else {
        	return;
        }
        
        killer.setLevel(killer.getLevel() + 1);
        
        if (player.getLevel() == 7) {
            return;
        }
        if (player.getLevel() != 1) {
            event.setNewLevel(player.getLevel() - 1);
            player.setLevel(player.getLevel() - 1);
        }
        if (player.getLevel() == 0) {
            player.setLevel(1);
        }
        if (player.getLevel() == 0) {
            player.giveExpLevels(1);
        }
        if (player.getLevel() == 1) {
            event.setNewLevel(1);
            player.setLevel(1);
        }
        checkKit(player);
        checkKit(killer);
    }
    
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        checkKit(event.getPlayer());
    }
    
    public static void checkKit(Player player) {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        if (player.getLevel() == 1) {
            player.sendMessage("Du hast Level 1 erreicht");
            final ItemStack item2 = new ItemStack(Material.WOOD_AXE);
            final ItemMeta item2Meta = item2.getItemMeta();
            item2Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            item2Meta.setDisplayName("§7Noob Vernichter");
            item2.setItemMeta(item2Meta);
            player.getInventory().setItemInHand(item2);
        }
        if (player.getLevel() == 2) {
            player.sendMessage("Du hast Level 2 erreicht");
            final ItemStack item2 = new ItemStack(Material.WOOD_SWORD);
            final ItemMeta item2Meta = item2.getItemMeta();
            item2Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            item2Meta.setDisplayName("§7Noob Vernichter");
            item2.setItemMeta(item2Meta);
            player.getInventory().setItemInHand(item2);
        }
        if (player.getLevel() == 3) {
            player.sendMessage("Du hast Level 3 erreicht");
            final ItemStack item2 = new ItemStack(Material.WOOD_SWORD);
            final ItemMeta item2Meta = item2.getItemMeta();
            item2Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            item2Meta.setDisplayName("§7Noob Vernichter");
            item2.setItemMeta(item2Meta);
            player.getInventory().setItemInHand(item2);
            final ItemStack armor1 = new ItemStack(Material.LEATHER_HELMET);
            final ItemMeta armor1Meta = armor1.getItemMeta();
            armor1Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor1Meta.setDisplayName("§7Ultimativer Schutz");
            armor1.setItemMeta(armor1Meta);
            player.getInventory().setHelmet(armor1);
        }
        if (player.getLevel() == 4) {
            player.sendMessage("Du hast Level 4 erreicht");
            final ItemStack item2 = new ItemStack(Material.WOOD_SWORD);
            final ItemMeta item2Meta = item2.getItemMeta();
            item2Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            item2Meta.setDisplayName("§7Noob Vernichter");
            item2.setItemMeta(item2Meta);
            player.getInventory().setItemInHand(item2);
            final ItemStack armor1 = new ItemStack(Material.LEATHER_HELMET);
            final ItemMeta armor1Meta = armor1.getItemMeta();
            armor1Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor1Meta.setDisplayName("§7Ultimativer Schutz");
            armor1.setItemMeta(armor1Meta);
            player.getInventory().setHelmet(armor1);
            final ItemStack armor2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            final ItemMeta armor2Meta = armor2.getItemMeta();
            armor2Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor2Meta.setDisplayName("§7Ultimativer Schutz");
            armor2.setItemMeta(armor2Meta);
            player.getInventory().setChestplate(armor2);
        }
        if (player.getLevel() == 5) {
            player.sendMessage("Du hast Level 5 erreicht");
            final ItemStack item2 = new ItemStack(Material.WOOD_SWORD);
            final ItemMeta item2Meta = item2.getItemMeta();
            item2Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            item2Meta.setDisplayName("§7Noob Vernichter");
            item2.setItemMeta(item2Meta);
            player.getInventory().setItemInHand(item2);
            final ItemStack armor1 = new ItemStack(Material.LEATHER_HELMET);
            final ItemMeta armor1Meta = armor1.getItemMeta();
            armor1Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor1Meta.setDisplayName("§7Ultimativer Schutz");
            armor1.setItemMeta(armor1Meta);
            player.getInventory().setHelmet(armor1);
            final ItemStack armor2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            final ItemMeta armor2Meta = armor2.getItemMeta();
            armor2Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor2Meta.setDisplayName("§7Ultimativer Schutz");
            armor2.setItemMeta(armor2Meta);
            player.getInventory().setChestplate(armor2);
            final ItemStack armor3 = new ItemStack(Material.LEATHER_LEGGINGS);
            final ItemMeta armor3Meta = armor3.getItemMeta();
            armor3Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor3Meta.setDisplayName("§7Ultimativer Schutz");
            armor3.setItemMeta(armor3Meta);
            player.getInventory().setLeggings(armor3);
        }
        if (player.getLevel() == 6) {
            player.sendMessage("Du hast Level 6 erreicht");
            final ItemStack item2 = new ItemStack(Material.WOOD_SWORD);
            final ItemMeta item2Meta = item2.getItemMeta();
            item2Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            item2Meta.setDisplayName("§7Noob Vernichter");
            item2.setItemMeta(item2Meta);
            player.getInventory().setItemInHand(item2);
            final ItemStack armor1 = new ItemStack(Material.LEATHER_HELMET);
            final ItemMeta armor1Meta = armor1.getItemMeta();
            armor1Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor1Meta.setDisplayName("§7Ultimativer Schutz");
            armor1.setItemMeta(armor1Meta);
            player.getInventory().setHelmet(armor1);
            final ItemStack armor2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            final ItemMeta armor2Meta = armor2.getItemMeta();
            armor2Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor2Meta.setDisplayName("§7Ultimativer Schutz");
            armor2.setItemMeta(armor2Meta);
            player.getInventory().setChestplate(armor2);
            final ItemStack armor3 = new ItemStack(Material.LEATHER_LEGGINGS);
            final ItemMeta armor3Meta = armor2.getItemMeta();
            armor3Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor3Meta.setDisplayName("§7Ultimativer Schutz");
            armor3.setItemMeta(armor3Meta);
            player.getInventory().setLeggings(armor3);
            final ItemStack armor4 = new ItemStack(Material.LEATHER_BOOTS);
            final ItemMeta armor4Meta = armor4.getItemMeta();
            armor4Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor4Meta.setDisplayName("§7Ultimativer Schutz");
            armor4.setItemMeta(armor4Meta);
            player.getInventory().setBoots(armor4);
        }
        if (player.getLevel() == 7) {
            player.sendMessage("Du hast Level 7 erreicht");
            final ItemStack item2 = new ItemStack(Material.DIAMOND_SWORD);
            final ItemMeta item2Meta = item2.getItemMeta();
            item2Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            item2Meta.setDisplayName("§7Noob Vernichter");
            item2.setItemMeta(item2Meta);
            player.getInventory().setItemInHand(item2);
            final ItemStack armor1 = new ItemStack(Material.DIAMOND_HELMET);
            final ItemMeta armor1Meta = armor1.getItemMeta();
            armor1Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor1Meta.setDisplayName("§7Ultimativer Schutz");
            armor1.setItemMeta(armor1Meta);
            player.getInventory().setHelmet(armor1);
            final ItemStack armor2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            final ItemMeta armor2Meta = armor2.getItemMeta();
            armor2Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor2Meta.setDisplayName("§7Ultimativer Schutz");
            armor2.setItemMeta(armor2Meta);
            player.getInventory().setChestplate(armor2);
            final ItemStack armor3 = new ItemStack(Material.DIAMOND_LEGGINGS);
            final ItemMeta armor3Meta = armor2.getItemMeta();
            armor3Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor3Meta.setDisplayName("§7Ultimativer Schutz");
            armor3.setItemMeta(armor3Meta);
            player.getInventory().setLeggings(armor3);
            final ItemStack armor4 = new ItemStack(Material.DIAMOND_BOOTS);
            final ItemMeta armor4Meta = armor4.getItemMeta();
            armor4Meta.addEnchant(Enchantment.DURABILITY, 100, true);
            armor4Meta.setDisplayName("§7Ultimativer Schutz");
            armor4.setItemMeta(armor4Meta);
            player.getInventory().setBoots(armor4);
        }
    }
}
