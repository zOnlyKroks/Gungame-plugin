package de.zOnlyKroks.Gungame;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class MySQL
{
    private Connection con;
    private String host;
    private int port;
    private String database;
    private String user;
    private String password;
    
    public MySQL(String host, int port, String database, String user, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
        this.connect();
    }
    
    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?autoReconnect=true", this.user, this.password);
            System.out.println("§6MySQL connected!");
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("§6MySQL disconnected!");
        }
    }
    
    public void disconnect() {
        try {
           con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void checkConnection() {
        if (this.con == null) {
            connect();
        }
        try {
            if (!this.con.isValid(2)) {
                connect();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public int get(String id, String value) {
        checkConnection();
        int wert = -1;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT " + value + " FROM Players WHERE UUID = '" + id + "'");
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                wert = rs.getInt(value);
            }
            rs.close();
            preparedStatement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return wert;
    }
    
    public void set(String id, String value,int wert) {
        checkConnection();
        try {
            PreparedStatement pStatement = con.prepareStatement("UPDATE Players SET " + value + " = '" + wert + "' WHERE UUID = '" + id +"'");
            pStatement.executeUpdate();
            pStatement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void checkPlayer(String id) {
        if (get(id, "Kills") == -1) {
            checkConnection();
            try {
                PreparedStatement pStatement = con.prepareStatement("INSERT INTO Players (UUID, Kills, Deaths) VALUES ('" + id + "', '0', '0')");
                pStatement.executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
