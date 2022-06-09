/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLKS.controller;

/**
 *
 * @author @author Tan_Tan_Chin 
 */
public class CheckLogin { 
    private String TaiKhoan;
    private String MatKhau;

    public CheckLogin() {
    }
    
    public CheckLogin(String TaiKhoan, String MatKhau) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
    }
    
    public String getTaiKhoan(){
        return TaiKhoan;
    }
    
    public void setTaiKhoan(String TaiKhoan){
        this.TaiKhoan = TaiKhoan;
    }
    
    
     public String getMatKhau(){
        return MatKhau;
    }
    
    public void setMatKhau(String MatKhau){
        this.MatKhau = MatKhau;
    }
   
    @Override
    public String toString() {
        return "taikhoan" + TaiKhoan + "matkhau" + MatKhau;
    }
    
}
