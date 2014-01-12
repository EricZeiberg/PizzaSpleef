package me.masterejay.pizzaspleef.listeners;

import me.masterejay.pizzaspleef.PizzaSpleef;
import me.masterejay.pizzaspleef.match.MatchState;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * @author MasterEjay
 */
public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        if (PizzaSpleef.getObservers().isPlayerObserving(e.getPlayer()) || PizzaSpleef.getState() != MatchState.PLAYING){
            e.setCancelled(true);
        }
        else if (e.getBlock().getType() == Material.OBSIDIAN){
            for (Player p : PizzaSpleef.getPlaying().getPlayers()){
                if (p != e.getPlayer()){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 7, 0));
                }
            }
        }
        else if (e.getBlock().getType() == Material.REDSTONE_BLOCK){
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 1));
        }
        else if (e.getBlock().getType() == Material.WOOL){
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10, 5));
        }
        else if (e.getBlock().getType() == Material.IRON_BLOCK){
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10, 0));
        }
        else if (e.getBlock().getType() == Material.WOOD){
            ItemStack i = new ItemStack(Material.MONSTER_EGG);
            i.setAmount(3);
            i.setDurability((short) 50);
            e.getPlayer().getInventory().addItem(i);
        }
        else if (e.getBlock().getType() == Material.SOUL_SAND){
            ItemStack i = new ItemStack(Material.POTION);
            i.setAmount(3);
            PotionMeta meta = (PotionMeta) i.getItemMeta();
            meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 15, 0), true);
            i.setItemMeta(meta);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        e.setCancelled(true);
    }
}
