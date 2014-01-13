package me.masterejay.pizzaspleef.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

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
}
