/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pacevil
 */
public class Koneksi {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conn;
    private Statement st;

    public Koneksi() {
    }

    public Connection konekDB() throws SQLException {
        try {
            String host = "localhost";
            String username = "root";
            String password = "";
            String database = "sim";
            String port = "3306";

            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
            ps = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            ps.executeUpdate();

            System.out.println("Connection Okey");

            return connection;
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
