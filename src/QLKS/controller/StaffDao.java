/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.controller;

import QLKS.connect.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import QLKS.dao.Dao;
import QLKS.model.bophan;
import QLKS.model.staff;
import static QLKS.view.Staffview.df;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tan_Tan_Chin 
 */
public class StaffDao implements Dao<staff>{
    private static final String TABLE_NAME = "nhanvien";
    private static final String MANV_FIELD = "MaNV";
    private static final String MABOPHAN_FIELD = "MaBoPhan";
    private static final String TENNV_FIELD = "TenNV";
    private static final String NGAYSINH_FIELD = "NgaySinh";
    private static final String GIOITINH_FIELD = "GioiTinh";
    private static final String SDT_FIELD = "SDT";
    private static final String CMND_FIELD = "CMND";
    private static final String EMAIL_FIELD = "Email";
    private static final String DIACHI_FIELD = "DiaChi";
    private static final String LUONG_FIELD = "Luong";
    Connection conn = MyConnection.getInstance().getConnection();
    @Override
    public List<staff> getAll() {
        List<staff> list = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME;
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String maNV = rs.getString(MANV_FIELD);
                String maBP = rs.getString(MABOPHAN_FIELD);
                String TenNV = rs.getString(TENNV_FIELD);
                String NS = df.format(rs.getDate(NGAYSINH_FIELD));
                int GT = rs.getInt(GIOITINH_FIELD);
                String SDT = rs.getString(SDT_FIELD);
                String CMND = rs.getString(CMND_FIELD);
                String Email = rs.getString(EMAIL_FIELD); 
                String DC = rs.getString(DIACHI_FIELD);
                String Luong = rs.getString(LUONG_FIELD);
                list.add(new staff(maNV, maBP, TenNV, NS, GT, SDT, CMND, Email, DC, Luong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String doiGT(String tt){
        if (tt.equals("0")) {
            return "Nữ";
        } else {
            return "Nam";
        }
    }
    public int getCount(String bp) {
        int so = 0;
        try {
            String sql_select = "SELECT COUNT(MaNV) AS dem FROM nhanvien WHERE MaBoPhan = '"+bp+"'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {     
                so = rs.getInt("dem");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return so;
    }
    public int getTong() {
        int so = 0;
        try {
            String sql_select = "SELECT COUNT(MaNV) AS dem FROM nhanvien ";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {     
                so = rs.getInt("dem");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return so;
    }
    public List<staff> getNV() {
        List<staff> list = new ArrayList<>();
        try {
            String sql_select = "SELECT  MaNV,TenNV,Email,TenBoPhan FROM nhanvien INNER JOIN bophan ON nhanvien.MaBoPhan = bophan.MaBoPhan WHERE MaNV NOT IN (SELECT nv.MaNV FROM nhanvien AS nv , dangnhap AS dn WHERE dn.MaNV = nv.MaNV)";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String maNV = rs.getString(MANV_FIELD);
                String TenNV = rs.getString(TENNV_FIELD);
                String Email = rs.getString(EMAIL_FIELD);
                String DC = rs.getString("TenBoPhan");
                String Luong = rs.getString(LUONG_FIELD);
                list.add(new staff(maNV, "a", TenNV, "", 0, "", "", Email, DC, Luong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<staff> getAllNV() {
        List<staff> list = new ArrayList<>();
        try {
            String sql_select = "SELECT  MaNV,TenNV,Email,TenBoPhan FROM nhanvien INNER JOIN bophan ON nhanvien.MaBoPhan = bophan.MaBoPhan ";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String maNV = rs.getString(MANV_FIELD);
                String TenNV = rs.getString(TENNV_FIELD);
                String Email = rs.getString(EMAIL_FIELD);
                String DC = rs.getString("TenBoPhan");
                 String Luong = rs.getString(LUONG_FIELD);
                list.add(new staff(maNV, "a", TenNV, "", 0, "", "", Email, DC, Luong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<staff> getAll(String key) {
        List<staff> list = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME+" where "+TENNV_FIELD+" like '%"+key+"%'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String maNV = rs.getString(MANV_FIELD);
                String maBP = rs.getString(MABOPHAN_FIELD);
                String TenNV = rs.getString(TENNV_FIELD);
                String NS = df.format(rs.getDate(NGAYSINH_FIELD));
                int GT = rs.getInt(GIOITINH_FIELD);
                String SDT = rs.getString(SDT_FIELD);
                String CMND = rs.getString(CMND_FIELD);
                String Email = rs.getString(EMAIL_FIELD);
                String DC = rs.getString(DIACHI_FIELD);
                 String Luong = rs.getString(LUONG_FIELD);
                list.add(new staff(maNV, maBP, TenNV, NS, GT, SDT, CMND, Email, DC, Luong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Optional<staff> get(int id) {
        staff st = new staff();
        try {
            String sql_select_by_id = "SELECT * FROM "+TABLE_NAME+" WHERE "+MANV_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                st.setMaNV(rs.getString(MANV_FIELD));
                st.setMaBP(rs.getString(MABOPHAN_FIELD));
                st.setTenNV(rs.getString(TENNV_FIELD));
                st.setNgaySinh(df.format(rs.getDate(NGAYSINH_FIELD)));
                st.setGioiTinh(rs.getInt(GIOITINH_FIELD));
                st.setSdt(rs.getString(SDT_FIELD));
                st.setCmnd(rs.getString(CMND_FIELD));
                st.setEmail(rs.getString(EMAIL_FIELD));
                st.setDiachi(rs.getString(DIACHI_FIELD));
                st.setLuong(rs.getString(LUONG_FIELD));
            }
        } catch (Exception e) {
        }
        return Optional.of(st);
    }
    
    //Optional là một kiểu dữ liệu container, nó bao bọc chỉ một giá trị duy nhất nếu giá trị đó tồn tại.
    //Như vậy mục đích của nó đưa ra là về sự tồn tại của dữ liệu hay không. 
    //Optional<String> optional = Optional.of(str);
    //Tạo một đối tượng Optional chứa giá trị non-null
    

    @Override
    public Optional<staff> get(String id) {
        staff st = new staff();
        try {
            String sql_select_by_id = "SELECT * FROM "+TABLE_NAME+" WHERE "+MANV_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                st.setMaNV(rs.getString(MANV_FIELD));
                st.setMaBP(rs.getString(MABOPHAN_FIELD));
                st.setTenNV(rs.getString(TENNV_FIELD));
                st.setNgaySinh(df.format(rs.getDate(NGAYSINH_FIELD)));
                st.setGioiTinh(rs.getInt(GIOITINH_FIELD));
                st.setSdt(rs.getString(SDT_FIELD));
                st.setCmnd(rs.getString(CMND_FIELD));
                st.setEmail(rs.getString(EMAIL_FIELD));
                st.setDiachi(rs.getString(DIACHI_FIELD));
                st.setLuong(rs.getString(LUONG_FIELD));
            }
        } catch (Exception e) {
        }
        return Optional.of(st);
    }
    public staff getnv(String id) {
        staff st = new staff();
        try {
            String sql_select_by_id = "SELECT * FROM "+TABLE_NAME+" WHERE "+MANV_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                st.setMaNV(rs.getString(MANV_FIELD));
                st.setMaBP(rs.getString(MABOPHAN_FIELD));
                st.setTenNV(rs.getString(TENNV_FIELD));
                st.setNgaySinh(df.format(rs.getDate(NGAYSINH_FIELD)));
                st.setGioiTinh(rs.getInt(GIOITINH_FIELD));
                st.setSdt(rs.getString(SDT_FIELD));
                st.setCmnd(rs.getString(CMND_FIELD));
                st.setEmail(rs.getString(EMAIL_FIELD));
                st.setDiachi(rs.getString(DIACHI_FIELD));
                st.setLuong(rs.getString(LUONG_FIELD));
            }
        } catch (Exception e) {
        }
        return st;
    }
    public List<staff> get(bophan bp) {
        staff st = new staff();
        List<staff> list = new ArrayList<>();
        try {
            String sql_select_by_id = "SELECT * FROM "+TABLE_NAME+" WHERE "+MABOPHAN_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setString(1, bp.getMaBP());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                st.setMaNV(rs.getString(MANV_FIELD));
                st.setMaBP(rs.getString(MABOPHAN_FIELD));
                st.setTenNV(rs.getString(TENNV_FIELD));
                st.setNgaySinh(df.format(rs.getDate(NGAYSINH_FIELD)));
                st.setGioiTinh(rs.getInt(GIOITINH_FIELD));
                st.setSdt(rs.getString(SDT_FIELD));
                st.setCmnd(rs.getString(CMND_FIELD));
                st.setEmail(rs.getString(EMAIL_FIELD));
                st.setDiachi(rs.getString(DIACHI_FIELD));
                st.setLuong(rs.getString(LUONG_FIELD));
                list.add(st);
            }
        } catch (Exception e) {
        }
        return list;
    }
    @Override
    public int insert(staff t) {
        try {
            String sql_insert = "insert into "+TABLE_NAME+" values(?, ?, ?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getMaNV());
            ps.setString(2, t.getMaBP());
            ps.setString(3, t.getTenNV());
            ps.setString(4, t.getNgaySinh());
            ps.setInt(5, t.getGioiTinh());
            ps.setString(6, t.getSdt());
            ps.setString(7, t.getCmnd());
            ps.setString(8, t.getEmail());
            ps.setString(9, t.getDiachi());
            ps.setString(10, t.getLuong());
            int k = ps.executeUpdate();
            if (k > 0) {
                ResultSet rsKey = ps.getGeneratedKeys();  
                if (rsKey.next()) {
                    return rsKey.getInt(1);
                }else{
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

    @Override
    public int update(staff t) {
        try {
            String sql_update = "UPDATE "+TABLE_NAME+" SET  "+MABOPHAN_FIELD+" = ?, "+TENNV_FIELD+" = ?, "+NGAYSINH_FIELD+" = ?, "+GIOITINH_FIELD+" = ?, "+SDT_FIELD+" = ?, "+CMND_FIELD+" = ?, "+EMAIL_FIELD+" = ? ,"+DIACHI_FIELD+" = ?, "+LUONG_FIELD+" = ? WHERE "+MANV_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setString(1, t.getMaBP());
            ps.setString(2, t.getTenNV());
            ps.setString(3, t.getNgaySinh());
            ps.setInt(4, t.getGioiTinh());
            ps.setString(5, t.getSdt());
            ps.setString(6, t.getCmnd());
            ps.setString(7, t.getEmail());
            ps.setString(8, t.getDiachi());
            ps.setString(9, t.getLuong());
            ps.setString(10, t.getMaNV());
            int k = ps.executeUpdate();
            if (k > 0) {
                return 1;
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(staff t) {
        try {
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+MANV_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, t.getMaNV());
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
    public int delete(String t) {
        try {
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+MANV_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, t);
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
    public List<staff> find(String t) {
        List<staff> list = new ArrayList<>();
        try {
            String sql_find = "SELECT * FROM "+TABLE_NAME+ " WHERE ID > 0";
            if (!t.equals("")) {
                sql_find += " AND "+TENNV_FIELD+" LIKE '%"+t+"%'";
            } 
            PreparedStatement ps = conn.prepareStatement(sql_find);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String maNV = rs.getString(MANV_FIELD);
                String maBP = rs.getString(MABOPHAN_FIELD);
                String TenNV = rs.getString(TENNV_FIELD);
                String NS = df.format(rs.getDate(NGAYSINH_FIELD));
                int GT = rs.getInt(GIOITINH_FIELD);
                String SDT = rs.getString(SDT_FIELD);
                String CMND = rs.getString(CMND_FIELD);
                String Email = rs.getString(EMAIL_FIELD);
                String DC = rs.getString(DIACHI_FIELD);
                String Luong = rs.getString(LUONG_FIELD);
                list.add(new staff(maNV, maBP, TenNV, NS, GT, SDT, CMND, Email, DC, Luong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<staff> find(staff t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<staff> getList() {
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
    public List<staff> find(String data, String colName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
    
}
