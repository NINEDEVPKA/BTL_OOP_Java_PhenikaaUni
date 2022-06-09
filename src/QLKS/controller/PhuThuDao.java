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
//import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Tan_Tan_Chin 
 */
public class PhuThuDao implements Dao<PhuThu>{
    private static final String TABLE_NAME="phuthu";
    private static final String MAPT="maphuthu";
    private static final String MAKH="makh";
    private static final String MAHD="mahd";
    private static final String MASP="masp";
    private static final String SL="soluongphuthu";
    private static final String NGAYBAN="ngayban";
    private static final String THANHTIEN="thanhtien";
    Connection conn=  MyConnection.getInstance().getConnection();

    @Override
    public List<PhuThu> getAll() {
        List<PhuThu> list = new ArrayList<>();
        try {
            String querySelect="Select maphuthu,makh,mahd,masp,soluongphuthu,"
                    + "ngayban, thanhtien from "+TABLE_NAME;
            PreparedStatement ps= conn.prepareStatement(querySelect);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {                
                String maPT= rs.getString(MAPT);
                String MaKH= rs.getString(MAKH);
                String maSP= rs.getString(MASP);
                String maHD= rs.getString(MAHD);
                int sl= rs.getInt(SL);
                Date ngayBan= rs.getDate(NGAYBAN);
                double thanhTien= rs.getDouble(THANHTIEN);
                list.add(new PhuThu(maPT,MaKH,maHD,maSP,sl,ngayBan,thanhTien));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Optional<PhuThu> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<PhuThu> get(String id) {
        PhuThu phuThu = new PhuThu();
        try {
            String querySelect="Select maphuthu,makh,mahd,masp,soluongphuthu,"
                    + "ngayban, thanhtien from "+TABLE_NAME
                    +" where "+MAPT+"=?";
            
            PreparedStatement ps = conn.prepareStatement(querySelect);
            ps.setString(1, id);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                phuThu.setMaPT(rs.getString(MAPT));
                phuThu.setMaKH(rs.getString(MAKH));
                phuThu.setMaSP(rs.getString(MASP));
                phuThu.setNgayBan(rs.getDate(NGAYBAN));
                phuThu.setMaHD(rs.getString(MAHD));
                phuThu.setSoLuong(rs.getInt(SL));
                phuThu.setThanhTien(rs.getDouble(THANHTIEN));

            }
        } catch (Exception e) {
        }
        return Optional.of(phuThu);  
    }
    public String findNameKH(PhuThu t) throws SQLException
    {
        String name="";
        String queryFindName= "Select tenkh from khachhang "
                + "  where makh='"+t.getMaKH()+"'";
            PreparedStatement ps = conn.prepareStatement(queryFindName);
           
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 name=rs.getString("tenkh");
            }
            
        return name;
        
    }
    @Override
    public int insert(PhuThu t) {
        try {
            String queryInsert= "Insert into "+TABLE_NAME+" values(?,?,?,?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(queryInsert);
            
            ps.setString(1, t.getMaPT());
            ps.setString(2, t.getMaKH());
            ps.setString(3, t.getMaHD());
            ps.setString(4, t.getMaSP());
            ps.setInt(5, t.getSoLuong());
            ps.setTimestamp(6, (Timestamp) t.getNgayBan());
            ps.setDouble(7, t.getThanhTien());
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
    public int update(PhuThu t) {
        try {
            String queryUpdate= "update "+TABLE_NAME+" set mahd='"+t.getMaHD()+"', MaKh='"+t.getMaKH()+"',MaSP='"+
                    t.getMaSP()+"',Soluongphuthu="+t.getSoLuong()+",NgayBan='"+t.getNgayBan()+
                    "',ThanhTien="+t.getThanhTien()+" where "+MAPT+"='"+t.getMaPT()+"'";
            System.out.println(queryUpdate);
            PreparedStatement ps= conn.prepareStatement(queryUpdate);           
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
    public int delete(PhuThu t) {
        try {
            String queryUpdate= "delete from "+TABLE_NAME+" where "+MAPT+"=?";
            PreparedStatement ps= conn.prepareStatement(queryUpdate);
            ps.setString(1, t.getMaPT());
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
    public List<PhuThu> find(PhuThu t) {
        List<PhuThu> list = new ArrayList<>();
        try {
            String querySelect="Select maphuthu,makh,mahd,masp,soluongphuthu,"
                    + "DATE_FORMAT(ngayban, \"%Y-%m-%d\") AS 'ngayban', thanhtien from "+TABLE_NAME
                    +" where maphuthu like'%"+t.getMaPT()+"%' or makh like '%"+t.getMaKH()+"%' or masp like '%"+t.getMaSP()+"%'";
            
            PreparedStatement ps= conn.prepareStatement(querySelect);
            System.out.println(querySelect);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {                
                String maPT= rs.getString(MAPT);
                String MaKH= rs.getString(MAKH);
                String Mahd=rs.getString(MAHD);
                String maSP= rs.getString(MASP);
                int sl= rs.getInt(SL);
                Date ngayBan= rs.getDate(NGAYBAN);
                double thanhTien= rs.getDouble(THANHTIEN);
                list.add(new PhuThu(maPT,MaKH,Mahd,maSP,sl,ngayBan,thanhTien));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<PhuThu> findHD_PT(PhuThu t)
    {
        List<PhuThu> list = new ArrayList<>();
        try {
            String querySelect="Select maphuthu,makh,masp,soluongphuthu,"
                    + "DATE_FORMAT(ngayban, \"%Y-%m-%d\") AS 'ngayban', thanhtien from "+TABLE_NAME
                    +" where maphuthu like'%"+t.getMaPT()+"%' or makh like '%"+t.getMaKH()+"%' or masp like '%"+t.getMaSP()+"%'";
            
            PreparedStatement ps= conn.prepareStatement(querySelect);
            System.out.println(querySelect);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {                
                String maPT= rs.getString(MAPT);
                String MaKH= rs.getString(MAKH);
                String maSP= rs.getString(MASP);
                int sl= rs.getInt(SL);
                Date ngayBan= rs.getDate(NGAYBAN);
                String MaHD=rs.getString(MAHD);
                double thanhTien= rs.getDouble(THANHTIEN);
                list.add(new PhuThu(maPT,MaKH,MaHD,maSP,sl,ngayBan,thanhTien));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<HoaDon> findMaHD_byMaKH(String maKH)
    {
        List<HoaDon> list = new ArrayList<>();
        try {
            String querySelect="select MaHD from hoadon where MaKH='"+maKH+"' and trangthai=0";
            PreparedStatement ps= conn.prepareStatement(querySelect);
            System.out.println(querySelect);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {                
                String maHD= rs.getString("mahd");
                
                list.add(new HoaDon(maHD));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
        
    }
    public List<PhuThu> findPT_onHD(String maHD)
    {
        List<PhuThu> list = new ArrayList<>();
        try {
            String querySelect="SELECT pt.* FROM `phuthu` pt INNER join hoadon hd on pt.MaHD=hd.MaHD where pt.MaHD='"+maHD+"'";
            PreparedStatement ps= conn.prepareStatement(querySelect);
            System.out.println(querySelect);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {                
                String maPT= rs.getString(MAPT);
                String MaKH= rs.getString(MAKH);
                String maSP= rs.getString(MASP);
                String maHDPT= rs.getString(MAHD);
                int sl= rs.getInt(SL);
                Date ngayBan= rs.getDate(NGAYBAN);
                double thanhTien= rs.getDouble(THANHTIEN);
                list.add(new PhuThu(maPT,MaKH,maHDPT,maSP,sl,ngayBan,thanhTien));
                
                //list.add(new HoaDon(maHD));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     public static void main(String[] args) throws SQLException {
        PhuThuDao a= new PhuThuDao();
        String b="1";
         System.out.println("");
        
         
    }

    @Override
    public int delete(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PhuThu> find(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PhuThu> getList() {
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
    public List<PhuThu> find(String data, String colName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}