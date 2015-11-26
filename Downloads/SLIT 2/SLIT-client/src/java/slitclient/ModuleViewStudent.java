/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Atilla
 */
public class ModuleViewStudent extends ButtonMenu {
    

 
    public ModuleViewStudent () {
    //legger til hovedframen
    JFrame frame = new JFrame("Module 1");
    frame.add(topPanel, BorderLayout.NORTH);
    topPanel.setBackground(Color.white);
    frame.add(menuBar);
    frame.setJMenuBar(menuBar);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1024, 768);
  
   
    // Panel 1
    JPanel panel1 = new JPanel();    
    panel1.setLayout(new GridLayout(3, 1));
    panel1.setBorder(BorderFactory.createTitledBorder("MODUL 1"));//lager border rundt hele panel1 med overskrift
    panel1.setPreferredSize(new Dimension(frame.getWidth()/2 - 10, frame.getHeight()/2 - 10)); // setter dimensjoner på det respektive panelet slik at det er halve skjermbredden
    
    JPanel panel1_1 = new JPanel();
    JPanel panel1_2 = new JPanel();
    JPanel panel1_3 = new JPanel();
    
    
    panel1_1.setBorder(BorderFactory.createTitledBorder("Info"));
    panel1_2.setBorder(BorderFactory.createTitledBorder("Ressurser"));
    panel1_3.setBorder(BorderFactory.createTitledBorder("Godkjenning/læringsmål"));
    
    
    JTextField textField1 = new JTextField(500);
    JTextField textField2 = new JTextField(500);
    JTextField textField3 = new JTextField(500);    
    
    //bruker gridlayout på panelene inni hovedpanelet
    panel1_1.setLayout(new GridLayout(1, 1));
    panel1_2.setLayout(new GridLayout(1, 1));
    panel1_3.setLayout(new GridLayout(1, 1));
    textField1.setEditable(false);
    textField2.setEditable(false);
    textField3.setEditable(false);
    
    //legger til textfelt i underpanelene
    panel1_1.add(textField1);
    panel1_2.add(textField2);
    panel1_3.add(textField3);
    
    // Legg panelene til i hovedpanel.
    panel1.add(panel1_1);
    panel1.add(panel1_2);
    panel1.add(panel1_3);
    
   
    
    
    
    
    
    
    
    
    // Panel 2 - OPPLASTING
    
    JPanel panel2 = new JPanel();
    panel2.setLayout(new FlowLayout());
    panel2.setBorder(BorderFactory.createTitledBorder("Opplasting"));//lager border rundt hele panel1 med overskrift
    panel2.setPreferredSize(new Dimension(frame.getWidth()/2 - 10, frame.getHeight()/2 - 10)); // setter dimensjoner på det respektive panelet 
    
    JPanel upperPanel = new JPanel();
    JPanel lowerPanel = new JPanel();
    JTextField uploadTf = new JTextField();
    JButton blaGjennom = new JButton();
    JButton lastOpp = new JButton();
    
    upperPanel.setLayout(new FlowLayout());
    upperPanel.setPreferredSize(new Dimension(frame.getWidth()/2 - 10 - 10, 100)); // setter dimensjoner på det respektive panelet
    upperPanel.setBorder(BorderFactory.createTitledBorder(""));
    
    lowerPanel.setLayout(new FlowLayout());
    lowerPanel.setPreferredSize(new Dimension(frame.getWidth()/2 - 10 - 10, 450)); // setter dimensjoner på det respektive panelet 
    lowerPanel.setBorder(BorderFactory.createTitledBorder("KOMMENTAR"));

    JTextArea kommentarTf = new JTextArea();
    lowerPanel.add(kommentarTf); //legger til kommentarfeltet i lowerpanel
    kommentarTf.setPreferredSize(new Dimension(frame.getWidth()/2 - 40, 410)); //setter kommentarboksens størrelse i forhold til bredden og høyden på framen og de andre komponentene, høyde etter komma
    
    uploadTf.setEditable(false);
    kommentarTf.setLineWrap(true);
    kommentarTf.setWrapStyleWord(true);
    kommentarTf.setEditable(false);
    
    blaGjennom.setPreferredSize(new Dimension(frame.getWidth()/2 - 40, 20)); //setter button størrelse i forhold til bredden og høyden på framen og de andre komponentene, høyde etter komma
    lastOpp.setPreferredSize(new Dimension(frame.getWidth()/2 - 40, 20)); //setter button størrelse i forhold til bredden og høyden på framen og de andre komponentene, høyde etter komma

    blaGjennom.setText("Bla gjennom");
    lastOpp.setText("Last opp!");
    
    
    upperPanel.add(blaGjennom); //legger til knappen i upperpanel
    JLabel path = new JLabel("Valgt Path:");
    upperPanel.add(path);
    
    JTextField pathField = new JTextField(200); 
    upperPanel.add(pathField);//legger til tekstfeltet i upperpanel
    upperPanel.add(lastOpp); //legger til last opp knappen i upperpanel
    
    panel2.add(upperPanel); //legger til upperpanel i panel2
    panel2.add(lowerPanel); //legger til lowerpanel i panel2
    
    // Legg til paneler i hovedframen
    frame.add(panel1, BorderLayout.WEST);  
    frame.add(panel2, BorderLayout.EAST);
    
    frame.setLocationRelativeTo(null);
   // frame.pack(); 
    
    }
    

    }
    
