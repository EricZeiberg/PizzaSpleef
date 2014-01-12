package me.masterejay.pizzaspleef.teams;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MasterEjay
 */
public class Playing {

    private static List<Player> players = new ArrayList<Player>();

    public void addPlaying(Player player){
        if (players.contains(player)){
            return;
        }
        players.add(player);
        player.setDisplayName(ChatColor.RED + player.getName());
        player.sendMessage(ChatColor.GRAY + "You have joined the " + ChatColor.RED + "Players");
    }

    public List<Player> getPlayers(){
        return players;
    }

    public void removePlaying(Player player){
        if (players.contains(player)){
            players.remove(player);
        }

    }

}
