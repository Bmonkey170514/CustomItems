package me.bmonkey.items.MySQL;

import me.bmonkey.items.Main;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClearTables {

    private Main plugin;

    public ClearTables(Main plugin) {
        this.plugin = plugin;
    }

    public void emptyItemsTable() {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("TRUNCATE server_items");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void emptyRPTable() {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("TRUNCATE rp_versions");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
