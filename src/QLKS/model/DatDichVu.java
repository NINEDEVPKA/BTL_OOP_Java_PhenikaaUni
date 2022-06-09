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
 * @author Tan_Tan_Chin 
 */
public class DatDichVu {
    private String MaHDDV;
    private String MaDV;
    private String MaKH;
    private String MaNV;
    private Timestamp ThoiGianDat;
    private Timestamp ThoiGianBatDauSDDV;
    private int SoLuong;
    private float ThanhTien;
    private String GhiChu;

    public DatDichVu() {
    }
    public DatDichVu(String MaHDDV, String MaDV, String MaKH, String MaNV, Timestamp ThoiGianDat, Timestamp ThoiGianBatDauSDDV, int SoLuong, float ThanhTien, String GhiChu) {
        this.MaHDDV = MaHDDV;
        this.MaDV = MaDV;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.ThoiGianDat = ThoiGianDat;
        this.ThoiGianBatDauSDDV = ThoiGianBatDauSDDV;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.GhiChu = GhiChu;
    }

    public String getMaHDDV() {
        return MaHDDV;
    }

    public String getMaDV() {
        return MaDV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public Timestamp getThoiGianDat() {
        return ThoiGianDat;
    }

    public Timestamp getThoiGianBatDauSDDV() {
        return ThoiGianBatDauSDDV;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setMaHDDV(String MaHDDV) {
        this.MaHDDV = MaHDDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setThoiGianDat(Timestamp ThoiGianDat) {
        this.ThoiGianDat = ThoiGianDat;
    }

    public void setThoiGianBatDauSDDV(Timestamp ThoiGianBatDauSDDV) {
        this.ThoiGianBatDauSDDV = ThoiGianBatDauSDDV;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public void setThoiGianBatDauSDDV(Date time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
