/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.controller;

import QLKS.Connect1.MyConnection;
import QLKS.dao.Dao;
import QLKS.model.NhaCungCap;
import QLKS.model.NhapKho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

/**
 *
 * @author Tan_Tan_Chin 
 */
public class NhapKhoDao implements Dao<NhapKho>{

    Connection conn=MyConnection.getInstance().getConnection();
    @Override
    public List<NhapKho> getList() {
        List listNK=new ArrayList<>();
        try 
        {
             String query="Select * from NhapKho";
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs=ps.executeQuery();
             NhapKho nk;
             while(rs.next())
             {
                 nk=new NhapKho();
                 nk.setMaNhapKho(rs.getString("MaNhapKho"));
                 nk.setMaNCC(rs.getString("MaNCC"));
                 nk.setNgayNhap(rs.getTimestamp("NgayNhap"));
                 nk.setMaNV(rs.getString("MaNV"));
                 nk.setChietKhau(rs.getInt("ChietKhau"));
                 nk.setThanhTien(rs.getFloat("ThanhTien"));
                 listNK.add(nk);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listNK;
    }

    @Override
    public int insert(NhapKho t) {
        try 
        {
             String query="Insert into nhapkho values(?,?,?,?,?,?)";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, t.getMaNhapKho());
             ps.setString(2, t.getMaNCC());
             ps.setTimestamp(3, t.getNgayNhap());
             ps.setString(4, t.getMaNV());
             ps.setInt(5, t.getChietKhau());
             ps.setFloat(6, t.getThanhTien());
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
    public int update(NhapKho t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String t) {
       try
        {
             String query="Delete from nhapkho where MaNhapKho=?";
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
           
             String query="Select * from nhapkho where MaNhapKho = ?";
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
    public List<NhapKho> find(String data, String colName) {
        List listNK=new ArrayList<>();
        try 
        {   
            String query;
            if(colName.equals("Mã nhập kho"))
            {
              query="Select * from nhapkho,nhanvien,nhacungcap WHERE nhapkho.MaNCC=nhacungcap.MaNCC AND nhapkho.MaNV=nhanvien.MaNV AND MaNhapKho like \"%\"?\"%\"";
            }
            else if(colName.equals("Tên nhà cung cấp"))
            {
              query="Select * from nhapkho,nhanvien,nhacungcap WHERE nhapkho.MaNCC=nhacungcap.MaNCC AND nhapkho.MaNV=nhanvien.MaNV and TenNCC like \"%\"?\"%\" ";
            }
            else if(colName.equals("Ngày nhập"))
            {
              query="Select * from nhapkho where NgayNhap <= ?";
            }
            else if(colName.equals("Tên nhân viên"))
            {
              query="Select * from nhapkho,nhanvien,nhacungcap WHERE nhapkho.MaNCC=nhacungcap.MaNCC AND nhapkho.MaNV=nhanvien.MaNV and TenNV like \"%\"?\"%\" ";
            }
            else
            {
              query="Select * from nhapkho,nhanvien,nhacungcap WHERE nhapkho.MaNCC=nhacungcap.MaNCC AND nhapkho.MaNV=nhanvien.MaNV AND Thanhtien <= ?";
            }
            
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, data);
             ResultSet rs=ps.executeQuery();
             NhapKho nk;
             while(rs.next())
             {
                nk=new NhapKho();
                 nk.setMaNhapKho(rs.getString("MaNhapKho"));
                 nk.setMaNCC(rs.getString("MaNCC"));
                 nk.setNgayNhap(rs.getTimestamp("NgayNhap"));
                 nk.setMaNV(rs.getString("MaNV"));
                 nk.setChietKhau(rs.getInt("ChietKhau"));
                 nk.setThanhTien(rs.getFloat("ThanhTien"));
                 listNK.add(nk);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listNK;
    }

    @Override
    public String getData(String dataIn, String colIn) {
        String dataOut = null;
        try 
        {   
            String query;
            
             if(colIn.equals("MaNV"))
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
             else
             {
             query="Select * from NhaCungCap where MaNCC = ?";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1,dataIn);
             ResultSet rs=ps.executeQuery();
             while(rs.next())
             {
                dataOut=rs.getString("TenNCC");
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
    public int delete(String t, String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public List<NhaCungCap> getListNCC() {
        List listNCC=new ArrayList<>();
        try 
        {
            String query="Select * from nhacungcap";
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs=ps.executeQuery();
             NhaCungCap ncc;
             while(rs.next())
             {
                 ncc=new NhaCungCap();
                 ncc.setMaNCC(rs.getString("MaNCC"));
                 ncc.setTenNCC(rs.getString("TenNCC"));
                 ncc.setDiaChi(rs.getString("DiaChi"));
                 ncc.setSoDT(rs.getString("SoDT"));
                 listNCC.add(ncc);
             }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       return listNCC;
    }

    @Override
    public List<NhapKho> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<NhapKho> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<NhapKho> get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(NhapKho t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NhapKho> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NhapKho> find(NhapKho t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
