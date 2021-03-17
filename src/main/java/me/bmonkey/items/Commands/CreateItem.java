package me.bmonkey.items.Commands;

import me.bmonkey.items.Items.ItemCreation;
import me.bmonkey.items.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class CreateItem implements CommandExecutor {

    public ItemCreation item;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!label.equalsIgnoreCase("citem")){
            return true;
        }
        item = new ItemCreation((Main.getPlugin(Main.class)));
        if(!(sender instanceof Player)){
            sender.sendMessage("Only players can execute this command");
            return true;
        }
        Player player = (Player) sender;
        String argsC = String.join(" ", args);
        item.addItemToDatabase(player, argsC);
        return true;
    }
}
