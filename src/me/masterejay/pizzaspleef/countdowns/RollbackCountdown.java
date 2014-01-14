package me.masterejay.pizzaspleef.countdowns;

import me.masterejay.pizzaspleef.match.MatchHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * @author MasterEjay
 */
public class RollbackCountdown extends Countdown{

    @Override
    public void onEnd() {
        for (Player p : Bukkit.getOnlinePlayers()){
            p.kickPlayer(ChatColor.GREEN + "Restoring world! Rejoin!");
        }
        MatchHandler.rollback("Lobby");
    }

    @Override
    public void tick(int secs) {
        if (secs % 5 == 0 || secs < 5) {
            Bukkit.broadcastMessage(ChatColor.AQUA + "Rolling back world in " + ChatColor.DARK_RED + "" + secs + ChatColor.AQUA + " second" + (secs == 1 ? "" : "s") + "!");
        }

    }
}
