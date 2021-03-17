package me.bmonkey.items.MySQL;

import me.bmonkey.items.Main;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemsSQL {

    public Main plugin;

    public ItemsSQL(Main plugin) {
        this.plugin = plugin;
    }

    public void addItem(ItemStack item) {
        try {
            String name = item.getItemMeta().getDisplayName();
            int modelData = item.getItemMeta().getCustomModelData();
            String material = item.getType().toString();
            PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement("INSERT IGNORE INTO server_items SET ItemName = '" +
                    name + "', ModelDataNumber = '" + modelData + "', Material = '" + material + "'");
            ps2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCustomName(Player player, String itemName, String customName) {
        try {
            if(exists(itemName)) {
                PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE server_items SET CustomName = '" + customName +
                        "' WHERE ItemName = '" + itemName + "'");
                ps.executeUpdate();
                return;
            }
            player.sendMessage("Item not created yet! Do /citem to create one!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean exists(String itemName) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM server_items WHERE ItemName = '" + itemName + "'");

            ResultSet results = ps.executeQuery();
            if (results.next()) {
                // item is found
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getCustomName(String name) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT CustomName FROM server_items WHERE ItemName = '" +
                    name + "'");
            ResultSet rs = ps.executeQuery();
            String custom;
            if (rs.next()) {
                custom = rs.getString("CustomName");
                return custom;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "NULL";
    }

    public String getItemName(String name) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT CustomName FROM server_items WHERE ItemName = '" +
                    name + "'");
            ResultSet rs = ps.executeQuery();
            String custom;
            if (rs.next()) {
                custom = rs.getString("CustomName");
                return custom;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "NULL";
    }

}
