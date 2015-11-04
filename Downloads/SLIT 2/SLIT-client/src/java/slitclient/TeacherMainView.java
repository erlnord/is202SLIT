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
public class TeacherMainView extends MainViewMaster {
    
    public TeacherMainView() {
        // Lærere skal kunne endre på tekstfeltet
        super.infoTxt.setEditable(true);
}
          
}