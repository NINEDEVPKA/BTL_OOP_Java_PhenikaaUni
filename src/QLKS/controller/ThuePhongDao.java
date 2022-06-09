/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.controller;

import QLKS.connect.MyConnection;
import QLKS.dao.Dao;
import QLKS.model.Datphong;
import QLKS.model.Phong;
import QLKS.model.customer;
import QLKS.model.staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class ThuePhongDao implements Dao<Datphong> {
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
    private static final String NgayNhanPhong_FIELD = "NgayNhanPhong";
    private static final String DatCoc_FIELD = "DatCoc";
    private static final String ID_DatPhong_FIELD = "ID_DatPhong";
    private static final String MaNV_FIELD = "MaNV";
    private static final String MaKH_FIELD = "MaKH";
    private static final String SoNguoi_FIELD = "SoNguoi";
    
    
    Connection conn = MyConnection.getInstance().getConnection();
    
     public List<Phong> getListLoaiPhong() {
       List<Phong> list = new ArrayList<>();
        try {
            
            String sql_select = "SELECT l.LoaiPhong FROM  loaiphong l ";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {
         
                String LoaiPhong = rs.getString(LoaiPhong_FIELD);

                list.add(new Phong( LoaiPhong));
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

                list.add(new customer( MaKH));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     
     public List<Datphong> getListIDDatPhong() {
       List<Datphong> list = new ArrayList<>();
        try {
            
            String sql_select = "SELECT ID_DatPhong FROM datphong";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {
                String IDDatPhong = rs.getString("ID_DatPhong");
                list.add(new Datphong(IDDatPhong));
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
     
     public String getTenNV (String MaNV){
     String tenNV = "";
     try {
            
            String sql_select = "SELECT TenNV FROM nhanvien WHERE MaNV = '"+MaNV+"'";
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
     public String getTenKH (String MaKH){
     String tenKH = "";
     try {
            
            String sql_select = "SELECT TenKH FROM KhachHang WHERE MaKH = '"+MaKH+"'";
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
     public Date getNgaySinh (String MaKH){
     Date ngaySinh = null ;
     try {
            
            String sql_select = "SELECT NgaySinh FROM KhachHang WHERE MaKH = '"+MaKH+"'";
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
    public List<Datphong> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Datphong> getAllThuePhong() {
        List<Datphong> list = new ArrayList<>();
        try {
            
            String sql_select = "SELECT d.ID_DatPhong, p.MaPhong,d.MaNV,d.MaKH,p.TenPhong,p.LoaiPhong,l.GiaPhong,d.DatCoc,d.SoNguoi,d.NgayDatPhong,d.NgayNhanPhong,p.TinhTrangPhong FROM  phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong INNER JOIN datphong d ON p.MaPhong = d.MaPhong WHERE p.TinhTrangPhong = 'Đang thuê'";
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
               Date NgayDatPhong = rs.getDate(NgayDatPhong_FIELD);
               Date NgayNhanPhong = rs.getDate(NgayNhanPhong_FIELD);
                String TinhTrangPhong = rs.getString(TinhTrangPhong_FIELD);
                list.add(new Datphong(ID_DatPhong, MaPhong, MaNV, MaKH, TenPhong, LoaiPhong, GiaPhong, DatCoc, SoNguoi, NgayDatPhong, TinhTrangPhong, NgayNhanPhong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Optional<Datphong> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Datphong> get(String IDDatPhong) {
        Datphong datphong = new Datphong();
        try {
            String sql_select_by_id = "SELECT d.ID_DatPhong,d.MaPhong,p.TenPhong,d.MaNV,d.MaKH,d.NgayDatPhong,d.SoNguoi,d.DatCoc,d.NgayNhanPhong FROM datphong d INNER JOIN phong p ON d.MaPhong = p.MaPhong WHERE " + ID_DatPhong_FIELD + " = ?";
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
                datphong.setNgayNhanPhong(rs.getTimestamp(NgayNhanPhong_FIELD));
                datphong.setSoNguoi(rs.getInt(SoNguoi_FIELD));
                datphong.setDatCoc(rs.getInt(DatCoc_FIELD));
            }
        } catch (Exception e) {
        }
        return Optional.of(datphong);
    }

    @Override
    public int insert(Datphong t) {
        try {
            String sql_insert = "INSERT INTO datphong values( ?, ?, ?, ?, ?,?,?,?,Null)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getID_DatPhong());
            ps.setString(2, t.getMaPhong());
            ps.setString(3, t.getMaNV());
            ps.setString(4, t.getMaKH());
            ps.setTimestamp(5, (Timestamp) t.getNgayDatPhong());
            ps.setTimestamp(8, (Timestamp) t.getNgayDatPhong());
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
    
    public int insertDaDatPhong(Datphong t) {
        try {
            String sql_insert = "INSERT INTO datphong values( ?, ?, ?, ?, ?,?,?,?,Null)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getID_DatPhong());
            ps.setString(2, t.getMaPhong());
            ps.setString(3, t.getMaNV());
            ps.setString(4, t.getMaKH());
            ps.setTimestamp(5, (Timestamp) t.getNgayDatPhong());
            ps.setTimestamp(8, (Timestamp) t.getNgayDatPhong());
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
    public int updateNgayNhanPhong(Datphong t) {
        try {
            String sql_update = "UPDATE datphong d SET  "+ NgayNhanPhong_FIELD + " = ? " + " WHERE " + ID_DatPhong_FIELD + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setTimestamp(1, (Timestamp) t.getNgayNhanPhong());
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
    

    @Override
    public int update(Datphong t) {
       try {
            String sql_update = "UPDATE datphong SET " + MaPhong_FIELD + " = ?, " + MaNV_FIELD + " = ?, " + MaKH_FIELD + " = ?, " + NgayDatPhong_FIELD + " = ?, " + SoNguoi_FIELD + " = ?, " + DatCoc_FIELD + " = ?, "+ NgayNhanPhong_FIELD + " = ? " + " WHERE " + ID_DatPhong_FIELD + " = ?"; 
            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setString(1, t.getMaPhong());
            ps.setString(2, t.getMaNV());
            ps.setString(3, t.getMaKH());
            ps.setTimestamp(4, (Timestamp) t.getNgayDatPhong());
            ps.setInt(5, t.getSoNguoi());
            ps.setFloat(6, t.getDatCoc());
            ps.setTimestamp(7, (Timestamp) t.getNgayNhanPhong());
            ps.setString(8, t.getID_DatPhong());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String MaPhong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Datphong> find(Datphong t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public List<Datphong> find(String data, String colName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
