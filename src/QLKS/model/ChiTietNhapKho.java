/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.model;

/**
 *
 *@author Tan_Tan_Chin 
 */
public class ChiTietNhapKho {
    private String MaNhapKho;
    private String MaSanPham;
    private int SoLuong;
    private float GiaNhap;

    public ChiTietNhapKho(String MaNhapKho, String MaSanPham, int SoLuong, float GiaNhap) {
        this.MaNhapKho = MaNhapKho;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public ChiTietNhapKho() {
    }

    public String getMaNhapKho() {
        return MaNhapKho;
    }


    public int getSoLuong() {
        return SoLuong;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setMaNhapKho(String MaNhapKho) {
        this.MaNhapKho = MaNhapKho;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }
    
    
    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }
    
}
