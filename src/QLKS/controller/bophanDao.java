/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.controller;

import QLKS.dao.Dao;
import QLKS.model.bophan;
import QLKS.model.staff;
import QLKS.connect.MyConnection;
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
 * @author Tan_Tan_Chin 
 */
public class bophanDao implements Dao<bophan> {
    private static final String TABLE_NAME = "bophan";
    private static final String MABP_FIELD = "MaBoPhan";
    private static final String TENBP_FIELD = "TenBoPhan";
    Connection conn = MyConnection.getInstance().getConnection();
    
    @Override
    public List<bophan> getAll() {
        List<bophan> list = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME;
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String mabp = rs.getString(MABP_FIELD);
                String tenBP = rs.getString(TENBP_FIELD);
                
                list.add(new bophan(mabp, tenBP));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Optional<bophan> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<bophan> get(String id) {
        bophan bp = new bophan();
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME+" where "+MABP_FIELD+"= ?";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ps.setString(1, id);
            System.out.println(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                bp.setMaBP(rs.getString(MABP_FIELD));
                bp.setTenBP(rs.getString(TENBP_FIELD));
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.of(bp);
    }

    public String getMabp(String id) {
        bophan bp = new bophan();
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME+" where "+TENBP_FIELD+"= ?";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ps.setString(1, id);
            System.out.println(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                bp.setMaBP(rs.getString(MABP_FIELD));
                bp.setTenBP(rs.getString(TENBP_FIELD));
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bp.getMaBP();
    }
    @Override
    public int insert(bophan t) {
        try {
            String sql_insert = "insert into "+TABLE_NAME+" values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getMaBP());
            ps.setString(2, t.getTenBP());
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
    public int update(bophan t) {
        try {
            System.out.println(t.getTenBP());
            String sql_update = "UPDATE "+TABLE_NAME+" SET "+TENBP_FIELD+" = ? WHERE "+MABP_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_update);
            ps.setString(1, t.getTenBP());
            ps.setString(2, t.getMaBP());
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
    public int delete(bophan t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String t) {
        try {
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+MABP_FIELD+" = ?";
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
    public List<bophan> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<bophan> find(bophan t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<bophan> getList() {
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
    public List<bophan> find(String data, String colName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
