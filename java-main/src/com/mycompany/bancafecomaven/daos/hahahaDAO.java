package com.mycompany.bancafecomaven.daos;

import com.mycompany.bancafecomaven.models.hahaha;
import formdangnhap.mahoaa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class hahahaDAO {
    static PreparedStatement statement = null;
    static Connection conn = null;
    static String secrectKey = "ahahahaha";
    static String salt = "kakakaka";
    static String user1 = "YS6HiT0VURQAqPHd4jJ2ytWLvzM7LUEMk5FEstLV8Ak=";
    static String password1 = "UWKfcdOPJAyivGYv8Csa9W3O6NnGtiuAuVyQyIs3n/w=";
    static String user;
    static String password;
    static String url = "jdbc:mysql://localhost:3306/hahaha";

    static {
        user = mahoaa.decrypt(user1, secrectKey, salt);
        password = mahoaa.decrypt(password1, secrectKey, salt);
    }

    static void openConnection() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(hahahaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void closeConnection() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(hahahaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(hahahaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static List<hahaha> list() {
        List<hahaha> dataList = new ArrayList<>();
        openConnection();
        try {
            String sql = "SELECT * FROM dangnhap";
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                hahaha Hahaha = new hahaha(
                        resultSet.getString("ten"),
                        resultSet.getString("mk"),
                        resultSet.getString("fullname"),
                        resultSet.getString("diachi")
                );
                dataList.add(Hahaha);
            }
        } catch (SQLException ex) {
            Logger.getLogger(hahahaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;
    }

    public static void insert(hahaha Hahaha) {
        openConnection();
        String sql = "INSERT INTO dangnhap(ten, mk, fullname, diachi) VALUES (?, ?, ?, ?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, Hahaha.getTen());
            statement.setString(2, Hahaha.getMatkhau());
            statement.setString(3, Hahaha.getFullname());
            statement.setString(4, Hahaha.getDiachi());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(hahahaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    public static void update(hahaha Hahaha) {
        // Implement the update method
    }

    public static void main(String[] args) {
        System.out.println("user sau giải mã: " + user);
    }
}
