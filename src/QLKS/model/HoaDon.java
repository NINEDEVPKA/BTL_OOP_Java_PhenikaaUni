package QLKS.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ninh
 */
public class HoaDon {
    public static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private String MaHD;
    private String MaDatPhong;
    private String MaKH;
    private Date ngayLapHD;
    private double thanhTien    ;
    private int trangThai;
     private int demHD;
     
     private String ID_DatPhong;
    private String MaPhong;
    private String MaNV;
   
    
   
    private Date NgayNhanPhong;
    private Date NgayTraPhong;
   
   
     private float DatCoc;
     private int SoNguoi;
    private Date NgayDatPhong;
    private String TinhTrangPhong;
    private int dem;

    public HoaDon(String MaHD, String MaKH, Date ngayLapHD, double thanhTien, int trangThai) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.ngayLapHD = ngayLapHD;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }
    public HoaDon(String MaHD, String MaKH, double thanhTien, int trangThai) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }
    public HoaDon(String MaHD, String MaKH, String ID_DatPhong, Date ngayLapHD, double thanhTien, int trangThai,int s) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.ngayLapHD = ngayLapHD;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
        this.ID_DatPhong = ID_DatPhong;
    }
    public HoaDon(String MaHD, String MaKH, Date ngayLapHD, int trangThai, String ID_DatPhong, String MaPhong, String MaNV, Date NgayNhanPhong, Date NgayTraPhong, float DatCoc, int SoNguoi, Date NgayDatPhong) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.ngayLapHD = ngayLapHD;
        this.trangThai = trangThai;
        this.ID_DatPhong = ID_DatPhong;
        this.MaPhong = MaPhong;
        this.MaNV = MaNV;
        this.NgayNhanPhong = NgayNhanPhong;
        this.NgayTraPhong = NgayTraPhong;
        this.DatCoc = DatCoc;
        this.SoNguoi = SoNguoi;
        this.NgayDatPhong = NgayDatPhong;
    }

    public HoaDon(String MaHD, Date ngayLapHD, double thanhTien) {
        this.MaHD = MaHD;
        this.ngayLapHD = ngayLapHD;
        this.thanhTien = thanhTien;
        
    }
    

    public HoaDon(String MaHD ,String ID_DatPhong,  String MaPhong, String MaNV, String MaKH, int SoNguoi, float DatCoc, Date NgayDatPhong, Date NgayNhanPhong, double thanhTien, int trangThai) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
        this.ID_DatPhong = ID_DatPhong;
        this.MaPhong = MaPhong;
        this.MaNV = MaNV;
        this.NgayNhanPhong = NgayNhanPhong;
        
        this.DatCoc = DatCoc;
        this.SoNguoi = SoNguoi;
        this.NgayDatPhong = NgayDatPhong;
    }

    public String getID_DatPhong() {
        return ID_DatPhong;
    }

    public void setID_DatPhong(String ID_DatPhong) {
        this.ID_DatPhong = ID_DatPhong;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayNhanPhong() {
        return NgayNhanPhong;
    }

    public void setNgayNhanPhong(Date NgayNhanPhong) {
        this.NgayNhanPhong = NgayNhanPhong;
    }

    public Date getNgayTraPhong() {
        return NgayTraPhong;
    }

    public void setNgayTraPhong(Date NgayTraPhong) {
        this.NgayTraPhong = NgayTraPhong;
    }

    public float getDatCoc() {
        return DatCoc;
    }

    public void setDatCoc(float DatCoc) {
        this.DatCoc = DatCoc;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(int SoNguoi) {
        this.SoNguoi = SoNguoi;
    }

    public Date getNgayDatPhong() {
        return NgayDatPhong;
    }

    public void setNgayDatPhong(Date NgayDatPhong) {
        this.NgayDatPhong = NgayDatPhong;
    }

    public String getTinhTrangPhong() {
        return TinhTrangPhong;
    }

    public void setTinhTrangPhong(String TinhTrangPhong) {
        this.TinhTrangPhong = TinhTrangPhong;
    }

    public int getDem() {
        return dem;
    }

    public void setDem(int dem) {
        this.dem = dem;
    }
    

    public int getDemHD() {
        return demHD;
    }

    public void setDemHD(int demHD) {
        this.demHD = demHD;
    }

    public HoaDon(String MaHD) {
        this.MaHD = MaHD;
    }
     

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaDatPhong, String MaKH, Date ngayLapHD, double thanhTien, int trangThai) {
        this.MaHD = MaHD;
        this.MaDatPhong = MaDatPhong;
        this.MaKH = MaKH;
        this.ngayLapHD = ngayLapHD;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    public HoaDon(String MaHD, String MaDatPhong, String MaKH) {
        this.MaHD = MaHD;
        this.MaDatPhong = MaDatPhong;
        this.MaKH = MaKH;
    }
    

    public static SimpleDateFormat getDf() {
        return df;
    }

    public static void setDf(SimpleDateFormat df) {
        HoaDon.df = df;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaDatPhong() {
        return MaDatPhong;
    }

    public void setMaDatPhong(String MaDatPhong) {
        this.MaDatPhong = MaDatPhong;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public Date getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(Date ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return  MaHD;
    }
    
}
