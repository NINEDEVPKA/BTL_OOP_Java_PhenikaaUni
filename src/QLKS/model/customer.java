package QLKS.model;

/**
 *
 * @author Ninh
 */
public class customer {
    private String maKH;
    private String tenKH;
    private String NgaySinh;
    private int GioiTinh;
    private String sdt;
    private String cmnd;
    private String email;
    private String diachi;

    public customer() {
    }

    public customer(String maKH,  String tenKH, String NgaySinh, int GioiTinh, String sdt, String cmnd, String email, String diachi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.email = email;
        this.diachi = diachi;
    }

    public customer(String maKH) {
        this.maKH = maKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
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

    

    

    @Override
    public String toString() {
        return  maKH ;
    }
    
}
