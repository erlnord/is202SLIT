/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.mainview;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Lars Martin
 */
public class StudentMainView extends MainViewMaster {
    
    public StudentMainView() {
        frame.setVisible(true);
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);
    }
    
    
}
