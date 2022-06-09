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
import QLKS.model.customer;
import static QLKS.view.Staffview.df;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tan_Tan_Chin 
 */
public class CustomerDao implements Dao<customer>{
    private static final String TABLE_NAME = "khachhang";
    private static final String MAKH_FIELD = "MaKH";
    private static final String TENKH_FIELD = "TenKH";
    private static final String NGAYSINH_FIELD = "NgaySinh";
    private static final String GIOITINH_FIELD = "GioiTinh";
    private static final String SDT_FIELD = "SDT";
    private static final String CMND_FIELD = "CMND";
    private static final String EMAIL_FIELD = "Email";
    private static final String DIACHI_FIELD = "DiaChi";
    Connection conn = MyConnection.getInstance().getConnection();
    @Override
    public List<customer> getAll() {
        List<customer> list = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME;
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String maKH = rs.getString(MAKH_FIELD);
                String TenKH = rs.getString(TENKH_FIELD);
                String NS = df.format(rs.getDate(NGAYSINH_FIELD));
                int GT = rs.getInt(GIOITINH_FIELD);
                String SDT = rs.getString(SDT_FIELD);
                String CMND = rs.getString(CMND_FIELD);
                String Email = rs.getString(EMAIL_FIELD);
                String DC = rs.getString(DIACHI_FIELD);
                list.add(new customer(maKH, TenKH, NS, GT, SDT, CMND, Email, DC));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<customer> getAll(String key) {
        List<customer> list = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME+" where "+TENKH_FIELD+" like '%"+key+"%'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String maKH = rs.getString(MAKH_FIELD);
                String TenKH = rs.getString(TENKH_FIELD);
                String NS = df.format(rs.getDate(NGAYSINH_FIELD));
                int GT = rs.getInt(GIOITINH_FIELD);
                String SDT = rs.getString(SDT_FIELD);
                String CMND = rs.getString(CMND_FIELD);
                String Email = rs.getString(EMAIL_FIELD);
                String DC = rs.getString(DIACHI_FIELD);
                list.add(new customer(maKH, TenKH, NS, GT, SDT, CMND, Email, DC));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Optional<customer> get(int id) {
        customer st = new customer();
        try {
            String sql_select_by_id = "SELECT * FROM "+TABLE_NAME+" WHERE "+MAKH_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                st.setMaKH(rs.getString(MAKH_FIELD));
                st.setTenKH(rs.getString(TENKH_FIELD));
                st.setNgaySinh(df.format(rs.getDate(NGAYSINH_FIELD)));
                st.setGioiTinh(rs.getInt(GIOITINH_FIELD));
                st.setSdt(rs.getString(SDT_FIELD));
                st.setCmnd(rs.getString(CMND_FIELD));
                st.setEmail(rs.getString(EMAIL_FIELD));
                st.setDiachi(rs.getString(DIACHI_FIELD));
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
    public Optional<customer> get(String id) {
        customer st = new customer();
        try {
            String sql_select_by_id = "SELECT * FROM "+TABLE_NAME+" WHERE "+MAKH_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                st.setMaKH(rs.getString(MAKH_FIELD));
                st.setTenKH(rs.getString(TENKH_FIELD));
                st.setNgaySinh(df.format(rs.getDate(NGAYSINH_FIELD)));
                st.setGioiTinh(rs.getInt(GIOITINH_FIELD));
                st.setSdt(rs.getString(SDT_FIELD));
                st.setCmnd(rs.getString(CMND_FIELD));
                st.setEmail(rs.getString(EMAIL_FIELD));
                st.setDiachi(rs.getString(DIACHI_FIELD));
                
            }
        } catch (Exception e) {
        }
        return Optional.of(st);
    }
    
    @Override
    public int insert(customer t) {
        try {
            String sql_insert = "insert into "+TABLE_NAME+" values(?, ?, ?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getMaKH());
            ps.setString(2, t.getTenKH());
            ps.setString(3, t.getNgaySinh());
            ps.setInt(4, t.getGioiTinh());
            ps.setString(5, t.getSdt());
            ps.setString(6, t.getCmnd());
            ps.setString(7, t.getEmail());
            ps.setString(8, t.getDiachi());
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
    public int update(customer t) {
        try {
            String sql_update = "UPDATE "+TABLE_NAME+" SET  "+TENKH_FIELD+" = ?, "+NGAYSINH_FIELD+" = ?, "+GIOITINH_FIELD+" = ?, "+SDT_FIELD+" = ?, "+CMND_FIELD+" = ?, "+EMAIL_FIELD+" = ? ,"+DIACHI_FIELD+" = ? WHERE "+MAKH_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setString(1, t.getTenKH());
            ps.setString(2, t.getNgaySinh());
            ps.setInt(3, t.getGioiTinh());
            ps.setString(4, t.getSdt());
            ps.setString(5, t.getCmnd());
            ps.setString(6, t.getEmail());
            ps.setString(7, t.getDiachi());
            ps.setString(8, t.getMaKH());
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
    public int delete(customer t) {
        try {
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+MAKH_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, t.getMaKH());
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
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+MAKH_FIELD+" = ?";
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
    public List<customer> find(String t) {
        List<customer> list = new ArrayList<>();
        try {
            String sql_find = "SELECT * FROM "+TABLE_NAME+ " WHERE ID > 0";
            if (!t.equals("")) {
                sql_find += " AND "+TENKH_FIELD+" LIKE '%"+t+"%'";
            } 
            PreparedStatement ps = conn.prepareStatement(sql_find);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String maKH = rs.getString(MAKH_FIELD);
                String TenKH = rs.getString(TENKH_FIELD);
                String NS = df.format(rs.getDate(NGAYSINH_FIELD));
                int GT = rs.getInt(GIOITINH_FIELD);
                String SDT = rs.getString(SDT_FIELD);
                String CMND = rs.getString(CMND_FIELD);
                String Email = rs.getString(EMAIL_FIELD);
                String DC = rs.getString(DIACHI_FIELD);
                list.add(new customer(maKH,  TenKH, NS, GT, SDT, CMND, Email, DC));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<customer> find(customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<customer> getList() {
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
    public List<customer> find(String data, String colName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
    
}
