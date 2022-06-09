/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.controller;

import QLKS.connect.MyConnection;
import QLKS.dao.Dao;
import QLKS.model.PhuThu;
import QLKS.model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Tan_Tan_Chin 
 */
public class SanPhamDao implements Dao<SanPham>{
    private static final String TABLE_NAME="loaisanpham";
    private static final String MASP="masp";
    private static final String TENSP="tensp";
    private static final String MOTA="motasp";
    private static final String GIA="giasp";
    Connection conn=  MyConnection.getInstance().getConnection();
    @Override
    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME;
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {                    
                String maSP = rs.getString(MASP);
                String tenSP = rs.getString(TENSP);
                String mota= rs.getString(MOTA);
                Double gia= rs.getDouble(GIA);
                list.add(new SanPham(maSP,tenSP,mota,gia));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;   
    }

    @Override
    public Optional<SanPham> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<SanPham> get(String id) {
        SanPham sanPham = new SanPham();
        try {
            String querySelect="SELECT * FROM "+TABLE_NAME+" where masp=?";
            PreparedStatement ps = conn.prepareStatement(querySelect);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                sanPham.setMaSP(rs.getString(MASP));
                sanPham.setTenSP(rs.getString(TENSP));
                sanPham.setMoTa(rs.getString(MOTA));
                sanPham.setGiaSP(rs.getDouble(GIA));
            }
        } catch (Exception e) {
        }
        return Optional.of(sanPham); 
    }

    @Override
    public int insert(SanPham t) {
        try {
            String queryInsert= "Insert into "+TABLE_NAME+" values(?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(queryInsert);
            ps.setString(1, t.getMaSP());
            ps.setString(2, t.getTenSP());
            ps.setString(3, t.getMoTa());
            ps.setDouble(4, t.getGiaSP());
            int k=ps.executeUpdate();
            if(k>0)
                return 1;
            else
                return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(SanPham t) {
        try {
            String queryUpdate= "update "+TABLE_NAME+" set tenSP=?,motaSP=?,GiaSP=? where "+MASP+"=?";
            PreparedStatement ps= conn.prepareStatement(queryUpdate);
            ps.setString(4, t.getMaSP());
            ps.setString(1, t.getTenSP());
            ps.setString(2, t.getMoTa());
            ps.setDouble(3, t.getGiaSP());
            int k=ps.executeUpdate();
            if(k>0)
                return 1;
            else
                return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;    }

    @Override
    public int delete(SanPham t) {
            try {
            String queryUpdate= "delete from "+TABLE_NAME+" where "+MASP+"=?";
            PreparedStatement ps= conn.prepareStatement(queryUpdate);
            ps.setString(1, t.getMaSP());
            int k=ps.executeUpdate();
            if(k>0)
                return 1;
            else
                return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;     }

    @Override
    public List<SanPham> find(SanPham t) {
        List<SanPham> list = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME+" where masp like '%"+t.getMaSP()+"%' or tensp like '%"+t.getMaSP()+"%'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {                    
                String maSP = rs.getString(MASP);
                String tenSP = rs.getString(TENSP);
                String mota= rs.getString(MOTA);
                Double gia= rs.getDouble(GIA);
                list.add(new SanPham(maSP,tenSP,mota,gia));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; 
    }
    public static void main(String[] args) {
        SanPhamDao sp= new SanPhamDao();
        if(sp.delete(new SanPham("sp006","","",20))>0)
            System.out.println("Thành công");
        else
            System.out.println("Thất bại");

    }

    @Override
    public int delete(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SanPham> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SanPham> getList() {
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
    public List<SanPham> find(String data, String colName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
