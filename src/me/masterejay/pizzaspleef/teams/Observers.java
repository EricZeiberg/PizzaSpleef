package me.masterejay.pizzaspleef.teams;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MasterEjay
 */
public class Observers {

    private static List<Player> observers = new ArrayList<Player>();

     public void addObserver(Player player){
         if (observers.contains(player)){
             return;
         }
         observers.add(player);
         player.setDisplayName(ChatColor.AQUA + player.getName());
         player.sendMessage(ChatColor.GRAY + "You have joined the " + ChatColor.AQUA + "Observers");
     }

    public List<Player> getObservers(){
        return observers;
    }

    public void removeObserver(Player player){
        if (observers.contains(player)){
            observers.remove(player);
        }
    }

    public boolean isPlayerObserving(Player player){
        if (observers.contains(player)){
            return true;
        }
        else {
            return false;
        }
    }

}
