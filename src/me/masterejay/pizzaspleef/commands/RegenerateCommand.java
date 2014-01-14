package me.masterejay.pizzaspleef.commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import me.masterejay.pizzaspleef.countdowns.CountdownMethods;
import me.masterejay.pizzaspleef.countdowns.RollbackCountdown;
import org.bukkit.command.CommandSender;

/**
 * This command is unused atm
 * @author MasterEjay
 */
public class RegenerateCommand {

    @Command(aliases = {"rollback", "regen"}, desc = "Regenerates the world", usage = "<time>", min=0, max=1)
    public static void rollback(CommandContext cmd, CommandSender sender) throws CommandException {
        if (cmd.argsLength() == 0){
           CountdownMethods.start(new RollbackCountdown(), 15);
        }
        else if (cmd.argsLength() == 1){
            CountdownMethods.start(new RollbackCountdown(), cmd.getInteger(0));
        }

    }

}
