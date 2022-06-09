/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ninh
 */
public class PhuThu {
    private String MaPT;
    private String MaKH;
    private String MaHD;
    private String MaSP;
    private int SoLuong;
    private Date NgayBan;
    private double ThanhTien;
    public static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    public PhuThu() {
    }

    public PhuThu(String MaPT) {
        this.MaPT = MaPT;
    }

    public PhuThu(String MaPT, String MaKH, String MaHD, String MaSP, int SoLuong, Date NgayBan, double ThanhTien) {
        this.MaPT = MaPT;
        this.MaKH = MaKH;
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.NgayBan = NgayBan;
        this.ThanhTien = ThanhTien;
    }

    public PhuThu(String MaPT, String MaKH, String MaSP, int SoLuong, Date NgayBan, double ThanhTien) {
        this.MaPT = MaPT;
        this.MaKH = MaKH;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.NgayBan = NgayBan;
        this.ThanhTien = ThanhTien;
    }
    
    
    

    public String getMaPT() {
        return MaPT;
    }

    public void setMaPT(String MaPT) {
        this.MaPT = MaPT;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Date getNgayBan() {
        return NgayBan;
    }

    public PhuThu(String MaPT, String MaKH, String MaSP, int SoLuong, double ThanhTien) {
        this.MaPT = MaPT;
        this.MaKH = MaKH;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
    }

    public void setNgayBan(Date NgayBan) {
        this.NgayBan = NgayBan;
    }

    

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    @Override
    public String toString() {
        return MaPT;
    }
   
}

