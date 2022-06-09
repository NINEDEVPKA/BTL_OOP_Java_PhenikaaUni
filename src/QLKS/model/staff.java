/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.model;

/**
 *
 * @author zzgia
 */
public class staff {
    private String maNV;
    private String maBP;
    private String tenNV;
    private String NgaySinh;
    private int GioiTinh;
    private String sdt;
    private String cmnd;
    private String email;
    private String diachi;
    private String Luong;

    public staff() {
    }

    public staff(String maNV) {
        this.maNV = maNV;
    }
    public staff(String maNV, String maBP, String tenNV, String NgaySinh, int GioiTinh, String sdt, String cmnd, String email, String diachi, String Luong) {
        this.maNV = maNV;
        this.maBP = maBP;
        this.tenNV = tenNV;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.email = email;
        this.diachi = diachi;
        this.Luong = Luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaBP() {
        return maBP;
    }

    public void setMaBP(String maBP) {
        this.maBP = maBP;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
    public String getLuong() {
        return Luong;
    }

    public void setLuong(String Luong) {
        this.Luong = Luong;
    }
    

    @Override
    public String toString() {
        return  tenNV;
    }
    
}
