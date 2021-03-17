package me.bmonkey.items.Commands;

import me.bmonkey.items.Main;
import me.bmonkey.items.MySQL.ItemsSQL;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddCustomName implements CommandExecutor {

    public ItemsSQL item;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!label.equalsIgnoreCase("citemc")){
            return true;
        }
        item = new ItemsSQL((Main.getPlugin(Main.class)));
        if(!(sender instanceof Player)){
            sender.sendMessage("Only players can execute this command");
            return true;
        }
        Player player = (Player) sender;
        String itemName = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
        String argsC = String.join(" ", args);
        item.addCustomName(player, itemName, argsC);
        return true;
    }
}
