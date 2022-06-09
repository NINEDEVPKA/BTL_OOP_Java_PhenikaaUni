/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.controller;

import QLKS.Connect1.MyConnection;
import QLKS.dao.Dao;
import QLKS.model.DatDichVu;
import QLKS.model.KhachHang;
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
public  class DatDichVuDao implements Dao<DatDichVu>{
     Connection conn=MyConnection.getInstance().getConnection();
    @Override
    public List<DatDichVu> getList() {
       
        List listDDV=new ArrayList<>();
        try 
        {
             String query="Select * from DatDichVu";
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs=ps.executeQuery();
             DatDichVu ddv;
             while(rs.next())
             {
                 ddv=new DatDichVu();
                 ddv.setMaHDDV(rs.getString("MaHDDV"));
                 ddv.setMaDV(rs.getString("MaDV"));
                 ddv.setMaKH(rs.getString("MaKH"));
                 ddv.setMaNV(rs.getString("MaNV"));
                 ddv.setThoiGianDat(rs.getTimestamp("ThoiGianDat"));
                 ddv.setThoiGianBatDauSDDV(rs.getTimestamp("ThoiGianBatDauSDDV"));
                 ddv.setSoLuong(rs.getInt("SoLuong"));
                 ddv.setThanhTien(rs.getFloat("ThanhTien"));
                 ddv.setGhiChu(rs.getString("GhiChu"));
                 listDDV.add(ddv);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listDDV;
    }

    @Override
    public int insert(DatDichVu t) {
        try 
        {
             String query="Insert into DatDichVu values(?,?,?,?,?,?,?,?,?)";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, t.getMaHDDV());
             ps.setString(2, t.getMaDV());
             ps.setString(3, t.getMaKH());
             ps.setString(4, t.getMaNV());
             ps.setTimestamp(5, t.getThoiGianDat());
             ps.setTimestamp(6, t.getThoiGianBatDauSDDV());
             ps.setInt(7, t.getSoLuong());
             ps.setFloat(8, t.getThanhTien());
             ps.setString(9, t.getGhiChu());
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
    public int update(DatDichVu t) {
        try
        {
             String query="Update DatDichVu set MaDV=?,ThoiGianBatDauSDDV=?,SoLuong=?,ThanhTien=?,GhiChu=? where MaHDDV=?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, t.getMaDV());
            
             ps.setTimestamp(2, t.getThoiGianBatDauSDDV());
             ps.setInt(3, t.getSoLuong());
             ps.setFloat(4, t.getThanhTien());
             ps.setString(5, t.getGhiChu());
             ps.setString(6, t.getMaHDDV());
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
             String query="Delete from DatDichVu where MaHDDV=?";
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
    public int delete(String t, String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findT(String t) {
        try 
        {   
           
             String query="Select * from DatDichVu where MaHDDV = ?";
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
            
                if(colIn.equals("MaDV"))
                {  
             query="Select * from DichVu where MaDV = ?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1,dataIn);
             ResultSet rs=ps.executeQuery();
                 while(rs.next())
                {
                dataOut=rs.getString("TenDV");
                }
                }
                else if(colIn.equals("MaKH"))
                {
             query="Select * from KhachHang where MaKH = ?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1,dataIn);
             ResultSet rs=ps.executeQuery();
                    while(rs.next())
                    {  
                    dataOut=rs.getString("TenKH");
                    }
                }
                else
                {
             query="Select * from NhanVien where MaNV = ?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1,dataIn);
             ResultSet rs=ps.executeQuery();
                    while(rs.next())
                    {  
                     dataOut=rs.getString("TenNV");
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
    public List<DatDichVu> find(String data, String colName) {
        List listDDV=new ArrayList<>();
        try 
        {   
            String query;
            if(colName.equals("Mã hóa đơn dịch vụ"))
            {
              query="Select * from datdichvu,dichvu,nhanvien,khachhang WHERE datdichvu.MaDV=dichvu.MaDV AND datdichvu.MaNV=nhanvien.MaNV  AND  datdichvu.MaKH=khachhang.MaKH AND MaHDDV like \"%\"?\"%\"";
            }
            else if(colName.equals("Tên dịch vụ"))
            {
              query="Select * from datdichvu,dichvu,nhanvien,khachhang WHERE datdichvu.MaDV=dichvu.MaDV AND datdichvu.MaNV=nhanvien.MaNV  AND  datdichvu.MaKH=khachhang.MaKH AND TenDV like \"%\"?\"%\"";
            }
            else if(colName.equals("Tên khách hàng"))
            {
              query="Select * from datdichvu,dichvu,nhanvien,khachhang WHERE datdichvu.MaDV=dichvu.MaDV AND datdichvu.MaNV=nhanvien.MaNV  AND  datdichvu.MaKH=khachhang.MaKH AND TenKH like \"%\"?\"%\"";
            }
            else if(colName.equals("Tên nhân viên"))
            {
              query="Select * from datdichvu,dichvu,nhanvien,khachhang WHERE datdichvu.MaDV=dichvu.MaDV AND datdichvu.MaNV=nhanvien.MaNV  AND  datdichvu.MaKH=khachhang.MaKH AND TenNV like \"%\"?\"%\"";
            }
            else if(colName.equals("Thời gian đặt"))
            {
              query="Select * from datdichvu,dichvu,nhanvien,khachhang WHERE datdichvu.MaDV=dichvu.MaDV AND datdichvu.MaNV=nhanvien.MaNV  AND  datdichvu.MaKH=khachhang.MaKH AND ThoiGianDat <= ?";
            }
            else if(colName.equals("Thời gian bắt đầu sử dụng dịch vụ"))
            {
              query="Select * from datdichvu,dichvu,nhanvien,khachhang WHERE datdichvu.MaDV=dichvu.MaDV AND datdichvu.MaNV=nhanvien.MaNV  AND  datdichvu.MaKH=khachhang.MaKH AND ThoiGianBatDauSDDV <=? ";
            }
            else
            {
              query="Select * from datdichvu,dichvu,nhanvien,khachhang WHERE datdichvu.MaDV=dichvu.MaDV AND datdichvu.MaNV=nhanvien.MaNV  AND  datdichvu.MaKH=khachhang.MaKH AND ThanhTIen <= ?";
            }
            
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, data);
             ResultSet rs=ps.executeQuery();
             DatDichVu ddv;
             while(rs.next())
             {
                 ddv=new DatDichVu();
                 ddv.setMaHDDV(rs.getString("MaHDDV"));
                 ddv.setMaDV(rs.getString("MaDV"));
                 ddv.setMaKH(rs.getString("MaKH"));
                 ddv.setMaNV(rs.getString("MaNV"));
                 ddv.setThoiGianDat(rs.getTimestamp("ThoiGianDat"));
                 ddv.setThoiGianBatDauSDDV(rs.getTimestamp("ThoiGianBatDauSDDV"));
                 ddv.setSoLuong(rs.getInt("SoLuong"));
                 ddv.setThanhTien(rs.getFloat("ThanhTien"));
                 ddv.setGhiChu(rs.getString("GhiChu"));
                 listDDV.add(ddv);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listDDV;
    }
     public List<KhachHang> getListLKH() {
        List listKH=new ArrayList<>();
        try 
        {
            String query="Select * from khachhang";
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs=ps.executeQuery();
             KhachHang kh;
             while(rs.next())
             {
                 kh=new KhachHang();
                 kh.setMaKH(rs.getString("MaKH"));
                 kh.setTenKH(rs.getString("TenKH"));
                 kh.setSoDT(rs.getString("SDT"));
                 listKH.add(kh);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listKH;
    }
     public KhachHang getKhachHang(String MaKH)
    {
        KhachHang kh=null;
        try 
        {   
           
             String query="Select * from khachhang where MaKH = ?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1,MaKH);
             ResultSet rs=ps.executeQuery();
             
             while(rs.next())
             {
                 kh=new KhachHang();
                 kh.setMaKH(rs.getString("MaKH"));
                 kh.setTenKH(rs.getString("TenKh"));
                 kh.setSoDT(rs.getString("SDT"));
                 
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return kh;
    }
     public List<DatDichVu> getBieuDo()
     {
         List listDDV=new ArrayList<>();
        try 
        {
             String query="SELECT MaDV,SUM(SoLuong)/(SELECT SUM(SoLuong) FROM datdichvu) AS TongDat FROM datdichvu GROUP BY MaDV";
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs=ps.executeQuery();
             DatDichVu ddv;
             while(rs.next())
             {
                 ddv=new DatDichVu();
                 
                 ddv.setMaDV(rs.getString("MaDV"));
               
                 ddv.setThanhTien(rs.getFloat("TongDat"));
                
                 listDDV.add(ddv);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listDDV;
     }

    @Override
    public List<DatDichVu> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<DatDichVu> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<DatDichVu> get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(DatDichVu t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DatDichVu> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DatDichVu> find(DatDichVu t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    
    

    

    
    
}
