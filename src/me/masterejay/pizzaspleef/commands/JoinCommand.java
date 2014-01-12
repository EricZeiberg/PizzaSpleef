package me.masterejay.pizzaspleef.commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import me.masterejay.pizzaspleef.PizzaSpleef;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * @author MasterEjay
 */
public class JoinCommand {

    @Command(aliases = {"join", "j", "p"}, desc = "Join the game", usage = "")
    public static void join(CommandContext cmd, CommandSender sender) throws CommandException {
        if (sender instanceof ConsoleCommandSender){
            throw new CommandException("Consoles can't use this command");
        }
       Player player = (Player) sender;
      if (PizzaSpleef.getObservers().isPlayerObserving(player)){
          PizzaSpleef.getObservers().removeObserver(player);
          PizzaSpleef.getPlaying().addPlaying(player);
      }
        else {
          sender.sendMessage(ChatColor.RED +"You are already participating");
      }
    }
}
