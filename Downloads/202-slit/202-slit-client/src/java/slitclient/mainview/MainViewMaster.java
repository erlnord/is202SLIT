
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.mainview;

import beans.InformationTransfer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import slitclient.ButtonMenu;
import slitclient.Main;

/**
 *
 * @author Lars Martin
 */
public abstract class MainViewMaster extends ButtonMenu {
    
    // Lager en JFrame som vi kan plassere alle elementene i
    JFrame frame = new JFrame();
    
    // Lager tre JPanels som blir brukt til Ã¥ plassere innhold
    //JPanel topPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    // lager en container som inneholder right og leftpanel
    JPanel container = new JPanel();
    
    JTextArea leftPane1 = new JTextArea();
    //JTextPane leftPane2 = new JTextPane();
    //JTextPane leftPane3 = new JTextPane();
    //JTextPane leftPane4 = new JTextPane();
    //JTextPane leftPane5 = new JTextPane();
    //JTextPane leftPane6 = new JTextPane();
    //JTextPane leftPane7 = new JTextPane();
    
    JScrollPane scroll1 = new JScrollPane(leftPane1);
    //JScrollPane scroll2 = new JScrollPane(leftPane2);
    //JScrollPane scroll3 = new JScrollPane(leftPane3);
    //JScrollPane scroll4 = new JScrollPane(leftPane4);
    //JScrollPane scroll5 = new JScrollPane(leftPane5);
    //JScrollPane scroll6 = new JScrollPane(leftPane6);
    //ScrollPane scroll7 = new JScrollPane(leftPane7);
    
    JTextArea area1 = new JTextArea();
    
    // Lager tekstfeltet der lÃ¦rerene kan legge ut nyheter
    //JTextArea infoTxt = new JTextArea();
    //JScrollPane infoScroll = new JScrollPane(infoTxt);
    
    /**
     * Konstruktor for klassen MainViewMaster.
     * Planen var egentlig at informasjon skulle fylles inn i alle textfeltene
     * som ble opprettet, men vi fant ingen måte å legge til i neste tekstfelt
     * hvis et allerede hadde tekst i seg. Derfor ble det endret til at all 
     * informasjon blir lagt til i et enkelt tekstfelt.
     */
    public MainViewMaster() {
        //Legger til alle elementene i JFrame
        frame.add(menuBar);
        frame.setJMenuBar(menuBar);
        //frame.setLayout(new GridLayout(5, 5, 10, 10));
        
        // Legger til topPanel i JFrame
        // topPanel er panelet med knappene
        // Må alltid legges til på NORTH
        frame.add(topPanel, BorderLayout.NORTH);
        topPanel.setBackground(Color.white);
        
        frame.add(leftPanel, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);
        
        // Initialiserer left JPanel
        leftPanel.setLayout(new GridLayout(1,1));
        //lager border rundt hele leftpanel med overskrif
        leftPanel.setBorder(BorderFactory.createTitledBorder("Informasjon"));
        
        Dimension d1 = new Dimension(400,0);
        //rightPanel.setPreferredSize(d1);
        rightPanel.setMinimumSize(d1);
        
        //leftPane1.setBackground(Color.decode("#f0f0f0"));
        //leftPane2.setBackground(Color.white);
        //leftPane3.setBackground(Color.decode("#f0f0f0"));
        //leftPane4.setBackground(Color.white);
        //leftPane5.setBackground(Color.decode("#f0f0f0"));
        //leftPane6.setBackground(Color.white);
        //leftPane7.setBackground(Color.decode("#f0f0f0"));
        
        leftPanel.add(scroll1);
        //leftPanel.add(scroll2);
        //leftPanel.add(scroll3);
        //leftPanel.add(scroll4);
        //leftPanel.add(scroll5);
        //leftPanel.add(scroll6);
        //leftPanel.add(scroll7);
        
        leftPane1.setMargin( new Insets(2,7,2,2));
        //leftPane2.setMargin( new Insets(2,7,2,2));
        //leftPane3.setMargin( new Insets(2,7,2,2));
        //leftPane4.setMargin( new Insets(2,7,2,2));
        //leftPane5.setMargin( new Insets(2,7,2,2));
        //leftPane6.setMargin( new Insets(2,7,2,2));
        //leftPane7.setMargin( new Insets(2,7,2,2));
        
        leftPane1.setBackground(Color.white);
        
        leftPane1.setLineWrap(true);
        leftPane1.setWrapStyleWord(true);
        leftPane1.setCaretPosition(0);
        leftPane1.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 16));
        
        // Søker gjennom alle Informations i databasen og printer det ut til 
        // forsiden/infosiden. Viser nyeste info først.
        for (InformationTransfer u : Main.getInformationBean().findAllInformation()) {
            //leftPane1.append(u.getInfoText()+ "\n" + u.getInfoDate() + "\n"+"\n");
            leftPane1.append(u.getInfoText() + "\n" + u.getInfoDate() + "\n\n");
        }
        
        
        leftPane1.setEditable(false);
        //leftPane2.setEditable(false);
        //leftPane3.setEditable(false);
        //leftPane4.setEditable(false);
        //leftPane5.setEditable(false);
        //leftPane6.setEditable(false);
        //leftPane7.setEditable(false);
        
        //lager border rundt hele rightpanel med overskrift
        Dimension d2 = new Dimension(350,frame.getHeight());
        rightPanel.setPreferredSize(d2);
        rightPanel.setBorder(BorderFactory.createTitledBorder("Forelesning"));
        rightPanel.setLayout(new GridLayout(1,1));
        
        rightPanel.add(area1);
        
        area1.setLineWrap(true);
        area1.setWrapStyleWord(true);
        area1.setEditable(false);
        area1.setFont(new Font("Calibri", Font.HANGING_BASELINE, 16));
        area1.setText("Neste forelesning: " + "\nIS-109 - Onsdag 18. November "
                + "- Kl: 13:15" + "\n\n\nIS-109 - Onsdag 27. November - Kl: "
                + "13:15" + "\n\n\nIS-109 - Onsdag 1. Desember - Kl: 10:15");
        
        frame.pack();
        
        
    }
}