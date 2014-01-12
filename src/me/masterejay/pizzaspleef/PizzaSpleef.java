package me.masterejay.pizzaspleef;

import com.sk89q.bukkit.util.CommandsManagerRegistration;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.CommandPermissionsException;
import com.sk89q.minecraft.util.commands.CommandUsageException;
import com.sk89q.minecraft.util.commands.CommandsManager;
import com.sk89q.minecraft.util.commands.MissingNestedCommandException;
import com.sk89q.minecraft.util.commands.WrappedCommandException;
import me.masterejay.pizzaspleef.commands.JoinCommand;
import me.masterejay.pizzaspleef.commands.RegenerateCommand;
import me.masterejay.pizzaspleef.commands.StartCommand;
import me.masterejay.pizzaspleef.listeners.BlockBreakListener;
import me.masterejay.pizzaspleef.listeners.ConnectionListener;
import me.masterejay.pizzaspleef.teams.Observers;
import me.masterejay.pizzaspleef.teams.Playing;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author MasterEjay
 */
public class PizzaSpleef extends JavaPlugin {

    private static Playing playing = new Playing();
    private static Observers observers = new Observers();
    public CommandsManager<CommandSender> commands;
    private static PizzaSpleef plugin;

    @Override
    public void onEnable(){
        getLogger().info("Pizza Spleef: Vanila Version by SethBling | Bukkit version by MasterEjay (MasterEjzz)");
        getServer().getPluginManager().registerEvents(new ConnectionListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        setupCommands();
        plugin = this;
        if (getServer().getOnlinePlayers().length > 0){
            for (Player p : getServer().getOnlinePlayers()){
                getObservers().addObserver(p);
            }
        }
    }

    public static Playing getPlaying(){
        return playing;
    }

    public static Observers getObservers(){
        return observers;
    }

    public static PizzaSpleef get(){
        return plugin;
    }

    public void setupCommands() {
        commands = new CommandsManager<CommandSender>() {
            @Override
            public boolean hasPermission(CommandSender sender, String permission) {
                return sender instanceof ConsoleCommandSender || sender.hasPermission(permission);
            }
        };

        CommandsManagerRegistration cmdRegister = new CommandsManagerRegistration(this, commands);
        cmdRegister.register(StartCommand.class);
        cmdRegister.register(JoinCommand.class);
        cmdRegister.register(RegenerateCommand.class);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        try {
            this.commands.execute(cmd.getName(), args, sender, sender);
        } catch (CommandPermissionsException ex) {
            sender.sendMessage(ChatColor.RED + "You don't have permission.");
        } catch (MissingNestedCommandException ex) {
            sender.sendMessage(ChatColor.RED + ex.getUsage());
        } catch (CommandUsageException ex) {
            sender.sendMessage(ChatColor.RED + ex.getMessage());
            sender.sendMessage(ChatColor.RED + ex.getUsage());
        } catch (WrappedCommandException ex) {
            if (ex.getCause() instanceof NumberFormatException) {
                sender.sendMessage(ChatColor.RED + "Number expected, string received instead.");
            } else {
                sender.sendMessage(ChatColor.RED + "An error has occurred running command " + ChatColor.DARK_RED + cmd.getName());
                ex.printStackTrace();
            }
        } catch (CommandException ex) {
            sender.sendMessage(ChatColor.RED + ex.getMessage());
        }

        return true;
    }

}
