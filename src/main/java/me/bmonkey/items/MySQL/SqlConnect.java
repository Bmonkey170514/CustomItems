package me.bmonkey.items.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnect {

    private String host = "104.243.44.106";
    private String port = "3306"; // 3308
    private String database = "s5_plugin_data";
    private String username = "u5_MiL2iL7ERG";
    private String password = "bXmaH7X3GBubpC0ms!r^TNy3";

    private Connection connection;

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
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
