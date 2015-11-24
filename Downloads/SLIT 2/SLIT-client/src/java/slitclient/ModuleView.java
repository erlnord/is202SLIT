/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Atilla
 */
public class ModuleView extends ButtonMenu {
    
    
    
    JTextArea textArea1 = new JTextArea();
    

    //JScrollPane scrollPane = new JScrollPane();
    
    public ModuleView () {
    
    JFrame frame = new JFrame("Modules");
    frame.add(topPanel, BorderLayout.NORTH);
    topPanel.setBackground(Color.white);
    frame.add(menuBar);
    frame.setJMenuBar(menuBar);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1024, 768);
  
   
    JPanel panel1 = new JPanel(new GridBagLayout());
    frame.add(panel1);
    
    GridBagConstraints c1 = new GridBagConstraints();
    textArea1 = new JTextArea(1, 30);
    
    c1.gridx = (int) 1.0;
    c1.gridy = 5;
    c1.gridwidth = 2 ;  
    c1.weightx = 1;
    c1.weighty = 5;
    c1.anchor = GridBagConstraints.NORTHWEST;
    textArea1.setBackground(Color.LIGHT_GRAY);
    c1.anchor = GridBagConstraints.FIRST_LINE_START;
    panel1.add(textArea1, c1);
    
    //JScrollPane scrollPane1 = new JSPane(textArea1);
    // panel1.add(scrollPane1);
    //scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    //scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }
    
}