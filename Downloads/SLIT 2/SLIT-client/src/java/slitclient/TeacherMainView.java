/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import javax.swing.JButton;

/**
 *
 * @author Erlend
 */
public class TeacherMainView extends MainViewMaster {
    
    public TeacherMainView() {
        JButton btnNewInfo = new JButton();
        
        frame.add(btnNewInfo, BorderLayout.SOUTH);
    }
          
}