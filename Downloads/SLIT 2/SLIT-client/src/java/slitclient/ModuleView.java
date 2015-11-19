/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Atilla
 */
public class ModuleView extends ButtonMenu {
    
    JTextArea textArea1 = new JTextArea();
    JTextArea textArea2 = new JTextArea();
    JTextArea textArea3 = new JTextArea();
    JTextArea textArea4 = new JTextArea();
    
    JPanel leftPanel = new JPanel();
    JPanel leftTopPanel = new JPanel();
    JPanel leftCenterPanel = new JPanel();
    JPanel leftBottomPanel = new JPanel();
    
    JPanel rightPanel = new JPanel();
    
    JPanel rightTopPanel = new JPanel ();
    JPanel rightBottomPanel = new JPanel();
    
    JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane rightsp = new JSplitPane (JSplitPane.VERTICAL_SPLIT);
    
    JSplitPane rightPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    
    JSplitPane leftTopPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    JSplitPane leftCenterPane = new JSplitPane (JSplitPane.VERTICAL_SPLIT);
    JSplitPane leftBottomPane = new JSplitPane (JSplitPane.VERTICAL_SPLIT);
     
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
  
    sp.setResizeWeight(0.7);      
    leftTopPane.setResizeWeight(0.3);
    sp.setDividerSize(1);
    
    frame.add(sp,BorderLayout.CENTER);
    sp.add(leftTopPane);
    sp.add(rightsp);
    sp.setBackground(Color.white);
    
    rightsp.add(rightTopPanel);
    rightsp.add(rightBottomPanel);
    rightsp.setResizeWeight(0.5);
    rightsp.setDividerSize(1);
    rightsp.setBackground(Color.white);
    
    rightBottomPanel.setLayout(new BorderLayout());
    rightTopPanel.setBackground(Color.white);
    rightBottomPanel.setBackground(Color.white);
    
    rightTopPanel.setLayout(new GridLayout(2, 2));
    rightTopPanel.add(textArea4);
    textArea4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#f0f0f0")));
   
 
    leftTopPane.setResizeWeight(0.3);
    leftTopPane.add(leftTopPanel);
    leftTopPane.add(leftBottomPane);
    leftTopPane.setDividerSize(1);
    leftTopPane.setBackground(Color.white);
    
    leftBottomPane.setResizeWeight(0.5);
    leftBottomPane.add(leftCenterPanel);
    leftBottomPane.add(leftBottomPanel);
    leftBottomPane.setDividerSize(1);
    leftBottomPane.setBackground(Color.white);
 
    
    leftTopPanel.setLayout(new BorderLayout());
    leftCenterPanel.setLayout(new BorderLayout());
    leftBottomPanel.setLayout(new BorderLayout());
    
    leftTopPanel.add(textArea1);
    leftCenterPanel.add(textArea2);
    leftBottomPanel.add(textArea3);
    
    
    }
    
}
