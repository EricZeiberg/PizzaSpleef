package me.masterejay.pizzaspleef.commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @author MasterEjay
 */
public class RegenerateCommand {

    @Command(aliases = {"regen", "regenerate"}, desc = "Regenerates the world", usage = "", min=1, max=1)
    public static void regen(CommandContext cmd, CommandSender sender) throws CommandException {
        int radius = cmd.getInteger(0);
        float xy = radius / 2;
        int xv = Math.round(xy);
        int zv = Math.round(xy);
        if (sender instanceof ConsoleCommandSender){
            throw new CommandException("Consoles can't use this command");
        }
        Player player = (Player) sender;
    }
}
