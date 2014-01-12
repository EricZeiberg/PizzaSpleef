package me.masterejay.pizzaspleef.listeners;

import me.masterejay.pizzaspleef.PizzaSpleef;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author MasterEjay
 */
public class ConnectionListener implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        PizzaSpleef.getObservers().addObserver(p);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        if (PizzaSpleef.getObservers().isPlayerObserving(e.getPlayer())){
            PizzaSpleef.getObservers().removeObserver(e.getPlayer());
        }
        else if (PizzaSpleef.getPlaying().getPlayers().contains(e.getPlayer())){
            PizzaSpleef.getPlaying().removePlaying(e.getPlayer());
        }
    }


}
