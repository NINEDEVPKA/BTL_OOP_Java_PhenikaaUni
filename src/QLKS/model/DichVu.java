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
public class DichVu {
    private String MaDV;
    private String TenDV;
    private String MoTaDichVu;
    private float PhiDV;

    public DichVu(String MaDV, String TenDV, String MoTaDichVu, float PhiDV) {
        this.MaDV = MaDV;
        this.TenDV = TenDV;
        this.MoTaDichVu = MoTaDichVu;
        this.PhiDV = PhiDV;
    }

    public DichVu() {
    }

    public String getMaDV() {
        return MaDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public String getMoTaDichVu() {
        return MoTaDichVu;
    }

    public float getPhiDV() {
        return PhiDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public void setMoTaDichVu(String MoTaDichVu) {
        this.MoTaDichVu = MoTaDichVu;
    }

    public void setPhiDV(float PhiDV) {
        this.PhiDV = PhiDV;
    }

    @Override
    public String toString() {
        return TenDV;
    }
    
}
