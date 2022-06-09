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
import QLKS.model.Phong;
import QLKS.model.customer;
import QLKS.model.staff;
import QLKS.UI.DatPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Tan_Tan_Chin 
 */
public class DatPhongDao implements Dao<Datphong> {

    public static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    private static final String TABLE_NAME = "phong";
    private static final String MaPhong_FIELD = "MaPhong";
    private static final String TenPhong_FIELD = "TenPhong";
    private static final String LoaiPhong_FIELD = "LoaiPhong";
    private static final String SoNguoiToiDa_FIELD = "SoNguoiToiDa";
    private static final String TinhTrangPhong_FIELD = "TinhTrangPhong";
    private static final String MoTaPhong_FIELD = "MoTaPhong";
    private static final String GiaPhong_FIELD = "GiaPhong";
    private static final String NgayDatPhong_FIELD = "NgayDatPhong";
    private static final String DatCoc_FIELD = "DatCoc";
    private static final String ID_DatPhong_FIELD = "ID_DatPhong";
    private static final String MaNV_FIELD = "MaNV";
    private static final String MaKH_FIELD = "MaKH";
    private static final String SoNguoi_FIELD = "SoNguoi";

    Connection conn = MyConnection.getInstance().getConnection();

    @Override
    public List<Datphong> getAll() {
        List<Datphong> list = new ArrayList<>();
        try {

            String sql_select = "SELECT d.ID_DatPhong, p.MaPhong,d.MaNV,d.MaKH,p.TenPhong,p.LoaiPhong,l.GiaPhong,d.DatCoc,d.SoNguoi,d.NgayDatPhong,p.TinhTrangPhong FROM  phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong INNER JOIN datphong d ON p.MaPhong = d.MaPhong WHERE p.TinhTrangPhong = 'Đã đặt'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {
                String ID_DatPhong = rs.getString(ID_DatPhong_FIELD);
                String MaPhong = rs.getString(MaPhong_FIELD);

                String MaNV = rs.getString(MaNV_FIELD);
                String MaKH = rs.getString(MaKH_FIELD);
                String TenPhong = rs.getString(TenPhong_FIELD);
                String LoaiPhong = rs.getString(LoaiPhong_FIELD);
                float GiaPhong = rs.getFloat(GiaPhong_FIELD);
                float DatCoc = rs.getFloat(DatCoc_FIELD);
                int SoNguoi = rs.getInt(SoNguoi_FIELD);
                Date time = (Date) rs.getDate(NgayDatPhong_FIELD);
                Timestamp NgayDatPhong = new Timestamp(time.getTime());

                String TinhTrangPhong = rs.getString(TinhTrangPhong_FIELD);
                list.add(new Datphong(ID_DatPhong, MaPhong, MaNV, MaKH, TenPhong, LoaiPhong, GiaPhong, DatCoc, SoNguoi, NgayDatPhong, TinhTrangPhong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Datphong> find(String data, String colName) {
        List listDP=new ArrayList<>();
        try 
        {   
            String query;
            if(colName.equals("ID đặt phòng"))
            {
              query="SELECT d.ID_DatPhong, p.MaPhong,d.MaNV,d.MaKH,p.TenPhong,p.LoaiPhong,l.GiaPhong,d.DatCoc,d.SoNguoi,d.NgayDatPhong,p.TinhTrangPhong FROM  phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong INNER JOIN datphong d ON p.MaPhong = d.MaPhong WHERE p.TinhTrangPhong LIKE '%Đã đặt%' AND d.ID_DatPhong like \"%\"?\"%\" ";
            }else if(colName.equals("Mã phòng"))
            {
              query="SELECT d.ID_DatPhong, p.MaPhong,d.MaNV,d.MaKH,p.TenPhong,p.LoaiPhong,l.GiaPhong,d.DatCoc,d.SoNguoi,d.NgayDatPhong,p.TinhTrangPhong FROM  phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong INNER JOIN datphong d ON p.MaPhong = d.MaPhong WHERE p.TinhTrangPhong LIKE '%Đã đặt%' AND p.MaPhong like \"%\"?\"%\" ";
            }  
            else if(colName.equals("Mã nhân viên"))
            {
              query="SELECT d.ID_DatPhong, p.MaPhong,d.MaNV,d.MaKH,p.TenPhong,p.LoaiPhong,l.GiaPhong,d.DatCoc,d.SoNguoi,d.NgayDatPhong,p.TinhTrangPhong FROM  phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong INNER JOIN datphong d ON p.MaPhong = d.MaPhong WHERE p.TinhTrangPhong LIKE '%Đã đặt%' AND d.MaNV like \"%\"?\"%\" ";
            }
            else if(colName.equals("Mã khách hàng"))
            {
              query="SELECT d.ID_DatPhong, p.MaPhong,d.MaNV,d.MaKH,p.TenPhong,p.LoaiPhong,l.GiaPhong,d.DatCoc,d.SoNguoi,d.NgayDatPhong,p.TinhTrangPhong FROM  phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong INNER JOIN datphong d ON p.MaPhong = d.MaPhong WHERE p.TinhTrangPhong LIKE '%Đã đặt%' AND d.MaKH like \"%\"?\"%\" ";
            }
            else if(colName.equals("Tên phòng"))
            {
              query="SELECT d.ID_DatPhong, p.MaPhong,d.MaNV,d.MaKH,p.TenPhong,p.LoaiPhong,l.GiaPhong,d.DatCoc,d.SoNguoi,d.NgayDatPhong,p.TinhTrangPhong FROM  phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong INNER JOIN datphong d ON p.MaPhong = d.MaPhong WHERE p.TinhTrangPhong LIKE '%Đã đặt%' AND p.TenPhong like \"%\"?\"%\" ";
            }else if (colName.equals("Loại phòng")) {
             query="SELECT d.ID_DatPhong, p.MaPhong,d.MaNV,d.MaKH,p.TenPhong,p.LoaiPhong,l.GiaPhong,d.DatCoc,d.SoNguoi,d.NgayDatPhong,p.TinhTrangPhong FROM  phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong INNER JOIN datphong d ON p.MaPhong = d.MaPhong WHERE p.MaPhong like p.TinhTrangPhong LIKE '%Đã đặt%' AND p.LoaiPhong like \"%\"?\"%\" ";
            }
            else if (colName.equals("Giá phòng")) {
             query="SELECT d.ID_DatPhong, p.MaPhong,d.MaNV,d.MaKH,p.TenPhong,p.LoaiPhong,l.GiaPhong,d.DatCoc,d.SoNguoi,d.NgayDatPhong,p.TinhTrangPhong FROM  phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong INNER JOIN datphong d ON p.MaPhong = d.MaPhong WHERE p.TinhTrangPhong = 'Đã đặt' AND l.GiaPhong <= ? ";
            }
            else {
           query="SELECT d.ID_DatPhong, p.MaPhong,d.MaNV,d.MaKH,p.TenPhong,p.LoaiPhong,l.GiaPhong,d.DatCoc,d.SoNguoi,d.NgayDatPhong,p.TinhTrangPhong FROM  phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong INNER JOIN datphong d ON p.MaPhong = d.MaPhong WHERE p.MaPhong like p.TinhTrangPhong LIKE '%Đã đặt%'";
            }
        
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, data);
             
             ResultSet rs=ps.executeQuery();
             Datphong dp;
             while(rs.next())
             {
                 dp =new Datphong();
                 dp.setID_DatPhong(rs.getString("ID_DatPhong"));
                 dp.setMaPhong(rs.getString("MaPhong"));
                 dp.setMaNV(rs.getString("MaNV"));
                 dp.setMaKH(rs.getString("MaKH"));
                 dp.setTenPhong(rs.getString("TenPhong"));
                 dp.setLoaiPhong(rs.getString("LoaiPhong"));
                 dp.setGiaPhong(rs.getFloat("GiaPhong"));
                 dp.setDatCoc(rs.getFloat("DatCoc"));
                 dp.setSoNguoi(rs.getInt("SoNguoi"));
                 dp.setNgayDatPhong(rs.getDate("NgayDatPhong"));
                 dp.setTinhTrangPhong(rs.getString("TinhTrangPhong"));
                 
                 
                 listDP.add(dp);
             }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listDP;
    }
    

    public List<Phong> getListLoaiPhong() {
        List<Phong> list = new ArrayList<>();
        try {

            String sql_select = "SELECT l.LoaiPhong FROM  loaiphong l ";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                String LoaiPhong = rs.getString(LoaiPhong_FIELD);

                list.add(new Phong(LoaiPhong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<customer> getListMaKH() {
        List<customer> list = new ArrayList<>();
        try {

            String sql_select = "SELECT MaKH FROM  KhachHang";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                String MaKH = rs.getString(MaKH_FIELD);

                list.add(new customer(MaKH));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<staff> getListMaNV() {
        List<staff> list = new ArrayList<>();
        try {

            String sql_select = "SELECT MaNV FROM nhanvien";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                String maNV = rs.getString("maNV");

                list.add(new staff(maNV));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getTenNV(String MaNV) {
        String tenNV = "";
        try {

            String sql_select = "SELECT TenNV FROM nhanvien WHERE MaNV = '" + MaNV + "'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                tenNV = rs.getString("tenNV");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tenNV;
    }
    public String getTenPhong(String MaPhong) {
        String tenPhong = "";
        try {

            String sql_select = "SELECT TenPhong FROM phong WHERE MaPhong = '" + MaPhong + "'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                tenPhong = rs.getString("TenPhong");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tenPhong;
    }

    public int CoutDatPhong() {
        int dem = 0;
        try {

            String sql_select = "SELECT COUNT(*)  AS dem FROM datphong d";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                dem = rs.getInt("dem");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dem;
    }

    public String getTenKH(String MaKH) {
        String tenKH = "";
        try {

            String sql_select = "SELECT TenKH FROM KhachHang WHERE MaKH = '" + MaKH + "'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                tenKH = rs.getString("tenKH");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tenKH;
    }

    public Date getNgaySinh(String MaKH) {
        Date ngaySinh = null;
        try {

            String sql_select = "SELECT NgaySinh FROM KhachHang WHERE MaKH = '" + MaKH + "'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                ngaySinh = rs.getDate("NgaySinh");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ngaySinh;
    }
    
    @Override
    public Optional<Datphong> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Datphong> get(String IDDatPhong) {
        Datphong datphong = new Datphong();
        try {
            String sql_select_by_id = "SELECT d.ID_DatPhong,d.MaPhong,p.TenPhong,d.MaNV,d.MaKH,d.NgayDatPhong,d.SoNguoi,d.DatCoc FROM datphong d INNER JOIN phong p ON d.MaPhong = p.MaPhong WHERE " + ID_DatPhong_FIELD + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setString(1, IDDatPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datphong.setID_DatPhong(rs.getString(ID_DatPhong_FIELD));
                datphong.setMaPhong(rs.getString(MaPhong_FIELD));
                datphong.setTenPhong(rs.getString(TenPhong_FIELD));
                datphong.setMaNV(rs.getString(MaNV_FIELD));

                datphong.setMaKH(rs.getString(MaKH_FIELD));
                datphong.setNgayDatPhong(rs.getTimestamp(NgayDatPhong_FIELD));
                datphong.setSoNguoi(rs.getInt(SoNguoi_FIELD));
                datphong.setDatCoc(rs.getInt(DatCoc_FIELD));
            }
        } catch (Exception e) {
        }
        return Optional.of(datphong);
    }

    public int updateTrangThai(String maPhong) {
        try {
            String sql_update = "UPDATE phong p SET p.TinhTrangPhong = 'Đã đặt' WHERE p.MaPhong = '" + maPhong + "'";
            PreparedStatement ps = conn.prepareStatement(sql_update);
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

    public int updateTrangThaiTrong(String maPhong) {
        try {
            String sql_update = "UPDATE phong p SET p.TinhTrangPhong = 'Trống' WHERE p.MaPhong = '" + maPhong + "'";
            PreparedStatement ps = conn.prepareStatement(sql_update);
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

    public int updateTrangThaiDangThue(String maPhong) {
        try {
            String sql_update = "UPDATE phong p SET p.TinhTrangPhong = 'Đang thuê' WHERE p.MaPhong = '" + maPhong + "'";
            PreparedStatement ps = conn.prepareStatement(sql_update);
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

    @Override
    public int insert(Datphong t) {
        try {
            String sql_insert = "INSERT INTO datphong values( ?, ?, ?, ?, ?,?,?,Null,Null)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getID_DatPhong());
            ps.setString(2, t.getMaPhong());
            ps.setString(3, t.getMaNV());
            ps.setString(4, t.getMaKH());
            ps.setTimestamp(5, (Timestamp) t.getNgayDatPhong());
            ps.setInt(6, t.getSoNguoi());
            ps.setFloat(7, t.getDatCoc());
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
    
    
    public int insertHoaDon(HoaDon t) {
        try {
            String sql_insert = "INSERT INTO hoadon values(?, ?,?,null,0,0)";
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
    
    public int CoutHoaDon() {
        int demHD = 0;
        try {

            String sql_select = "SELECT COUNT(*)  AS demHD FROM hoadon d";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                demHD = rs.getInt("demHD");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return demHD;
    }
    
    public List<HoaDon> getListMaHD() {
       List<HoaDon> list = new ArrayList<>();
        try {
            
            String sql_select = "SELECT MaHD FROM hoadon";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {
                String MaHD = rs.getString("MaHD");
                list.add(new HoaDon(MaHD));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int update(Datphong t) {
        try {
            String sql_update = "UPDATE datphong SET " + MaPhong_FIELD + " = ?, " + MaNV_FIELD + " = ?, " + MaKH_FIELD + " = ?, " + NgayDatPhong_FIELD + " = ?, " + SoNguoi_FIELD + " = ?, " + DatCoc_FIELD + " = ? " + " WHERE " + ID_DatPhong_FIELD + " = ?";

            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setString(1, t.getMaPhong());
            ps.setString(2, t.getMaNV());
            ps.setString(3, t.getMaKH());
            ps.setTimestamp(4, (Timestamp) t.getNgayDatPhong());
            ps.setInt(5, t.getSoNguoi());
            ps.setFloat(6, t.getDatCoc());
            ps.setString(7, t.getID_DatPhong());
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

    @Override
    public int delete(Datphong t) {
        try {
            String sql_delete = "DELETE FROM datphong WHERE " + ID_DatPhong_FIELD + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, t.getID_DatPhong());
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

    @Override
    public int delete(String IDDatPhong) {
        try {
            String sql_delete = "DELETE FROM datphong WHERE " + ID_DatPhong_FIELD + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, IDDatPhong);
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

    @Override
    public List<Datphong> find(Datphong t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Phong> getAllPhong() {
        List<Phong> list = new ArrayList<>();
        try {

            String sql_select = "SELECT p.MaPhong,p.TenPhong,p.LoaiPhong,l.MoTaPhong,p.SoNguoiToiDa,l.GiaPhong,p.TinhTrangPhong FROM  " + TABLE_NAME + " p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong WHERE p.TinhTrangPhong = 'Trống'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {
                String MaPhong = rs.getString(MaPhong_FIELD);
                String TenPhong = rs.getString(TenPhong_FIELD);
                String LoaiPhong = rs.getString(LoaiPhong_FIELD);
                String MoTaPhong = rs.getString(MoTaPhong_FIELD);
                int SoNguoiToiDa = rs.getInt(SoNguoiToiDa_FIELD);
                float GiaPhong = rs.getFloat(GiaPhong_FIELD);
                String TinhTrangPhong = rs.getString(TinhTrangPhong_FIELD);
                list.add(new Phong(MaPhong, TenPhong, LoaiPhong, MoTaPhong, SoNguoiToiDa, GiaPhong, TinhTrangPhong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        DatPhongDao d = new DatPhongDao();
        int a = d.CoutDatPhong();
        System.out.println(a);
    }

    @Override
    public List<Datphong> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Datphong> getList() {
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
