package QLKS.model;
/**
 *
 * @author Ninh
 */
public class Phong {
   private String MaPhong;
   private String TenPhong;
   private String LoaiPhong;
   private String MoTaPhong;
   private int SoNguoiToiDa;
   private float GiaPhong;

    public String getMoTaPhong() {
        return MoTaPhong;
    }

    public void setMoTaPhong(String MoTaPhong) {
        this.MoTaPhong = MoTaPhong;
    }

    public float getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(float GiaPhong) {
        this.GiaPhong = GiaPhong;
    }

    public Phong(String MaPhong, String TenPhong, String LoaiPhong, String MoTaPhong, int SoNguoiToiDa, float GiaPhong, String TinhTrangPhong) {
        this.MaPhong = MaPhong;
        this.TenPhong = TenPhong;
        this.LoaiPhong = LoaiPhong;
        this.MoTaPhong = MoTaPhong;
        this.SoNguoiToiDa = SoNguoiToiDa;
        this.GiaPhong = GiaPhong;
        this.TinhTrangPhong = TinhTrangPhong;
    }
   private String TinhTrangPhong;
   
   

    public Phong() {
    }

    public Phong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public Phong(String MaPhong, String TenPhong, String LoaiPhong, int SoNguoiToiDa, String TinhTrangPhong) {
        this.MaPhong = MaPhong;
        this.TenPhong = TenPhong;
        this.LoaiPhong = LoaiPhong;
        this.SoNguoiToiDa = SoNguoiToiDa;
        this.TinhTrangPhong = TinhTrangPhong;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
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

    public int getSoNguoiToiDa() {
        return SoNguoiToiDa;
    }

    public void setSoNguoiToiDa(int SoNguoiToiDa) {
        this.SoNguoiToiDa = SoNguoiToiDa;
    }

    public String getTinhTrangPhong() {
        return TinhTrangPhong;
    }

    public void setTinhTrangPhong(String TinhTrangPhong) {
        this.TinhTrangPhong = TinhTrangPhong;
    }

    @Override
    public String toString() {
        return MaPhong ;
    }

    
   
}
