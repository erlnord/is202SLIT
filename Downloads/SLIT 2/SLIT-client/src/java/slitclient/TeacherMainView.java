/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author Erlend
 */
public class TeacherMainView extends MainViewMaster{
    
    JFrame frame = new JFrame("Teacher");
    JPanel panel1 = new JPanel();
    JLabel label1 = new JLabel("Lærer");
    JLabel label2 = new JLabel("Lærererer");
    
    public TeacherMainView() {
        frame.add(panel1);
        frame.setLayout(new FlowLayout());
        
        panel1.add(label1);
        panel1.add(label2);
        
    }
}