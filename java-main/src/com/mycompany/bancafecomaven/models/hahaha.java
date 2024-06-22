/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancafecomaven.models;

/**
 *
 * @author This PC
 */
public class hahaha {
    String ten;
    String matkhau;
    String fullname;
    String diachi;

    public hahaha(String ten,String matkhau, String fullname, String diachi) {
        this.ten = ten;
        this.matkhau = matkhau;
        this.fullname = fullname;
        this.diachi = diachi;
    }

    public hahaha() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatkhau() {
        return matkhau;
    }

  

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("hahaha{");
        sb.append("ten=").append(ten);
        sb.append(", matkhau=").append(matkhau);
        sb.append(", fullname=").append(fullname);
        sb.append(", diachi=").append(diachi);
        sb.append('}');
        return sb.toString();
    }
    
    
}
