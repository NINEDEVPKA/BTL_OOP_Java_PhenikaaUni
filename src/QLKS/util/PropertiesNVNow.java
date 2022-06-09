/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tan_Tan_Chin
 */
public class PropertiesNVNow {
    //Thêm 1 tai khoan cần Nv_Now
    public void addRemember(String ma, String chucvu,String ten){
        OutputStream outputStream = null;
        //khai bao properties
        Properties prop = new Properties();
        try {
            //mơ file properties
            outputStream = new FileOutputStream("resources/Nv_Now.properties");
            //Cai dat gia trị cua properties: tên, gia trị
            prop.setProperty("MaNV", ma);
            prop.setProperty("Chucvu", chucvu);
            prop.setProperty("hoten", ten);
            //Luu vao file properties: luồng, ghi chú
            prop.store(outputStream, "Nhân viên hiện tại");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //dong luông
                outputStream.close();
            } catch (IOException ex) {
                //tạo và nắm bắt các thông báo và file nhật ký thông qua trình ghi nhật ký(Logging).
                Logger.getLogger(PropertiesNVNow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //xoa 1 tai khoan đã tưng Nv_Now
    public void removeRemember(){
        OutputStream outputStream = null;
        Properties prop = new Properties();
        try {
            outputStream = new FileOutputStream("resources/Nv_Now.properties");
            prop.remove("MaNV");
            prop.remove("Chucvu");
            prop.remove("hoten");       
            prop.store(outputStream, "Nhân viên hiện tại");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //dong luông
                outputStream.close();
            } catch (IOException ex) {
                //tạo và nắm bắt các thông báo và file nhật ký thông qua trình ghi nhật ký(Logging).
                Logger.getLogger(PropertiesNVNow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Lây tai khoan trong file properties nêu co tk đa Nv_Now
    public List<String> getRemember(){
        List<String> userPass = new ArrayList<>();
        //Vi lây ra nên dung inputstream ma không phai outputsteam nua
        InputStream inputStream = null;
        Properties prop = new Properties();
        try {
            inputStream = new FileInputStream("resources/Nv_Now.properties");
            prop.load(inputStream);
            if (prop.getProperty("MaNV")!=null) {
                userPass.add(prop.getProperty("MaNV"));
            }
            if (prop.getProperty("Chucvu")!=null) {
                userPass.add(prop.getProperty("Chucvu"));
            }
            if (prop.getProperty("hoten")!=null) {
                userPass.add(prop.getProperty("hoten"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //dong luông
                inputStream.close();
            } catch (IOException ex) {
                //tạo và nắm bắt các thông báo và file nhật ký thông qua trình ghi nhật ký(Logging).
                Logger.getLogger(PropertiesNVNow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return userPass;
    }
    public static void main(String[] args) {
        PropertiesNVNow propertiesUtil = new PropertiesNVNow();
        //propertiesUtil.removeRemember();
        System.out.println(propertiesUtil.getRemember().size());
        for (String s : propertiesUtil.getRemember()) {
            System.out.println(s);
        }
    }
}
