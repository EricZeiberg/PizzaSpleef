package me.masterejay.pizzaspleef.listeners;

import me.masterejay.pizzaspleef.PizzaSpleef;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * @author MasterEjay
 */
public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if (PizzaSpleef.getPlaying().getPlayers().contains(e.getEntity())){
            e.setDeathMessage(ChatColor.GOLD + e.getEntity().getName() + " is out of the game!");
            PizzaSpleef.getPlaying().removePlaying(e.getEntity());
            PizzaSpleef.getObservers().addObserver(e.getEntity());
            if (PizzaSpleef.getPlaying().getPlayers().size() == 1){
                PizzaSpleef.getMatchHandler().finish(PizzaSpleef.getPlaying().getPlayers().get(0));
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        e.getPlayer().teleport(new Location(PizzaSpleef.get().getServer().getWorld("Lobby"), -17, 72, -69, 2, 180));
    }
}
