/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author Erlend
 */
public class StudentMainView extends JFrame {
    
    JPanel panel1 = new JPanel();
    JLabel label1 = new JLabel("Hei");
    JLabel label2 = new JLabel("Hei igjen");
    
    public StudentMainView() {
        super("test");
        super.add(panel1);
        //super.setLayout(new BorderLayout());
        
        panel1.add(label1);
        panel1.add(label2);
    }
    
    
}
