
package QLKS.model;

import java.util.Date;

/**
 *
 * @author Tan_Tan_Chin 
 */
public class Datphong {

    private String ID_DatPhong;
    private String MaPhong;
    private String MaNV;
    private String MaKH;
    
   
    private Date NgayNhanPhong;
    private Date NgayTraPhong;
    private String TenPhong;
    private String LoaiPhong;
    private float GiaPhong;
     private float DatCoc;
     private int SoNguoi;
    private Date NgayDatPhong;
    private String TinhTrangPhong;
    private int dem;

    public int getDem() {
        return dem;
    }


    public void setDem(int dem) {
        this.dem = dem;
    }

    public Datphong() {
    }

    public Datphong(String ID_DatPhong) {
        this.ID_DatPhong = ID_DatPhong;
    }

    
    public Datphong(String ID_DatPhong, String MaPhong, String MaNV, String MaKH, float DatCoc, int SoNguoi, Date NgayDatPhong) {
        this.ID_DatPhong = ID_DatPhong;
        this.MaPhong = MaPhong;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.DatCoc = DatCoc;
        this.SoNguoi = SoNguoi;
        this.NgayDatPhong = NgayDatPhong;
    }
    public Datphong(String ID_DatPhong, String MaPhong, String MaNV, String MaKH, float DatCoc, int SoNguoi, Date NgayDatPhong, Date NgayNhanPhong) {
        this.ID_DatPhong = ID_DatPhong;
        this.MaPhong = MaPhong;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.DatCoc = DatCoc;
        this.SoNguoi = SoNguoi;
        this.NgayDatPhong = NgayDatPhong;
        this.NgayNhanPhong = NgayNhanPhong;
    }
    
    
    public Datphong(String ID_DatPhong, String MaPhong, String MaNV, String MaKH, String TenPhong, String LoaiPhong, float GiaPhong, float DatCoc, int SoNguoi, Date NgayDatPhong, String TinhTrangPhong) {
        this.ID_DatPhong = ID_DatPhong;
        this.MaPhong = MaPhong;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.TenPhong = TenPhong;
        this.LoaiPhong = LoaiPhong;
        this.GiaPhong = GiaPhong;
        this.DatCoc = DatCoc;
        this.SoNguoi = SoNguoi;
        this.NgayDatPhong = NgayDatPhong;
        this.TinhTrangPhong = TinhTrangPhong;
    }
    

    public Datphong(String ID_DatPhong, String MaPhong, String MaNV, String MaKH, String TenPhong, String LoaiPhong, float GiaPhong, float DatCoc, int SoNguoi, Date NgayDatPhong, String TinhTrangPhong, Date NgayNhanPhong) {
        this.ID_DatPhong = ID_DatPhong;
        this.MaPhong = MaPhong;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.NgayNhanPhong = NgayNhanPhong;
        this.TenPhong = TenPhong;
        this.LoaiPhong = LoaiPhong;
        this.GiaPhong = GiaPhong;
        this.DatCoc = DatCoc;
        this.SoNguoi = SoNguoi;
        this.NgayDatPhong = NgayDatPhong;
        this.TinhTrangPhong = TinhTrangPhong;
    }

    public Datphong(String ID_DatPhong, Date NgayTraPhong, int SoNguoi) {
        this.ID_DatPhong = ID_DatPhong;
        this.NgayTraPhong = NgayTraPhong;
        this.SoNguoi = SoNguoi;
    }
    
    

    public Datphong(String ID_DatPhong, Date NgayNhanPhong) {
        this.ID_DatPhong = ID_DatPhong;
        this.NgayNhanPhong = NgayNhanPhong;
    }
    

    
    public Datphong(String idDatPhong, String maphong, String MaNV, String MaKH, Date ngaydat, int song, float datcoc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public float getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(float GiaPhong) {
        this.GiaPhong = GiaPhong;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(int SoNguoi) {
        this.SoNguoi = SoNguoi;
    }

    public String getTinhTrangPhong() {
        return TinhTrangPhong;
    }

    public void setTinhTrangPhong(String TinhTrangPhong) {
        this.TinhTrangPhong = TinhTrangPhong;
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

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public Date getNgayDatPhong() {
        return NgayDatPhong;
    }

    public void setNgayDatPhong(Date NgayDatPhong) {
        this.NgayDatPhong = NgayDatPhong;
    }

    public float getDatCoc() {
        return DatCoc;
    }

    public void setDatCoc(float DatCoc) {
        this.DatCoc = DatCoc;
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

    @Override
    public String toString() {
        return ID_DatPhong;
    }
    
    
}
