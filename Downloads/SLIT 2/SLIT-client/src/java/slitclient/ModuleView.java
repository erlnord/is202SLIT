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
    JPanel topLeftPanel = new JPanel();
    JPanel centerLeftPanel = new JPanel();
    JPanel bottomLeftPanel = new JPanel();
    JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane rightsp = new JSplitPane (JSplitPane.VERTICAL_SPLIT);
    
    JSplitPane spTop = new JSplitPane (JSplitPane.VERTICAL_SPLIT);
    JSplitPane spContainer = new JSplitPane();
    JSplitPane spCenter = new JSplitPane (JSplitPane.VERTICAL_SPLIT);
    JSplitPane spBottom = new JSplitPane (JSplitPane.VERTICAL_SPLIT);
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
    spTop.setResizeWeight(0.33);
    sp.setDividerSize(0);
    
    spTop.add(topLeftPanel);
    spTop.add(spContainer);
    
    frame.add(sp,BorderLayout.CENTER);
    frame.add(spTop, BorderLayout.CENTER);
    frame.add(spContainer);
    
    spContainer.setResizeWeight(0.5);
    spContainer.setDividerSize(0);
    spContainer.add(centerLeftPanel);
    spContainer.add(bottomLeftPanel);
    
    centerLeftPanel.setBackground(Color.red);
    
    
    sp.add(leftPanel);
    sp.add(rightPanel);
    spTop.add(topLeftPanel);
    
    spCenter.add(centerLeftPanel);
    spBottom.add(bottomLeftPanel);
    spContainer.add(centerLeftPanel);
    spContainer.add(bottomLeftPanel);

    leftPanel.setBackground(Color.white);
    rightPanel.setBackground(Color.black);
    
    spTop.add(textArea1);

    
}
    
}
