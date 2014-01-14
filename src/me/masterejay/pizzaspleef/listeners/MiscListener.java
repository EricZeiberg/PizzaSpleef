package me.masterejay.pizzaspleef.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * @author MasterEjay
 */
public class MiscListener implements Listener {

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player){
            ((Player) e.getEntity()).setHealth(20);
        }
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        e.setFormat(e.getPlayer().getDisplayName() + ": " + ChatColor.WHITE + e.getMessage());
    }
}
