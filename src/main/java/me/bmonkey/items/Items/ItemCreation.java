package me.bmonkey.items.Items;

import me.bmonkey.items.Main;
import me.bmonkey.items.MySQL.ItemsSQL;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreation {

    public Main plugin;
    public ItemsSQL tables;

    public ItemCreation(Main plugin) {
        this.plugin = plugin;
    }

    public void addItemToDatabase(Player player, String itemName) {
        tables = new ItemsSQL(Main.getPlugin(Main.class));

        ItemStack newItem = player.getInventory().getItemInMainHand();
        ItemMeta newMeta = newItem.getItemMeta();
        newMeta.setDisplayName(addColor(itemName));
        newMeta.setUnbreakable(true);
        newItem.setItemMeta(newMeta);

        tables.addItem(newItem);
    }



    public static String addColor(String color) {
        return ChatColor.translateAlternateColorCodes('&', color);
    }

}
