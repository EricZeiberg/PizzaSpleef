package me.masterejay.pizzaspleef.commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import me.masterejay.pizzaspleef.PizzaSpleef;
import me.masterejay.pizzaspleef.countdowns.CountdownMethods;
import me.masterejay.pizzaspleef.countdowns.MatchStartCountdown;
import me.masterejay.pizzaspleef.match.MatchState;
import org.bukkit.command.CommandSender;

/**
 * @author MasterEjay
 */
public class StartCommand{

    @Command(aliases = {"start"}, desc = "Starts the game", usage = "<time>", min=0, max=1)
    public static void start(CommandContext cmd, CommandSender sender) throws CommandException {
        if (PizzaSpleef.getState() != MatchState.FINISHED ){
            throw new CommandException("The match cannot be started at this time");
        }
        else if (PizzaSpleef.getPlaying().getPlayers().size() < 2){
            throw new CommandException("Not enough people!");
        }
         if (cmd.argsLength() == 0){
             CountdownMethods.start(new MatchStartCountdown(), 15);
             PizzaSpleef.setState(MatchState.STARTING);
         }
         else if (cmd.argsLength() == 1){
             CountdownMethods.start(new MatchStartCountdown(), cmd.getInteger(0));
         }
    }

}
