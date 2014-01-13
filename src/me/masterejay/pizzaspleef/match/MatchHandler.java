package me.masterejay.pizzaspleef.match;

import me.masterejay.pizzaspleef.PizzaSpleef;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * @author MasterEjay
 */
public class MatchHandler {

    public static void start(){
        PizzaSpleef.setState(MatchState.PLAYING);
        for (Player p :PizzaSpleef.getPlaying().getPlayers()) {
            p.teleport(new Location(p.getWorld(), -17, 65, -23, 0, 180));
            Location location = p.getLocation();
            for(int i = 0 ; i < 30 ; i++) {
                int max = 5;
                double x = Math.random() * (max * 2) - max;
                double y = -2;
                double z = Math.random() * (max * 2) - max;

                location.add(x,y,z);
                p.teleport(location);
          }
        }
    }

    public static void finish(Player winner){
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "############");
        Bukkit.broadcastMessage(ChatColor.GREEN + "The match has ended!");
        Bukkit.broadcastMessage(ChatColor.GREEN + winner.getName() + " has won!");
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "############");
        PizzaSpleef.setState(MatchState.FINISHED);
    }
}
