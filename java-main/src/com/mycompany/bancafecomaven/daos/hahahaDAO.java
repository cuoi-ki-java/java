/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancafecomaven.daos;

import com.mycompany.bancafecomaven.models.hahaha;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author This PC
 */
public class hahahaDAO {
  static   PreparedStatement statement =null;
   static Connection conn=null;
   
   
   static void openConnection(){
      try {
          conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hahaha","root","123456");
      } catch (SQLException ex) {
          Logger.getLogger(hahahaDAO.class.getName()).log(Level.SEVERE, null, ex);
      }

   }
   
   static void closeConnection(){
       
       if(statement !=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(hahahaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(hahahaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
   }
    public static List<hahaha> list(){
        List <hahaha> dataList=new ArrayList<>();
       
        
        
       openConnection();
            try{
            //thuc thi lenh
            String sql="select * from dangnhap";
            statement =conn.prepareStatement(sql);
          ResultSet resultSet = statement.executeQuery();
            
      
            while(resultSet.next()){
                hahaha Hahaha=new hahaha(
                  resultSet.getString("ten"),
                          resultSet.getString("mk"),
                          resultSet.getString("fullname"),
                          resultSet.getString("diachi")
                );
                dataList.add(Hahaha);
            }}catch(SQLException ex){
                Logger.getLogger(hahahaDAO.class.getName()).log(Level.SEVERE, null,ex);
            }
        closeConnection();
        return dataList;
    }
    
    public static void insert(hahaha Hahaha){
        openConnection();
        
        String sql="insert into dangnhap(ten,mk,fullname,diachi)values(?,?,?,?)";
      try {
          statement =conn.prepareStatement(sql);
          statement.setString(1,Hahaha.getTen());
           statement.setString(2,Hahaha.getMatkhau());
            statement.setString(3,Hahaha.getFullname());
            statement.setString(4,Hahaha.getDiachi());
            
            
            statement.execute();
          
      } catch (SQLException ex) {
          Logger.getLogger(hahahaDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
        
        
        closeConnection();
        
        
        
    }
    
    public static void update(hahaha Hahaha){
        
    }
}
