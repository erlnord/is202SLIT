/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

/**
 *
 * @author Atilla
 */
public class ModuleView extends ButtonMenu {
    
    JTextArea textArea1 = new JTextArea();
    JTextArea textArea2 = new JTextArea();
    JTextArea textArea3 = new JTextArea();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane rightsp = new JSplitPane (JSplitPane.VERTICAL_SPLIT);
    
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
    
    sp.setResizeWeight(0.5);
    sp.setDividerSize(0);
        
    frame.add(sp,BorderLayout.CENTER);    
    
    sp.add(leftPanel);
    sp.add(rightPanel);
    leftPanel.setBackground(Color.white);
    rightPanel.setBackground(Color.black);
    
    }
    
}
