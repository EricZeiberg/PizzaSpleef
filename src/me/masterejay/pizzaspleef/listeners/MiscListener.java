package me.masterejay.pizzaspleef.listeners;

import me.masterejay.pizzaspleef.PizzaSpleef;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

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

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        if (PizzaSpleef.getObservers().isPlayerObserving(e.getPlayer()) && e.getTo().getBlockY() < -4){
            e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), -17, 72, -69, 2, 180));
        }
    }
}
