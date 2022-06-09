/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.controller;

import QLKS.Connect1.MyConnection;
import QLKS.dao.Dao;
import QLKS.model.DichVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

/**
 *@author Tan_Tan_Chin 
 * 
 */
public class DichVuDao implements Dao<DichVu>{
    Connection conn=MyConnection.getInstance().getConnection();
    @Override
    public List<DichVu> getList() {
       List listDV=new ArrayList<>();
       DichVu dv=null;
        try 
        {
            String query="Select * from dichvu";
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs=ps.executeQuery();
             
             while(rs.next())
             {
                 dv=new DichVu();
                 dv.setMaDV(rs.getString("MaDV"));
                 dv.setTenDV(rs.getString("TenDV"));
                 dv.setMoTaDichVu(rs.getString("MoTaDichVu"));
                 dv.setPhiDV(rs.getFloat("PhiDV"));
                 listDV.add(dv);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listDV;
    }

    @Override
    public int insert(DichVu t) {
        try 
        {
             String query="Insert into dichvu values(?,?,?,?)";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, t.getMaDV());
             ps.setString(2, t.getTenDV());
             ps.setString(3, t.getMoTaDichVu());
             ps.setFloat(4, t.getPhiDV());
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
    public int update(DichVu t) {
        try
        {
             String query="Update dichvu set TenDV=?,MoTaDichVu=?,PhiDV=? where MaDV=?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(4, t.getMaDV());
             ps.setString(1, t.getTenDV());
             ps.setString(2, t.getMoTaDichVu());
             ps.setFloat(3, t.getPhiDV());
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
             String query="Delete from dichvu where MaDV=?";
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
    public List<DichVu> find(String data, String colName) {
        List listDV=new ArrayList<>();
        try 
        {   
            String query;
            if(colName.equals("Mã dịch vụ"))
            {
              query="Select * from dichvu where MaDV like \"%\"?\"%\"";
            }
            else if(colName.equals("Tên dịch vụ"))
            {
              query="Select * from dichvu where TenDV like \"%\"?\"%\" ";
            }
            else
            {
              query="Select * from dichvu where PhiDV <= ?";
            }
            
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, data);
             
             ResultSet rs=ps.executeQuery();
             DichVu dv;
             while(rs.next())
             {
                 dv=new DichVu();
                 dv.setMaDV(rs.getString("MaDV"));
                 dv.setTenDV(rs.getString("TenDV"));
                 dv.setMoTaDichVu(rs.getString("MoTaDichVu"));
                 dv.setPhiDV(rs.getFloat("PhiDV"));
                 listDV.add(dv);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listDV;
    }

    @Override
    public int findT(String t) {
       try 
        {   
           
             String query="Select * from dichvu where MaDV = ?";
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
    public String getData(String dataIn, String colIn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String t, String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public DichVu getDichVu(String MaDV)
    {
        DichVu dv=null;
        try 
        {   
           
             String query="Select * from dichvu where MaDV = ?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1,MaDV);
             ResultSet rs=ps.executeQuery();
             
             while(rs.next())
             {
                 dv=new DichVu();
                 dv.setMaDV(rs.getString("MaDV"));
                 dv.setTenDV(rs.getString("TenDV"));
                 dv.setMoTaDichVu(rs.getString("MoTaDichVu"));
                 dv.setPhiDV(rs.getFloat("PhiDV"));
                 
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return dv;
    }

    @Override
    public List<DichVu> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<DichVu> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<DichVu> get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(DichVu t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DichVu> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DichVu> find(DichVu t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
