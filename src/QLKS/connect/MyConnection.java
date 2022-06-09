/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.connect;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Tan_Tan_Chin 
 */
public class MyConnection {
    String hostName;
    String dbName;
    String userName;
    String password;
    String jdbc;
    String port;
    String className;
    String connectionURL;
    String instanceDB;
    private static MyConnection instance;
    private MyConnection(){
        try {
            //Đọc cac thaanh phan trong file properties
            InputStream inputStream = new FileInputStream("resources/db.properties");
            Properties prop = new Properties();
            prop.load(inputStream);
            
            hostName = prop.getProperty("hostName");
            dbName = prop.getProperty("dbName");
            userName = prop.getProperty("userName");
            password = prop.getProperty("password");
            jdbc = prop.getProperty("jdbc");
            port = prop.getProperty("port");
            className = prop.getProperty("className");
            connectionURL = jdbc + hostName + port + dbName;
        } catch (Exception e) {
           // e.printStackTrace();
        }
    }
    public static MyConnection getInstance(){
        if (instance == null) {
            instance = new MyConnection();
        }
        return instance;
    }
    public Connection getConnection(){
        Connection conn = null;
        try {
            //Khai báo driver->mysql
            Class.forName(className);
            conn = DriverManager.getConnection(connectionURL, userName, password);
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args) {
        Connection conn = MyConnection.getInstance().getConnection();
        if (conn != null) {
            System.out.println("ok");
        } else {
            System.out.println("not ok");
        }
    }
}
