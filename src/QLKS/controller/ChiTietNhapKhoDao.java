/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.controller;

import QLKS.Connect1.MyConnection;
import QLKS.dao.Dao;
import QLKS.model.ChiTietNhapKho;
import QLKS.model.LoaiSanPham;

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
public class ChiTietNhapKhoDao implements Dao<ChiTietNhapKho>{

    @Override
    public List<ChiTietNhapKho> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    Connection conn=MyConnection.getInstance().getConnection();
    @Override
    public int insert(ChiTietNhapKho t) {
        try 
        {
             String query="Insert into chitietnhapkho values(?,?,?,?)";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, t.getMaNhapKho());
             ps.setString(2, t.getMaSanPham());
             ps.setInt(3, t.getSoLuong());
             ps.setFloat(4, t.getGiaNhap());
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
    public int update(ChiTietNhapKho t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String t) {
        try
        {
             String query="Delete from chitietnhapkho where MaNhapKho=? ";
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
           
             String query="Select * from chitietnhapkho where MaNhapKho = ?";
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
        String dataOut = null;
        try 
        {   
            String query;
            
             if(colIn.equals("MaSP"))
             {
             query="Select * from LoaiSanPham where MaSP = ?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1,dataIn);
             ResultSet rs=ps.executeQuery();
             while(rs.next())
             {
                dataOut=rs.getString("TenSP");
             }
             }
             
             
             
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return dataOut;
    }

    @Override
    public List<ChiTietNhapKho> find(String data, String colName) {
        List<ChiTietNhapKho> listCTNK=new ArrayList<>();
        try 
        {   
            String query="";
            if(colName.equals("MaNhapKho"))
            {
              query="Select * from chitietnhapkho where MaNhapKho=?";
            }
            
            
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, data);
             ResultSet rs=ps.executeQuery();
             ChiTietNhapKho ctnk;
             while(rs.next())
             {
                ctnk=new ChiTietNhapKho();
                 ctnk.setMaNhapKho(rs.getString("MaNhapKho"));
                 ctnk.setMaSanPham(rs.getString("MaSP"));
                 ctnk.setSoLuong(rs.getInt("SoLuong"));
                 ctnk.setGiaNhap(rs.getFloat("GiaNhap"));
                 listCTNK.add(ctnk);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listCTNK;
    }

    @Override
    public int delete(String t, String x) {
        try
        {
             String query="Delete from chitietnhapkho where MaNhapKho=? and MaSP=?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1,t);
             ps.setString(2,x);
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
    
    public List<LoaiSanPham> getListLSP() {
        List listLSP=new ArrayList<>();
        try 
        {
            String query="Select * from loaisanpham";
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs=ps.executeQuery();
             LoaiSanPham lsp;
             while(rs.next())
             {
                 lsp=new LoaiSanPham();
                 lsp.setMaSP(rs.getString("MaSP"));
                 lsp.setTenSP(rs.getString("TenSP"));
                 lsp.setMoTaSP(rs.getString("MoTaSP"));
                 lsp.setGiaSP(rs.getFloat("GiaSP"));
                 listLSP.add(lsp);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listLSP;
    }
     public int updateKho(String MaSp,int sl) {
        try
        {
             String query="Update kho set SoLuong=SoLuong+? where MaSP =? ";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(2,MaSp);
             ps.setInt(1,sl);
             int k=ps.executeUpdate();
             if(k>0)
             {
                 JOptionPane.showMessageDialog(null,"Bạn đã cập nhật số lượng sản phẩm trong kho thành công !!");
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
    public int updateNK(String MaNK,float ThanhTien) {
        try
        {
             String query="Update nhapkho set ThanhTien=ThanhTien+? where MaNhapKho =? ";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(2,MaNK);
             ps.setFloat(1,ThanhTien);
             int k=ps.executeUpdate();
             if(k>0)
             {
                 JOptionPane.showMessageDialog(null,"Bạn đã cập nhật thành tiền thành công !!");
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
    public List<ChiTietNhapKho> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<ChiTietNhapKho> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<ChiTietNhapKho> get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(ChiTietNhapKho t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChiTietNhapKho> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChiTietNhapKho> find(ChiTietNhapKho t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
