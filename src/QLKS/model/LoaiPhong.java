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
public class LoaiPhong {
    private String LoaiPhong;
    private String MoTaPhong;
    private float GiaPhong;

    public LoaiPhong() {
    }

    public LoaiPhong(String LoaiPhong, String MoTaPhong, float GiaPhong) {
        this.LoaiPhong = LoaiPhong;
        this.MoTaPhong = MoTaPhong;
        this.GiaPhong = GiaPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public String getMoTaPhong() {
        return MoTaPhong;
    }

    public float getGiaPhong() {
        return GiaPhong;
    }

    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public void setMoTaPhong(String MoTaPhong) {
        this.MoTaPhong = MoTaPhong;
    }

    public void setGiaPhong(float GiaPhong) {
        this.GiaPhong = GiaPhong;
    }

    @Override
    public String toString() {
        return LoaiPhong;
    }
    
    
    
}
