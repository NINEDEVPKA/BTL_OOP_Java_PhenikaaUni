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
public class LoaiSanPham {
    private String MaSP;
    private String TenSP;
    private String MoTaSP;
    private float GiaSP;

    public LoaiSanPham() {
    }

    public LoaiSanPham(String MaSP, String TenSP, String MoTaSP, float GiaSP) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MoTaSP = MoTaSP;
        this.GiaSP = GiaSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public String getMoTaSP() {
        return MoTaSP;
    }

    public float getGiaSP() {
        return GiaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public void setMoTaSP(String MoTaSP) {
        this.MoTaSP = MoTaSP;
    }

    public void setGiaSP(float GiaSP) {
        this.GiaSP = GiaSP;
    }

    @Override
    public String toString() {
        return TenSP;
    }
    
    
}
