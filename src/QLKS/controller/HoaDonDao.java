/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.controller;

import QLKS.connect.MyConnection;
import QLKS.dao.Dao;
import QLKS.model.Datphong;
import QLKS.model.HoaDon;
import QLKS.model.PhuThu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Tan_Tan_Chin 
 */
public class HoaDonDao implements Dao<HoaDon> {

    private static final String TABLE_NAME = "phong";
    private static final String MaPhong_FIELD = "MaPhong";
    private static final String TenPhong_FIELD = "TenPhong";
    private static final String LoaiPhong_FIELD = "LoaiPhong";
    private static final String SoNguoiToiDa_FIELD = "SoNguoiToiDa";
    private static final String TinhTrangPhong_FIELD = "TinhTrangPhong";
    private static final String MoTaPhong_FIELD = "MoTaPhong";
    private static final String GiaPhong_FIELD = "GiaPhong";
    private static final String NgayDatPhong_FIELD = "NgayDatPhong";
    private static final String NgayNhanPhong_FIELD = "NgayNhanPhong";
    private static final String NgayTraPhong_FIELD = "NgayTraPhong";
    private static final String DatCoc_FIELD = "DatCoc";
    private static final String ID_DatPhong_FIELD = "ID_DatPhong";
    private static final String MaHD_FIELD = "MaHD";
    private static final String NgayLapHD_FIELD = "NgayLapHD";
    private static final String ThanhTien_FIELD = "ThanhTien";
    private static final String MaNV_FIELD = "MaNV";
    private static final String MaKH_FIELD = "MaKH";
    private static final String SoNguoi_FIELD = "SoNguoi";
    private static final String TrangThai_FIELD = "TrangThai";

    private static final String MAPT = "maphuthu";
    private static final String MAKH = "makh";
    private static final String MAHD = "mahd";
    private static final String MASP = "masp";
    private static final String SL = "soluongphuthu";
    private static final String NGAYBAN = "ngayban";
    private static final String THANHTIEN = "thanhtien";

    Connection conn = MyConnection.getInstance().getConnection();

    @Override
    public List<HoaDon> getAll() {
        List<HoaDon> list = new ArrayList<>();
        try {

            String sql_select = "SELECT h.MaHD,d.ID_DatPhong,d.MaPhong,d.MaNV,d.MaKH,d.SoNguoi,d.DatCoc,d.NgayDatPhong,d.NgayNhanPhong,h.ThanhTien,h.TrangThai FROM hoadon h INNER JOIN datphong d ON h.ID_DatPhong = d.ID_DatPhong";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {
                String MaHD = rs.getString(MaHD_FIELD);
                String IdDatPhong = rs.getString(ID_DatPhong_FIELD);
                String MaPhong = rs.getString(MaPhong_FIELD);

                String MaNV = rs.getString(MaNV_FIELD);
                String MaKH = rs.getString(MaKH_FIELD);
                int SoNguoi = rs.getInt(SoNguoi_FIELD);
                float DatCoc = rs.getFloat(DatCoc_FIELD);
                Date time = (Date) rs.getDate(NgayDatPhong_FIELD);
                Timestamp NgayDatPhong = new Timestamp(time.getTime());
                Date time1 = (Date) rs.getDate(NgayNhanPhong_FIELD);
                Timestamp NgayNhanPhong = new Timestamp(time1.getTime());

                double ThanhTien = rs.getDouble(ThanhTien_FIELD);

                int TrangThai = rs.getInt(TrangThai_FIELD);
                list.add(new HoaDon(MaHD, IdDatPhong, MaPhong, MaNV, MaKH, SoNguoi, DatCoc, NgayDatPhong, NgayNhanPhong, ThanhTien, TrangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public float getPhiPhong(String MaPhong) {
        float PhiPhong = 0;
        try {

            String sql_select = "SELECT l.GiaPhong FROM phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong WHERE MaPhong = '" + MaPhong + "'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                PhiPhong = rs.getFloat("GiaPhong");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return PhiPhong;
    }

    public int getTrangThai(String MaHD) {
        int trangthai = 0;
        try {

            String sql_select = "SELECT h.TrangThai FROM  hoadon h WHERE h.MaHD = '" + MaHD + "'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                trangthai = rs.getInt("TrangThai");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return trangthai;
    }

    public Date getNgayTraPhong(String MaID) {
        Date ngayNhanPhong = null;
        try {

            String sql_select = "SELECT NgayTraPhong FROM datphong WHERE ID_DatPhong = '" + MaID + "'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                ngayNhanPhong = rs.getDate("NgayTraPhong");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ngayNhanPhong;
    }

    public int updateHoaDon(HoaDon t) {
        try {
            String sql_update = "UPDATE hoadon d SET  " + NgayLapHD_FIELD + " = ?, " + ThanhTien_FIELD + " = ? ,TrangThai = 1 WHERE " + MaHD_FIELD + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setTimestamp(1, (Timestamp) t.getNgayLapHD());
            ps.setDouble(2, t.getThanhTien());
            ps.setString(3, t.getMaHD());

            int k = ps.executeUpdate();
            if (k > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateNgayTraPhong(Datphong t) {
        try {
            String sql_update = "UPDATE datphong d SET  " + NgayTraPhong_FIELD + " = ? " + " WHERE " + ID_DatPhong_FIELD + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setTimestamp(1, (Timestamp) t.getNgayTraPhong());
            ps.setString(2, t.getID_DatPhong());
            int k = ps.executeUpdate();
            if (k > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public float getPhiPhuThu(String MaHD) {
        float PhiPhuThu = 0;
        try {

            String sql_select = "SELECT SUM(p.ThanhTien) AS PHI FROM phuthu p  WHERE p.MaHD  = '" + MaHD + "'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                PhiPhuThu = rs.getFloat("PHI");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return PhiPhuThu;
    }

    public List<PhuThu> getPhuThuTheoMaHD(String MaHD) {
        List<PhuThu> list = new ArrayList<>();
        try {

            String sql_select = "SELECT p.MaPhuThu,p.MaKH,p.MaSP,p.SoLuongPhuthu,p.NgayBan,p.ThanhTien FROM phuthu p WHERE " + MaHD_FIELD + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ps.setString(1, MaHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaPhuThu = rs.getString(MAPT);
                String MaKH = rs.getString(MaKH_FIELD);
                String MaSP = rs.getString(MASP);
                Date ngayBan = rs.getDate(NGAYBAN);
                int soLuong = rs.getInt(SL);
                double ThanhTien = rs.getDouble(THANHTIEN);

                list.add(new PhuThu(MaPhuThu, MaKH, MaSP, soLuong, ngayBan, ThanhTien));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Optional<HoaDon> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<HoaDon> get(String MaHd) {
        HoaDon hoadon = new HoaDon();
        try {
            String sql_select_by_id = "SELECT h.MaHD,d.ID_DatPhong,d.MaPhong,d.MaNV,d.MaKH,d.SoNguoi,d.DatCoc,d.NgayDatPhong,d.NgayNhanPhong,h.ThanhTien,h.TrangThai FROM hoadon h INNER JOIN datphong d ON h.ID_DatPhong = d.ID_DatPhong WHERE " + MaHD_FIELD + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setString(1, MaHd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hoadon.setMaHD(rs.getString(MaHD_FIELD));
                hoadon.setID_DatPhong(rs.getString(ID_DatPhong_FIELD));
                hoadon.setMaPhong(rs.getString(MaPhong_FIELD));
                hoadon.setMaNV(rs.getString(MaNV_FIELD));
                hoadon.setMaKH(rs.getString(MaKH_FIELD));
                hoadon.setNgayDatPhong(rs.getTimestamp(NgayDatPhong_FIELD));
                hoadon.setNgayNhanPhong(rs.getTimestamp(NgayNhanPhong_FIELD));

                hoadon.setSoNguoi(rs.getInt(SoNguoi_FIELD));
                hoadon.setDatCoc(rs.getInt(DatCoc_FIELD));
                hoadon.setThanhTien(rs.getFloat(ThanhTien_FIELD));
                hoadon.setTrangThai(rs.getInt(TrangThai_FIELD));
            }
        } catch (Exception e) {
        }
        return Optional.of(hoadon);
    }

    @Override
    public int insert(HoaDon t) {
        try {
            String sql_insert = "INSERT INTO hoadon values(?, ?,?,null,'0','0')";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getMaHD());
            ps.setString(2, t.getMaDatPhong());
            ps.setString(3, t.getMaKH());
            int k = ps.executeUpdate();
            if (k > 0) {
                ResultSet rsKey = ps.getGeneratedKeys();
                if (rsKey.next()) {
                    return rsKey.getInt(1);
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<HoaDon> find(String data, String colName) {
        List listHD = new ArrayList<>();
        try {
            String query;
            if (colName.equals("Mã hóa đơn")) {
                query = "SELECT h.MaHD,d.ID_DatPhong,d.MaPhong,d.MaNV,d.MaKH,d.SoNguoi,d.DatCoc,d.NgayDatPhong,d.NgayNhanPhong,h.ThanhTien,h.TrangThai FROM hoadon h INNER JOIN datphong d ON h.ID_DatPhong = d.ID_DatPhong WHERE h.MaHD like \"%\"?\"%\" ";
            } else if (colName.equals("ID đặt phòng")) {
                query = "SELECT h.MaHD,d.ID_DatPhong,d.MaPhong,d.MaNV,d.MaKH,d.SoNguoi,d.DatCoc,d.NgayDatPhong,d.NgayNhanPhong,h.ThanhTien,h.TrangThai FROM hoadon h INNER JOIN datphong d ON h.ID_DatPhong = d.ID_DatPhong WHERE d.ID_DatPhong like \"%\"?\"%\" ";
            } else if (colName.equals("Mã phòng")) {
                query = "SELECT h.MaHD,d.ID_DatPhong,d.MaPhong,d.MaNV,d.MaKH,d.SoNguoi,d.DatCoc,d.NgayDatPhong,d.NgayNhanPhong,h.ThanhTien,h.TrangThai FROM hoadon h INNER JOIN datphong d ON h.ID_DatPhong = d.ID_DatPhong WHERE d.MaPhong like \"%\"?\"%\" ";
            } else if (colName.equals("Mã nhân viên")) {
                 query="SELECT h.MaHD,d.ID_DatPhong,d.MaPhong,d.MaNV,d.MaKH,d.SoNguoi,d.DatCoc,d.NgayDatPhong,d.NgayNhanPhong,h.ThanhTien,h.TrangThai FROM hoadon h INNER JOIN datphong d ON h.ID_DatPhong = d.ID_DatPhong WHERE d.MaNV like \"%\"?\"%\" ";
            } else if (colName.equals("Mã khách hàng")) {
                query = "SELECT h.MaHD,d.ID_DatPhong,d.MaPhong,d.MaNV,d.MaKH,d.SoNguoi,d.DatCoc,d.NgayDatPhong,d.NgayNhanPhong,h.ThanhTien,h.TrangThai FROM hoadon h INNER JOIN datphong d ON h.ID_DatPhong = d.ID_DatPhong WHERE d.MaKH like \"%\"?\"%\" ";
            } else if (colName.equals("Đặt cọc")) {
                query = "SELECT h.MaHD,d.ID_DatPhong,d.MaPhong,d.MaNV,d.MaKH,d.SoNguoi,d.DatCoc,d.NgayDatPhong,d.NgayNhanPhong,h.ThanhTien,h.TrangThai FROM hoadon h INNER JOIN datphong d ON h.ID_DatPhong = d.ID_DatPhong WHERE d.DatCoc <= ?";
            } else {
                query = "SELECT h.MaHD,d.ID_DatPhong,d.MaPhong,d.MaNV,d.MaKH,d.SoNguoi,d.DatCoc,d.NgayDatPhong,d.NgayNhanPhong,h.ThanhTien,h.TrangThai FROM hoadon h INNER JOIN datphong d ON h.ID_DatPhong = d.ID_DatPhong";
            }
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            HoaDon hd;
            while (rs.next()) {
                hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setID_DatPhong(rs.getString("ID_DatPhong"));
                 hd.setMaPhong(rs.getString("MaPhong"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setSoNguoi(rs.getInt("SoNguoi"));
                hd.setDatCoc(rs.getFloat("DatCoc"));
                hd.setNgayDatPhong(rs.getDate("NgayDatPhong"));
                hd.setNgayNhanPhong(rs.getDate("NgayNhanPhong"));
                hd.setThanhTien(rs.getDouble("ThanhTien"));
                hd.setTrangThai(rs.getInt("TrangThai"));

                listHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    @Override
    public int update(HoaDon t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(HoaDon t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String MaPhong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDon> find(HoaDon t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        HoaDonDao h = new HoaDonDao();

        h.getTrangThai("hd001");
    }

    @Override
    public List<HoaDon> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDon> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String t, String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findT(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getData(String dataIn, String colIn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
