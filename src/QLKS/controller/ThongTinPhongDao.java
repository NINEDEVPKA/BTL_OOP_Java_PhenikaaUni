package QLKS.controller;

import QLKS.connect.MyConnection;
import QLKS.dao.Dao;
import QLKS.model.Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 *@author Tan_Tan_Chin 
 */
public class ThongTinPhongDao implements Dao<Phong> {

    private static final String TABLE_NAME = "phong";
    private static final String MaPhong_FIELD = "MaPhong";
    private static final String TenPhong_FIELD = "TenPhong";
    private static final String LoaiPhong_FIELD = "LoaiPhong";
    private static final String SoNguoiToiDa_FIELD = "SoNguoiToiDa";
    private static final String TinhTrangPhong_FIELD = "TinhTrangPhong";
    private static final String MoTaPhong_FIELD = "MoTaPhong";
    private static final String GiaPhong_FIELD = "GiaPhong";
    Connection conn = MyConnection.getInstance().getConnection();

    @Override
    public List<Phong> getAll() {
       List<Phong> list = new ArrayList<>();
        try {
            
            String sql_select = "SELECT p.MaPhong,p.TenPhong,p.LoaiPhong,l.MoTaPhong,p.SoNguoiToiDa,l.GiaPhong,p.TinhTrangPhong FROM  "+TABLE_NAME+" p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong ";
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
    public int getSoNgToiDa(String MaPhong) {
       int Song = 0 ;
        try {

            String sql_select = "SELECT SoNguoiToiDa FROM phong WHERE MaPhong = '" + MaPhong + "'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            while (rs.next()) {

                Song = rs.getInt("SoNguoiToiDa");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Song;
    }
    
    public List<Phong> find(String data, String colName) {
        List listP=new ArrayList<>();
        try 
        {   
            String query;
            if(colName.equals("Mã phòng"))
            {
              query="SELECT p.MaPhong,p.TenPhong,p.LoaiPhong,p.SoNguoiToiDa,l.GiaPhong,p.TinhTrangPhong FROM phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong WHERE p.MaPhong like \"%\"?\"%\" ";
            }else if(colName.equals("Tên phòng"))
            {
              query="SELECT p.MaPhong,p.TenPhong,p.LoaiPhong,p.SoNguoiToiDa,l.GiaPhong,p.TinhTrangPhong FROM phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong WHERE p.TenPhong like \"%\"?\"%\" ";
            }
            else if(colName.equals("Loại phòng"))
            {
              query="SELECT p.MaPhong,p.TenPhong,p.LoaiPhong,p.SoNguoiToiDa,l.GiaPhong,p.TinhTrangPhong FROM phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong WHERE p.LoaiPhong like \"%\"?\"%\" ";
            }
            else if(colName.equals("Số người tối đa"))
            {
              query="SELECT p.MaPhong,p.TenPhong,p.LoaiPhong,p.SoNguoiToiDa,l.GiaPhong,p.TinhTrangPhong FROM phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong WHERE p.SoNguoiToiDa like \"%\"?\"%\" ";
            }else if (colName.equals("Giá phòng")) {
            query="SELECT p.MaPhong,p.TenPhong,p.LoaiPhong,p.SoNguoiToiDa,l.GiaPhong,p.TinhTrangPhong FROM phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong WHERE  l.GiaPhong  <= ? ";
            }
            
            else {
            query="SELECT p.MaPhong,p.TenPhong,p.LoaiPhong,p.SoNguoiToiDa,l.GiaPhong,p.TinhTrangPhong FROM phong p INNER JOIN loaiphong l ON p.LoaiPhong = l.LoaiPhong WHERE p.TinhTrangPhong like \"%\"?\"%\" ";
            }
        
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, data);
             
             ResultSet rs=ps.executeQuery();
             Phong p;
             while(rs.next())
             {
                 p =new Phong();
                 p.setMaPhong(rs.getString("MaPhong"));
                 p.setTenPhong(rs.getString("TenPhong"));
                 p.setLoaiPhong(rs.getString("LoaiPhong"));
                 p.setSoNguoiToiDa(rs.getInt("SoNguoiToiDa"));
                 p.setTinhTrangPhong(rs.getString("TinhTrangPhong"));
                  p.setGiaPhong(rs.getFloat("GiaPhong"));
                
                 listP.add(p);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listP;
    }
    
    public List<Phong> getListLoaiPhong() {
       List<Phong> list = new ArrayList<>();
        try {
            
            String sql_select = "SELECT l.LoaiPhong FROM  loaiphong l";
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
    
    

    @Override
    public Optional<Phong> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Phong> get(String MaPhong) {
        Phong phong = new Phong();
        try {
            String sql_select_by_id = "SELECT * FROM "+TABLE_NAME+" WHERE "+MaPhong_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setString(1, MaPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                phong.setMaPhong(rs.getString(MaPhong_FIELD));
                phong.setTenPhong(rs.getString(TenPhong_FIELD));
                phong.setLoaiPhong(rs.getString(LoaiPhong_FIELD));
                phong.setSoNguoiToiDa(rs.getInt(SoNguoiToiDa_FIELD));
                phong.setTinhTrangPhong(rs.getString(TinhTrangPhong_FIELD));
            }
        } catch (Exception e) {
        }
        return Optional.of(phong);
    }

    @Override
    public int insert(Phong t) {
        try {
            String sql_insert = "INSERT INTO " + TABLE_NAME + " values( ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getMaPhong());
            ps.setString(2, t.getTenPhong());
            ps.setString(3, t.getLoaiPhong());
            ps.setInt(4, t.getSoNguoiToiDa());
            ps.setString(5, t.getTinhTrangPhong());
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

    @Override
    public int update(Phong t) {
        try {
            String sql_update = "UPDATE phong SET "+TenPhong_FIELD+" = ?, "+LoaiPhong_FIELD+" = ?, "+SoNguoiToiDa_FIELD+" = ?, "+TinhTrangPhong_FIELD+" = ?"+" WHERE "+MaPhong_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_update);
           
            ps.setString(1, t.getTenPhong());
            ps.setString(2, t.getLoaiPhong());
            ps.setInt(3, t.getSoNguoiToiDa());
            ps.setString(4, t.getTinhTrangPhong());
             ps.setString(5, t.getMaPhong());
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
    public int delete(Phong t) {
       try {
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+MaPhong_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, t.getMaPhong());
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

    
    public boolean checkMaPhong(String MaPhong) {
        try {
            String sql_select_by_code = "SELECT * FROM "+TABLE_NAME+" WHERE "+MaPhong_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_code);
            ps.setString(1, MaPhong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {    
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public int delete(String MaPhong) {
         try {
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+MaPhong_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, MaPhong);
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
    public List<Phong> find(Phong t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Phong> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Phong> getList() {
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
