package com.mycompany.bancafecomaven;

import com.mycompany.bancafecomaven.daos.hahahaDAO;
import com.mycompany.bancafecomaven.models.hahaha;
import formdangnhap.mahoaa;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;


public class AccountController {
  
    private String secrectKey="ahahahaha";
    String salt = "kakakaka";
    
    
    
  public static Connection getJDBCConnection() {
    String url = "jdbc:mysql://localhost:3306/hahaha";
    String secrectKey = "ahahahaha";
    String salt = "kakakaka";
    
    String user1 = "YS6HiT0VURQAqPHd4jJ2ytWLvzM7LUEMk5FEstLV8Ak=";
    String password1 = "UWKfcdOPJAyivGYv8Csa9W3O6NnGtiuAuVyQyIs3n/w=";
    
    String user = mahoaa.decrypt(user1, secrectKey, salt);
    String password = mahoaa.decrypt(password1, secrectKey, salt);
//String user="root";
//String password="123456";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    } catch(ClassNotFoundException ex){
        Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE,null,ex);
    } catch(SQLException ex){
        Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE,null,ex);
    }
    return null;
}
    public boolean login(String username,String password){
          Connection conn=getJDBCConnection();
        String sql="SELECT*FROM dangnhap WHERE ten=? and mk=?"; 
       try{
            PreparedStatement ps=conn.prepareStatement(sql);

ps.setString(1, username); 
ps.setString(2, password); 
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
       }catch(SQLException ex){
           Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE,null,ex);
       }
        return false;
    }
    
    
    
    
    
    
    public void register(Account account){
       
            
             hahaha hhh=new hahaha(account.getUsername(),account.getPassword(),account.getFullName(),account.getAddress());
                   hahahaDAO.insert(hhh);
//            Connection conn=getJDBCConnection();
//            String sql="INSERT INTO dangnhap(ten,mk,fullname,diachi) VALUES (?,?,?,?)"; 
//           
//            
//            
//            PreparedStatement ps=conn.prepareStatement(sql);
//            
//            
//              ps.setString(1, account.getUsername());
//            ps.setString(2, account.getPassword());
//            ps.setString(3, account.getFullName());
//            ps.setString(4, account.getAddress());
//            
//            int rs = ps.executeUpdate();
//            
//            if(rs!=0){
//                System.out.println("them thanh cong");
//            }else{
//                System.out.println("them that bai");
//            }
      
        
        
    }


    
    public static void main(String[] args) {
    
       // System.out.println("tendangnhap:"+mahoaa.encrypt("root", "ahahahaha", "kakakaka"));
      //  System.out.println("matkhau:"+mahoaa.encrypt("123456", "ahahahaha", "kakakaka"));
        Connection conn=getJDBCConnection();
        if(conn!=null){
            System.out.println("thanh cong"); 
        }else{
            System.out.println("that bai");
        }
    }
    
    
    ///////////////////////////////////////////////////////
    
    
    
}
