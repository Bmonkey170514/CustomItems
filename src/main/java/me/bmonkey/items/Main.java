package me.bmonkey.items;

import me.bmonkey.items.Commands.AddCustomName;
import me.bmonkey.items.Commands.CreateItem;
import me.bmonkey.items.Events.AddRp;
import me.bmonkey.items.MySQL.CreateTables;
import me.bmonkey.items.MySQL.SqlConnect;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public class Main extends JavaPlugin {

    public SqlConnect SQL;
    public CreateTables data;

    @Override
    public void onEnable() {

        this.SQL = new SqlConnect(this);
        this.data = new CreateTables(this);

        try {
            SQL.connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        if (SQL.isConnected()) {
            Bukkit.getLogger().info("Database is connected!");
            data.createTable();
            data.createRpVer();
        }

        this.getServer().getPluginManager().registerEvents(new AddRp(), this);

        this.getCommand("citem").setExecutor(new CreateItem());
        this.getCommand("citemc").setExecutor(new AddCustomName());
    }

    @Override
    public void onDisable() {
        if(SQL.isConnected()) {
            SQL.disconnect();
        }
        this.saveDefaultConfig();
    }

}
