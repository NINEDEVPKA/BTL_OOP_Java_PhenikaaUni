/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.model;

import java.sql.Date;
import java.sql.Timestamp;


/**
 *
 * @author ADMIN
 */
public class NhapKho {
    private  String MaNhapKho;
    private  String MaNCC;
    private  String MaNV;
    private  Timestamp NgayNhap;
    private  int ChietKhau;
    private  float ThanhTien;

    public NhapKho() {
    }

    public NhapKho(String MaNhapKho, String MaNCC, String MaNV, Timestamp NgayNhap, int ChietKhau, float ThanhTien) {
        this.MaNhapKho = MaNhapKho;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.NgayNhap = NgayNhap;
        this.ChietKhau = ChietKhau;
        this.ThanhTien = ThanhTien;
    }

    

   

    public String getMaNCC() {
        return MaNCC;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getMaNhapKho() {
        return MaNhapKho;
    }

   

    public Timestamp getNgayNhap() {
        return NgayNhap;
    }

    public int getChietKhau() {
        return ChietKhau;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setMaNhapKho(String MaNhapKho) {
        this.MaNhapKho = MaNhapKho;
    }

   

    public void setNgayNhap(Timestamp NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public void setChietKhau(int ChietKhau) {
        this.ChietKhau = ChietKhau;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
    
    @Override
    public String toString() {
        return MaNhapKho;
    }
    
    
}
