/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.module;

import beans.ModuleTransfer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import slitclient.ButtonMenu;
import slitclient.Main;

/**
 *
 * @author Atilla
 */
public class ModuleViewTeacher extends ButtonMenu {
    
    public ModuleViewTeacher () {
        
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
    panel1.setBorder(BorderFactory.createTitledBorder("Modul "+Main.getModuleType()));//lager border rundt hele panel1 med overskrift
    panel1.setPreferredSize(new Dimension(frame.getWidth()/2 - 10, frame.getHeight()/2 - 10)); // setter dimensjoner p� det respektive panelet slik at det er halve skjermbredden
    
    JPanel panel1_1 = new JPanel();
    JPanel panel1_2 = new JPanel();
    JPanel panel1_3 = new JPanel();
    
    JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
    JPanel bottomLeft = new JPanel(new FlowLayout(LEFT));
    JPanel bottomRight = new JPanel (new FlowLayout(LEFT));
    JButton btnLagreLeft = new JButton("Lagre");     
    JButton btnLagreRight = new JButton("Lagre");
    JCheckBox godkjent = new JCheckBox ("Godkjent");
    JCheckBox ikkeGodkjent = new JCheckBox("Ikke godkjent");
    
    frame.add(bottomPanel, BorderLayout.SOUTH);
    bottomPanel.setBackground(Color.white);
    bottomPanel.add(bottomLeft);
    bottomPanel.add(bottomRight);
    bottomLeft.add(btnLagreLeft);
    bottomRight.add(btnLagreRight);
    bottomRight.add(godkjent);
    bottomRight.add(ikkeGodkjent);
    
    godkjent.setMnemonic(KeyEvent.VK_C);
    ikkeGodkjent.setMnemonic(KeyEvent.VK_C); 
    
    panel1_1.setBorder(BorderFactory.createTitledBorder("Info"));
    panel1_2.setBorder(BorderFactory.createTitledBorder("Ressurser"));
    panel1_3.setBorder(BorderFactory.createTitledBorder("Godkjenning/læringsmål"));
    
    
    JTextArea textArea1 = new JTextArea();
    JTextArea textArea2 = new JTextArea();
    JTextArea textArea3 = new JTextArea();    
    
    //bruker gridlayout p� panelene inni hovedpanelet
    panel1_1.setLayout(new GridLayout(1, 1));
    panel1_2.setLayout(new GridLayout(1, 1));
    panel1_3.setLayout(new GridLayout(1, 1));
    textArea1.setEditable(true);
    textArea2.setEditable(true);
    textArea3.setEditable(true);
    
    textArea1.setLineWrap(true);
    textArea1.setWrapStyleWord(true);
    textArea2.setLineWrap(true);
    textArea2.setWrapStyleWord(true);
    textArea3.setLineWrap(true);
    textArea3.setWrapStyleWord(true);
    
    //legger til textfelt i underpanelene
    
    JScrollPane scroll1 = new JScrollPane(textArea1);
    JScrollPane scroll2 = new JScrollPane(textArea2);
    JScrollPane scroll3 = new JScrollPane(textArea3);
    
    panel1_1.add(scroll1);
    panel1_2.add(scroll2);
    panel1_3.add(scroll3);
    
    ModuleTransfer mf = Main.getModuleBean().findModule(Main.getModuleType());
    textArea1.setText(mf.getModuleDescription());
    textArea2.setText(mf.getModuleResource());
    textArea3.setText(mf.getModuleApproval());
    
    textArea1.setCaretPosition(0);
    textArea2.setCaretPosition(0);
    textArea3.setCaretPosition(0);
    
    // Legg panelene til i hovedpanel.
    panel1.add(panel1_1);
    panel1.add(panel1_2);
    panel1.add(panel1_3);
    
    
    btnLagreLeft.addActionListener((ActionEvent e) -> {
          Main.getModuleBean().updateModule(Main.getModuleType(), textArea1.getText(), 
                  textArea3.getText(), textArea2.getText(), 4);
          JOptionPane.showMessageDialog(null, "Modultekst oppdatert.");
    });
    
    
    // Panel 2 - Godkjenning
    
    JPanel panel2 = new JPanel();
    panel2.setLayout(new GridLayout(2, 1));
    panel2.setBorder(BorderFactory.createTitledBorder("Godkjenning"));//lager border rundt hele panel1 med overskrift
    panel2.setPreferredSize(new Dimension(frame.getWidth()/2 - 10, frame.getHeight()/2 - 10)); // setter dimensjoner p� det respektive panelet 
    
    JPanel upperPanel = new JPanel();
    JPanel lowerPanel = new JPanel();
    ListModel model = new DefaultListModel();
    JList navneListe = new JList(model);   
    JScrollPane scrollPane = new JScrollPane(navneListe);
    
    upperPanel.setLayout(new GridLayout(1, 1));
    upperPanel.setBorder(BorderFactory.createTitledBorder("Studenter"));

    String	listData[] =
		{
			"Admir Begovic",
			"Tor Hakli",
			"Erlend Nord",
			"Lars Martin Risdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal",
                        "Atilla Sjusdal"                      
		};

		
//navneListe.setPreferredSize(new Dimension(frame.getWidth() - 40, frame.getHeight()- 40));		
    navneListe = new JList( listData );
		scrollPane.setVisible(true);
                
                upperPanel.add(new JScrollPane(navneListe));
    

    lowerPanel.setLayout(new FlowLayout());
    lowerPanel.setBorder(BorderFactory.createTitledBorder("KOMMENTAR"));

    JTextArea kommentarTf = new JTextArea();
    kommentarTf.setPreferredSize(new Dimension(frame.getWidth()/2 - 30, frame.getHeight() - 20));
    lowerPanel.add(kommentarTf); //legger til kommentarfeltet i lowerpanel
    
    
    kommentarTf.setLineWrap(true);
    kommentarTf.setWrapStyleWord(true);
    kommentarTf.setEditable(true);
    

    panel2.add(upperPanel); //legger til upperpanel i panel2
    panel2.add(lowerPanel); //legger til lowerpanel i panel2
    
    // Legg til paneler i hovedframen
    frame.add(panel1, BorderLayout.WEST);  
    frame.add(panel2, BorderLayout.EAST);
    
    frame.setLocationRelativeTo(null);
   // frame.pack(); 
    
    }
}
    
