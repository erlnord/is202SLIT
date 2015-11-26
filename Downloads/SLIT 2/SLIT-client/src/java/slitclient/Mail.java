/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.CENTER;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

/**
 *
 * @author Erlend
 */
public class Mail extends ButtonMenu {
   JFrame mailFrame = new JFrame();
   JPanel container = new JPanel();
   JPanel p1 = new JPanel();
   JPanel p2 = new JPanel(); 
   
 

   JLabel fromLbl = new JLabel("Sender:");
   JLabel topicLbl = new JLabel("Emne:");
   
   JLabel fromLbl1 = new JLabel("Hallgeir");
   JLabel topicLbl1 = new JLabel("Hei. Møter er satt opp til tirsdag 20.11");
   
       
    public Mail() {
        mailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Setter layout på JFrame til FLowLayout
        p1.setBackground(Color.WHITE);
        p1.setBorder(BorderFactory.createTitledBorder("Innboks"));
        p2.setBackground(Color.WHITE);
        p2.setBorder(BorderFactory.createTitledBorder("Melding"));
        p1.setLayout(new GridLayout(0, 2));
        p2.setLayout(new GridLayout(0, 2)); 
        
        container.setLayout(new GridLayout(1, 2));
        
        
        mailFrame.setVisible(true);
        mailFrame.setSize(1024, 768);
        mailFrame.setLocationRelativeTo(null);
        
        // Legger til topPanel
        mailFrame.add(topPanel, BorderLayout.NORTH);
        topPanel.setBackground(Color.white);
        // Legger til menubar
        mailFrame.add(menuBar);
        mailFrame.setJMenuBar(menuBar);
        
        
        mailFrame.add(container);
        
        // PANEL 1
        
        

        
        
        fromLbl.setFont(new Font("Verdana", Font.CENTER_BASELINE, 16));
        fromLbl.setOpaque(true);
        fromLbl.setBackground(Color.GRAY);
        p1.add(fromLbl);
        
        topicLbl.setFont(new Font("Verdana", Font.CENTER_BASELINE, 16));
        topicLbl.setOpaque(true); 
        topicLbl.setBackground(Color.GRAY);
        p1.add(topicLbl);
        
        p1.add(fromLbl1);
        p1.add(topicLbl1);
        
        JButton button = new JButton("KLIKEKRINO");
        p2.add(button);
        JButton nuttton = new JButton("KILLLLKELRKLEKRLERKEL");
        p2.add(nuttton);
        
        //p2.add(fromLbl);
        
        container.add(p1);
        container.add(p2);
        //mailFrame.add(p3, BorderLayout.EAST);
        //mailFrame.pack();
        
        
        
        }
         
}

    
    

