package me.masterejay.pizzaspleef.match;

import me.masterejay.pizzaspleef.PizzaSpleef;
import me.masterejay.pizzaspleef.countdowns.Countdown;
import me.masterejay.pizzaspleef.countdowns.CountdownMethods;
import me.masterejay.pizzaspleef.countdowns.RollbackCountdown;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;

/**
 * @author MasterEjay
 */
public class MatchHandler {

    public static void start(){
        PizzaSpleef.setState(MatchState.PLAYING);
        for (Player p :PizzaSpleef.getPlaying().getPlayers()) {
            p.teleport(new Location(p.getWorld(), -17, 65, -23, 0, 180));
            p.setGameMode(GameMode.SURVIVAL);
            ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta meta = pickaxe.getItemMeta();
            meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
            meta.addEnchant(Enchantment.DURABILITY, 5, true);
            pickaxe.setItemMeta(meta);
            p.getInventory().clear();
            p.getInventory().addItem(pickaxe);
            Location location = p.getLocation();
            Location loc1 = location.add(genSpawn(p.getWorld()));
            p.teleport(loc1);
          }
        }

    private static Location genSpawn(World world){
        Location loc = null;
        for(int i = 0 ; i < 20 ; i++) {
            int radius = 30;
            int max = 10;
            double x = (Math.random() * (max * 2)) - max;
            double y = 0;
            double z = (Math.random() * (max * 2)) - max;
            double center_x = -17;
            int center_z = -13;
            if (Math.pow(x - center_x, 2) + Math.pow(z - center_z, 2) < Math.pow(radius, 2)){
                loc = new Location(world, x, y, z);
                return loc;
            }
            else {
                genSpawn(world);
            }
        }
        return loc;
    }

    public static void finish(Player winner){
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "############");
        Bukkit.broadcastMessage(ChatColor.GREEN + "The match has ended!");
        Bukkit.broadcastMessage(ChatColor.GREEN + winner.getName() + " has won!");
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "############");
        PizzaSpleef.setState(MatchState.FINISHED);
        PizzaSpleef.getPlaying().removePlaying(winner);
        PizzaSpleef.getObservers().addObserver(winner);
        winner.getInventory().clear();
        winner.getActivePotionEffects().clear();
        CountdownMethods.start(new RollbackCountdown(), 15);

    }

    //Unloading maps, to rollback maps. Will delete all player builds until last server save
    public static void unloadMap(String mapname){
        if(Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(mapname), false)){
            PizzaSpleef.get().getLogger().info("Successfully unloaded " + mapname);
        }else{
            PizzaSpleef.get().getLogger().severe("COULD NOT UNLOAD " + mapname);
        }
    }
    //Loading maps (MUST BE CALLED AFTER UNLOAD MAPS TO FINISH THE ROLLBACK PROCESS)
    public static void loadMap(String mapname){
        Bukkit.getServer().createWorld(new WorldCreator(mapname));
    }

    //Maprollback method, because were too lazy to type 2 lines
    public static void rollback(String mapname){
        unloadMap(mapname);
        loadMap(mapname);
    }
}
