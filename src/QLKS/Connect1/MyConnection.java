/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.Connect1;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author ADMIN
 */
public class MyConnection {
    String hostName="localhost";
        String dbName="qlks";
        String userName="root";
        String passWord="2002";
        String connectionURL="jdbc:mysql://"+hostName+":3306/"+dbName;
    private static MyConnection instant;

    private  MyConnection() {
    }
    public  static MyConnection getInstance()
    {
        if(instant==null)
        {
             instant = new MyConnection();
        }
        return instant;
    }
    public Connection getConnection()
    {
        Connection conn=null;
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             conn=DriverManager.getConnection(connectionURL, userName, passWord);
        }
        catch(Exception e)
        {
            
        }
        
        return conn;
    }
    public static void main(String[] args) {
        Connection conn=MyConnection.getInstance().getConnection();
        if(conn!=null)
        {
            System.out.println("Thành công");
        }
        else
        {
            System.out.println("Fail");
        }
    }
}
