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
public class PropertiesUtil {
    //Thêm 1 tai khoan cần remember
    public void addRemember(String userName, String password){
        OutputStream outputStream = null;
        //khai bao properties
        Properties prop = new Properties();
        try {
            //mơ file properties
            outputStream = new FileOutputStream("resources/remember.properties");
            //Cai dat gia trị cua properties: tên, gia trị
            prop.setProperty("userName", userName);
            prop.setProperty("password", password);
            //Luu vao file properties: luồng, ghi chú
            prop.store(outputStream, "Remember password");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //dong luông
                outputStream.close();
            } catch (IOException ex) {
                //tạo và nắm bắt các thông báo và file nhật ký thông qua trình ghi nhật ký(Logging).
                Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //xoa 1 tai khoan đã tưng remember
    public void removeRemember(){
        OutputStream outputStream = null;
        Properties prop = new Properties();
        try {
            outputStream = new FileOutputStream("resources/remember.properties");
            prop.remove("userName");
            prop.remove("password");            
            prop.store(outputStream, "Remove remember password");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //dong luông
                outputStream.close();
            } catch (IOException ex) {
                //tạo và nắm bắt các thông báo và file nhật ký thông qua trình ghi nhật ký(Logging).
                Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Lây tai khoan trong file properties nêu co tk đa remember
    public List<String> getRemember(){
        List<String> userPass = new ArrayList<>();
        //Vi lây ra nên dung inputstream ma không phai outputsteam nua
        InputStream inputStream = null;
        Properties prop = new Properties();
        try {
            inputStream = new FileInputStream("resources/remember.properties");
            prop.load(inputStream);
            if (prop.getProperty("userName")!=null) {
                userPass.add(prop.getProperty("userName"));
            }
            if (prop.getProperty("password")!=null) {
                userPass.add(prop.getProperty("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //dong luông
                inputStream.close();
            } catch (IOException ex) {
                //tạo và nắm bắt các thông báo và file nhật ký thông qua trình ghi nhật ký(Logging).
                Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return userPass;
    }
    public static void main(String[] args) {
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        propertiesUtil.addRemember("admin", "11");
        //propertiesUtil.removeRemember();
        System.out.println(propertiesUtil.getRemember().size());
        for (String s : propertiesUtil.getRemember()) {
            System.out.println(s);
        }
    }
}
