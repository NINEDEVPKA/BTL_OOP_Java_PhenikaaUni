/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.model;

/**
 *
 * @author ADMIN
 */
public class NhaCungCap {
    private String MaNCC;
    private String TenNCC;
    private String DiaChi;
    private String SoDT;

    public NhaCungCap(String MaNCC, String TenNCC, String DiaChi, String SoDT) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
        this.SoDT = SoDT;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    @Override
    public String toString() {
        return TenNCC;
    }

    public NhaCungCap() {
    }
    
}
