/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class connection {

public Connection creatConnection () throws ClassNotFoundException{
    
    Connection conn=null;

    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();//call driver
        String url = "jdbc:mysql://localhost/simple";//getting url
        conn = DriverManager.getConnection(url,"root","root");//create connection
    }

    catch (Exception e) {
        // JOptionPane.showMessageDialog(null,"Error occured!.."+ e.getLocalizedMessage());
        JOptionPane.showMessageDialog(null, e, "Example",JOptionPane.ERROR_MESSAGE, null);//exeption hanling
    }

    return conn;//return connection to all
    
    }

}