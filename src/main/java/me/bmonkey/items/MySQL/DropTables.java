package me.bmonkey.items.MySQL;

import me.bmonkey.items.Main;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DropTables {

    private Main plugin;

    public DropTables(Main plugin) {
        this.plugin = plugin;
    }

    public void dropItemsTable() {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("DROP server_items");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropRPTable() {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("DROP rp_versions");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
