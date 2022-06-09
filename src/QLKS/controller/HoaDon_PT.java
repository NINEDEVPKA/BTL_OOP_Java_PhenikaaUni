/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.controller;

import QLKS.connect.MyConnection;
import QLKS.dao.Dao;
import QLKS.model.HoaDon;
import QLKS.model.PhuThu;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author Tan_Tan_Chin 
 */

public class HoaDon_PT implements Dao<HoaDon>{
    private static final String TABLE_NAME="hoadon";
    private static final String MAHD="MaHD";
    private static final String MAKH="makh";
    private static final String NGAYLAPHD="ngayLapHD";
    private static final String THANHTIEN="thanhtien";
    private static final String TRANGTHAI="trangthai";
    Connection conn=  MyConnection.getInstance().getConnection();
    public static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public List<HoaDon> getAll() {
        List<HoaDon> list = new ArrayList<>();
        try {
            String querySelect="Select hoadon.makh,ID_DatPhong, mahd,tenkh,"
                    + "ngaylaphd, thanhtien, trangthai from "+TABLE_NAME 
                    +" INNER JOIN khachhang on hoadon.MaKH=khachhang.MaKH";
            PreparedStatement ps= conn.prepareStatement(querySelect);
            System.out.println(querySelect);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {                
                String maHD= rs.getString(MAHD);
                String MaKH= rs.getString(MAKH);
                Date ngayLapHD= rs.getDate(NGAYLAPHD);
                double thanhTien= rs.getDouble(THANHTIEN);
                int trangThai=rs.getInt(TRANGTHAI);
                String idDatPhong=rs.getString("ID_DatPhong");
                list.add(new HoaDon(maHD,MaKH,idDatPhong,ngayLapHD,thanhTien,trangThai,1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public String findNameKH(String maKH) throws SQLException
    {
        String name="";
        String queryFindName= "Select tenkh from hoadon inner join khachhang on"
                + " hoadon.makh=khachhang.makh where hoadon.makh='"+maKH+"'";
            PreparedStatement ps = conn.prepareStatement(queryFindName);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 name=rs.getString("tenkh");
            }
            
        return name;
        
    }
    @Override
    public Optional<HoaDon> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<HoaDon> get(String id) {
        HoaDon Hd = new HoaDon();
        try {
            String querySelect="Select mahd,makh,ID_DatPhong,"
                    + "ngaylaphd, thanhtien, trangthai from "+TABLE_NAME
                    +" where "+MAHD+"='"+id+"'";
            
            PreparedStatement ps = conn.prepareStatement(querySelect);
            
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                Hd.setMaHD(rs.getString(MAHD));
                Hd.setMaKH(rs.getString(MAKH));
                Hd.setNgayLapHD(rs.getDate(NGAYLAPHD));
                Hd.setThanhTien(rs.getDouble(THANHTIEN));
                Hd.setTrangThai(rs.getInt(TRANGTHAI));
                Hd.setID_DatPhong(rs.getString("ID_DatPhong"));
            }
            
        } catch (Exception e) {
        }
        return Optional.of(Hd); 
    }

    @Override
    public int insert(HoaDon t) {
        try {
            String queryInsert= "Insert into "+TABLE_NAME+" values(?,?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(queryInsert);
            ps.setString(1, t.getMaHD());
            ps.setString(2, t.getMaKH());
            ps.setTimestamp(3, (Timestamp) t.getNgayLapHD());
            ps.setDouble(4, t.getThanhTien());
            ps.setInt(5, t.getTrangThai());          
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
    public int update(HoaDon t) {
        try {
            String queryUpdate= "update "+TABLE_NAME+" set MaKh=?,ngayLapHD=?,ThanhTien=?,TrangThai=? where "+MAHD+"=?";
            PreparedStatement ps= conn.prepareStatement(queryUpdate);
            ps.setString(5, t.getMaHD());
            ps.setString(1, t.getMaKH());
            ps.setTimestamp(2, (Timestamp) t.getNgayLapHD());
            ps.setDouble(3, t.getThanhTien());
            ps.setDouble(4, t.getTrangThai());
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
    public int updateThanhTien(Double ThanhTien,String maKH)
    {
        try {
            String queryUpdate= "update "+TABLE_NAME+" set ThanhTien=ThanhTien+"+ThanhTien+" where "+MAHD+"='"+maKH+"' and TrangThai=0";
            PreparedStatement ps= conn.prepareStatement(queryUpdate);
            System.out.println(queryUpdate);
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
    public int delete(HoaDon t) {
        try {
            String queryUpdate= "delete from "+TABLE_NAME+" where "+MAHD+"=?";
            PreparedStatement ps= conn.prepareStatement(queryUpdate);
            ps.setString(1, t.getMaHD());
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
    public List<HoaDon> find(HoaDon t) {
        List<HoaDon> list = new ArrayList<>();
        try {
            String querySelect="Select hd.makh,ID_DatPhong, mahd,tenkh,"
                    + "ngaylaphd, thanhtien, trangthai from "+TABLE_NAME 
                    +" hd INNER JOIN khachhang on hd.MaKH=khachhang.MaKH where hd.mahd like  '%"+t.getMaHD()+"%' or"
                    + " hd.makh like '%"+t.getMaKH()+"%' or tenkh like '%"+t.getMaHD()+"%'";
            PreparedStatement ps= conn.prepareStatement(querySelect);
            System.out.println(querySelect);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {                
                String maHD= rs.getString(MAHD);
                String MaKH= rs.getString(MAKH);
                Date ngayLapHD= rs.getDate(NGAYLAPHD);
                double thanhTien= rs.getDouble(THANHTIEN);
                int trangThai=rs.getInt(TRANGTHAI);
                String idDatPhong=rs.getString("ID_DatPhong");
                list.add(new HoaDon(maHD,MaKH,idDatPhong,ngayLapHD,thanhTien,trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        HoaDon_PT hd= new HoaDon_PT();
        List<HoaDon> hd1 = hd.find(new HoaDon("kh001"));
        for (HoaDon hoaDon : hd1) {
            System.out.println(hoaDon);
        }
            
        

    }
    
    public List<HoaDon> findbyNgay(Timestamp ngayTu, Timestamp ngayDen) {
        List<HoaDon> list = new ArrayList<>();
        try {
            String querySelect="Select hd.makh, mahd,tenkh,"
                    + "ngaylaphd, thanhtien, trangthai from "+TABLE_NAME 
                    +" hd INNER JOIN khachhang on hd.MaKH=khachhang.MaKH where ngaylaphd between '"+ngayTu+"' and '"+ngayDen+"'";
            PreparedStatement ps= conn.prepareStatement(querySelect);
            System.out.println(querySelect);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {                
                String maHD= rs.getString(MAHD);
                String MaKH= rs.getString(MAKH);
                Date ngayLapHD= rs.getDate(NGAYLAPHD);
                double thanhTien= rs.getDouble(THANHTIEN);
                int trangThai=rs.getInt(TRANGTHAI);
                list.add(new HoaDon(maHD,MaKH,ngayLapHD,thanhTien,trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void UpdateKho(String maSP,int SL) throws SQLException
    {
        String queryUpdateKho="Update kho set soluong=soluong+"+SL+" where maSP=?";
        PreparedStatement ps= conn.prepareStatement(queryUpdateKho);
            ps.setString(1, maSP);
            int k=ps.executeUpdate();          
    }
    public double getPhiPhong(String MaPhong) {
       double PhiPhong = 0 ;
        try {

            String sql_select = "select lp.GiaPhong from Phong p\n" +
            "INNER join datphong dp on dp.MaPhong=p.MaPhong\n" +
            "INNER JOIN LoaiPhong lp on Lp.LoaiPhong=p.LoaiPhong\n" +
            "WHERE dp.ID_DatPhong= '" + MaPhong + "'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery(sql_select);
            System.out.println(ps);
            while (rs.next()) {
                PhiPhong = rs.getDouble("GiaPhong");
                System.out.println(PhiPhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return PhiPhong;
    }
    @Override
    public int delete(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDon> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDon> getList() {
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
    public List<HoaDon> find(String data, String colName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
