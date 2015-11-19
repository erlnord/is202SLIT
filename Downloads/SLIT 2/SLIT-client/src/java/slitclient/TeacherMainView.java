/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Erlend
 */
public class TeacherMainView extends MainViewMaster {
    
    public TeacherMainView() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnNewInfo = new JButton("Ny info");
        
        frame.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setBackground(Color.white);
        bottomPanel.add(btnNewInfo);
        
    }  
}