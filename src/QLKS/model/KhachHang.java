/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class KhachHang {
    private String MaKH;
    private String TenKH;
    private Date NgaySinh;
    private int GioiTinh;
    private String SoDT;
    private String CMND;
    private String Email;
    private String DiaChi;

    public KhachHang(String MaKH, String TenKH, Date NgaySinh, int GioiTinh, String SoDT, String CMND, String Email, String DiaChi) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.SoDT = SoDT;
        this.CMND = CMND;
        this.Email = Email;
        this.DiaChi = DiaChi;
    }

    public KhachHang() {
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public String getSoDT() {
        return SoDT;
    }

    public String getCMND() {
        return CMND;
    }

    public String getEmail() {
        return Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    @Override
    public String toString() {
        return SoDT;
    }
    
}
