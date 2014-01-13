package me.masterejay.pizzaspleef.listeners;

import me.masterejay.pizzaspleef.PizzaSpleef;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * @author MasterEjay
 */
public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if (PizzaSpleef.getPlaying().getPlayers().contains(e.getEntity())){
            PizzaSpleef.getPlaying().removePlaying(e.getEntity());
            PizzaSpleef.getObservers().addObserver(e.getEntity());
            if (PizzaSpleef.getPlaying().getPlayers().size() == 1){
                PizzaSpleef.getMatchHandler().finish(PizzaSpleef.getPlaying().getPlayers().get(0));
            }
        }
    }
}
