/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Erlend
 */
public class Mail extends ButtonMenu {
    JFrame mailFrame;
    
    
    JLabel fromLabel1;
    JLabel fromLabel2;
    JLabel fromLabel3;
    JLabel fromLabel4;
    JLabel fromLabel5;
    JLabel fromLabel6;
    JLabel fromLabel7;
    JLabel fromLabel8;
    JLabel fromLabel9;
    JLabel fromLabel10;
    JLabel fromLabel11;
    JLabel fromLabel12;
    
    JLabel thumb1;
    JLabel thumb2;
    JLabel thumb3;
    JLabel thumb4;
    JLabel thumb5;
    JLabel thumb6;
    JLabel thumb7;
    JLabel thumb8;
    JLabel thumb9;
    JLabel thumb10;
    JLabel thumb11;
    JLabel thumb12; 
    
    JTextArea newMail;
    
    
    JButton sendButton;
    JButton cancelButton;
    JPanel lPane;
    JPanel rightPanel; 
    
    public Mail() {
        mailFrame = new JFrame("Mail");
        mailFrame.setVisible(true);
        mailFrame.setSize(1024, 768);
        mailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mailFrame.setLocationRelativeTo(null);
        mailFrame.add(menuBar);
        mailFrame.setJMenuBar(menuBar);
        mailFrame.add(topPanel, BorderLayout.NORTH);
        lPane = new JPanel();
        lPane.setLayout(new GridLayout(2, 12));
        lPane.setBackground(Color.WHITE);
        
        fromLabel1 = new JLabel("Melding fra:");
        fromLabel2 = new JLabel("Even");
        fromLabel3 = new JLabel("Hallgeir");
        fromLabel4 = new JLabel("Oddvar");
        fromLabel5 = new JLabel("Geir");
        fromLabel6 = new JLabel("Hans");
        fromLabel7 = new JLabel("Nils");
        fromLabel8 = new JLabel("Sander");
        fromLabel9 = new JLabel("Andrine");
        fromLabel10 = new JLabel("Katrine");
        fromLabel11 = new JLabel("Anders");
        fromLabel12 = new JLabel("Sindre");
        
        thumb1 = new JLabel("Tittel:");
        thumb2 = new JLabel("Hei! Jeg er en testmelding. testestestest");
        thumb3 = new JLabel("Hei! Jeg er en testmelding. testestestest");
        thumb4 = new JLabel("Hei! Jeg er en testmelding. testestestest");
        thumb5 = new JLabel("Hei! Jeg er en testmelding. testestestest");
        thumb6 = new JLabel("Hei! Jeg er en testmelding. testestestest");
        thumb7 = new JLabel("Hei! Jeg er en testmelding. testestestest");
        thumb8 = new JLabel("Hei! Jeg er en testmelding. testestestest");
        thumb9 = new JLabel("Hei! Jeg er en testmelding. testestestest");
        thumb10 = new JLabel("Hei! Jeg er en testmelding. testestestest");
        thumb11 = new JLabel("Hei! Jeg er en testmelding. testestestest");
        thumb12 = new JLabel("Hei! Jeg er en testmelding. testestestest");
        
        
        
        
        
        //lPane.setLayout(new FlowLayout());
        
        lPane.add(fromLabel1);
        lPane.add(thumb1);
        lPane.add(fromLabel2);
        lPane.add(thumb2);
        lPane.add(fromLabel3);
        lPane.add(thumb3);
        lPane.add(fromLabel4);
        lPane.add(thumb4);
        lPane.add(fromLabel5);
        lPane.add(thumb5);
        lPane.add(fromLabel6);
        lPane.add(thumb6);
        lPane.add(fromLabel7);
        lPane.add(thumb7);
        lPane.add(fromLabel8);
        lPane.add(thumb8);
        lPane.add(fromLabel9);
        lPane.add(thumb9);
        lPane.add(fromLabel10);
        lPane.add(thumb10);
        lPane.add(fromLabel11);
        lPane.add(thumb11);
        lPane.add(fromLabel12);
        lPane.add(thumb12);
        
        lPane.validate();
        lPane.repaint();
        
        mailFrame.add(lPane, BorderLayout.CENTER);
        
        mailFrame.validate();
        mailFrame.repaint(); 
    }   
    
    
    
}
