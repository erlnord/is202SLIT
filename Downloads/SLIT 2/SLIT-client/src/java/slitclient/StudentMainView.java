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
public class StudentMainView extends MainViewMaster {
    
    public StudentMainView() {
        // Elever skal ikke kunne endre på tekstfeltet.
        super.infoTxt.setEditable(false);
    }
    
    
}
