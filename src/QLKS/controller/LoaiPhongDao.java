/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.controller;

import QLKS.Connect1.MyConnection;
import QLKS.dao.Dao;
import QLKS.model.LoaiPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

/**
 *
 * @author Tan_Tan_Chin 
 */
public class LoaiPhongDao implements Dao<LoaiPhong>{

    
    Connection conn=MyConnection.getInstance().getConnection();
    @Override
    public List<LoaiPhong> getList() {
        List listLP=new ArrayList<>();
        try 
        {
             String query="Select * from Loaiphong";
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs=ps.executeQuery();
             LoaiPhong lp;
             while(rs.next())
             {
                 lp=new LoaiPhong();
                 lp.setLoaiPhong(rs.getString("LoaiPhong"));
                 lp.setMoTaPhong(rs.getString("MoTaPhong"));
                 lp.setGiaPhong(rs.getFloat("GiaPhong"));
                 listLP.add(lp);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listLP;
    }

    @Override
    public int insert(LoaiPhong t) {
        try 
        {
             String query="Insert into loaiphong values(?,?,?)";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, t.getLoaiPhong());
             ps.setString(2, t.getMoTaPhong());
             ps.setFloat(3, t.getGiaPhong());
             int k=ps.executeUpdate();
             if(k>0)
             {
                 JOptionPane.showMessageDialog(null,"Bạn đã thêm thành công !");
                 return 1;
                 
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Thao tác thất bại !");
                 return 0;
             }
             
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(LoaiPhong t) {
        try
        {
             String query="Update Loaiphong set MoTaPhong=?,GiaPhong=? where LoaiPhong=?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(3, t.getLoaiPhong());
             ps.setString(1, t.getMoTaPhong());
             ps.setFloat(2, t.getGiaPhong());
             int k=ps.executeUpdate();
             if(k>0)
             {
                 JOptionPane.showMessageDialog(null,"Bạn đã cập nhật thành công !");
                 return 1;
                 
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Thao tác thất bại !");
                 return 0;
             }
             
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(String t) {
        try
        {
             String query="Delete from Loaiphong where LoaiPhong=?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1,t);
             int k=ps.executeUpdate();
             if(k>0)
             {
                 JOptionPane.showMessageDialog(null,"Bạn đã xóa thành công !");
                 return 1;
                 
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Thao tác thất bại !");
                 return 0;
             }
             
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int findT(String t) {
        try 
        {   
           
             String query="Select * from Loaiphong where LoaiPhong = ?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1,t);
             ResultSet rs=ps.executeQuery();
             if(rs.next())
             {
                 return 1;
             }
             else
             {
                 return 0;
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return 0;
    }

    @Override
    public List<LoaiPhong> find(String data, String colName) {
        List listLP=new ArrayList<>();
        try 
        {   
            String query;
            if(colName.equals("Loại phòng"))
            {
              query="Select * from Loaiphong where LoaiPhong like \"%\"?\"%\" ";
            }
            else
            {
              query="Select * from Loaiphong where GiaPhong <= ?";
            }
            
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, data);
             
             ResultSet rs=ps.executeQuery();
             LoaiPhong lp;
             while(rs.next())
             {
                 lp=new LoaiPhong();
                 lp.setLoaiPhong(rs.getString("LoaiPhong"));
                 lp.setMoTaPhong(rs.getString("MoTaPhong"));
                 lp.setGiaPhong(rs.getFloat("GiaPhong"));
                 listLP.add(lp);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listLP;
    }

    @Override
    public String getData(String dataIn, String colIn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String t, String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LoaiPhong> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<LoaiPhong> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<LoaiPhong> get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(LoaiPhong t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LoaiPhong> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LoaiPhong> find(LoaiPhong t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
