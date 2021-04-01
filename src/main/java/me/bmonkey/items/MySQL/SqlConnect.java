package me.bmonkey.items.MySQL;

import me.bmonkey.items.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnect {

    public Main plugin;

    public SqlConnect(Main plugin){
        this.plugin = plugin;
    }



    private String host = null; //;
    private String port = "3306"; //plugin.getConfig().getString("sql.port");
    private String database = null; //plugin.getConfig().getString("sql.database_name");
    private String username = null; //plugin.getConfig().getString("sql.username");
    private String password = null; //plugin.getConfig().getString("sql.password");

    private Connection connection;

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if(plugin.getConfig().getString("sql.host") != null){
            host = plugin.getConfig().getString("sql.host");
            port = plugin.getConfig().getString("sql.port");
            database = plugin.getConfig().getString("sql.database_name");
            username = plugin.getConfig().getString("sql.username");
            password = plugin.getConfig().getString("sql.password");
        }
        if (!isConnected()) {
            connection = DriverManager.getConnection("jdbc:mysql://" +
                    host + ":" + port + "/" + database + "?useSSL=false",
                    username, password);
        }
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
