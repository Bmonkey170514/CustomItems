package me.bmonkey.items.MySQL;

import me.bmonkey.items.Main;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTables {

    private Main plugin;
    public CreateTables(Main plugin) {
        this.plugin = plugin;
    }

    public void createTable(){
        PreparedStatement ps;
        try {
            ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS server_items" +
                    "(ItemName VARCHAR(100),CustomName VARCHAR(100),Material VARCHAR(100),ModelDataNumber INT(100),Lore VARCHAR(100),PRIMARY KEY (ItemName))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createRpVer(){
        PreparedStatement ps;
        try{
            ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS rp_versions" +
                    "(VERSION INT(255),URL VARCHAR(100),PRIMARY KEY (Version))");
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
