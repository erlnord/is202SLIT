/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitv2client;

import beans.InformationTransfer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import slitv2client.ButtonMenu;



/**
 *
 * @author Erlend
 */
public abstract class MainViewMaster extends ButtonMenu {
    
    // Lager en JFrame som vi kan plassere alle elementene i
    JFrame frame = new JFrame();
    
    // Lager tre JPanels som blir brukt til Ã¥ plassere innhold
    //JPanel topPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel container = new JPanel();
    
    JTextPane leftPane1 = new JTextPane();
    JTextPane leftPane2 = new JTextPane();
    JTextPane leftPane3 = new JTextPane();
    JTextPane leftPane4 = new JTextPane();
    JTextPane leftPane5 = new JTextPane();
    JTextPane leftPane6 = new JTextPane();
    JTextPane leftPane7 = new JTextPane();
    
    JTextArea area1 = new JTextArea();
    
    // Lager tekstfeltet der lÃ¦rerene kan legge ut nyheter
    //JTextArea infoTxt = new JTextArea();
    //JScrollPane infoScroll = new JScrollPane(infoTxt);
 

    
    /**
     * Konstruktor for klassen MainViewMaster
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
        leftPanel.setLayout(new GridLayout(7,1));
        //lager border rundt hele leftpanel med overskrif
        leftPanel.setBorder(BorderFactory.createTitledBorder("Informasjon"));
        
        Dimension d1 = new Dimension(400,0);
        //rightPanel.setPreferredSize(d1);
        rightPanel.setMinimumSize(d1);
        
        leftPane1.setBackground(Color.decode("#f0f0f0"));
        leftPane2.setBackground(Color.white);
        leftPane3.setBackground(Color.decode("#f0f0f0"));
        leftPane4.setBackground(Color.white);
        leftPane5.setBackground(Color.decode("#f0f0f0"));
        leftPane6.setBackground(Color.white);
        leftPane7.setBackground(Color.decode("#f0f0f0"));
        
        leftPanel.add(leftPane1);
        leftPanel.add(leftPane2);
        leftPanel.add(leftPane3);
        leftPanel.add(leftPane4);
        leftPanel.add(leftPane5);
        leftPanel.add(leftPane6);
        leftPanel.add(leftPane7);
        
        leftPane1.setMargin( new Insets(2,7,2,2));
        leftPane2.setMargin( new Insets(2,7,2,2));
        leftPane3.setMargin( new Insets(2,7,2,2));
        leftPane4.setMargin( new Insets(2,7,2,2));
        leftPane5.setMargin( new Insets(2,7,2,2));
        leftPane6.setMargin( new Insets(2,7,2,2));
        leftPane7.setMargin( new Insets(2,7,2,2));
        
        /*
        leftPane1.setText("PS: Dropin for godkjenning av modul torsdag den 13."
                + "11 er flyttet til fredag den 15 november."+ "\n\nHallgeir "
                + "Nilsen,  2014-11-18");
        leftPane2.setText("Jeg kommer på laben ca kl 11, ellers er jeg på "
                + "kontoret fra kl 10, og ut dagen (unntatt når jeg er på "
                + "lab...)"+ "\n\nHallgeir Nilsen,  2014-11-15");
        leftPane3.setText("Hei,  bra oppmøte på labben idag. Jeg har bestemt "
                + "meg for å være tilgjengelig noen dager." +"\n\nEven Åby "
                + "Larsen,  2014-10-09");
        leftPane4.setText("Siste forelesning): Følgende tema er ønsket: " 
                +"\n\nEven Åby Larsen,  2014-11-02");
        leftPane5.setText("Til neste forelesning: Om å kjøre utenom BlueJ; "
                + "Casting, ny ver av dagens eksempel. ++" +"\n\nHallgeir "
                + "Nilsen,  2014-10-29");
        leftPane6.setText("Hei alle, og velkommen tebage etter påskeferie.  "
                + "Se i Fronter, IS-110, Fagstoff; Forelesninger." +"\n\nEven "
                + "Åby Larsen,  2014-10-21");
        leftPane7.setText("Jeg har lagt ut eksemplene fra siste forelesning. "
                + "Jeg har rettet alle kompileringsfeil." +"\n\nHallgeir "
                + "Nilsen,  2014-10-15");*/
        
        
        leftPane1.setEditable(false);
        leftPane2.setEditable(false);
        leftPane3.setEditable(false);
        leftPane4.setEditable(false);
        leftPane5.setEditable(false);
        leftPane6.setEditable(false);
        leftPane7.setEditable(false);
        
        //lager border rundt hele rightpanel med overskrift
        Dimension d2 = new Dimension(350,frame.getHeight());
        rightPanel.setPreferredSize(d2);
        rightPanel.setBorder(BorderFactory.createTitledBorder("Forelesning"));
        rightPanel.setLayout(new GridLayout(1,1));
        
        rightPanel.add(area1);
        
        area1.setLineWrap(true);
        area1.setWrapStyleWord(true);
        
        area1.setText("Neste forelesning: " + "\nIS-109 - Onsdag 18. November "
                + "- Kl: 13:15" + "\n\n\nIS-109 - Onsdag 27. November - Kl: "
                + "13:15" + "\n\n\nIS-109 - Onsdag 1. Desember - Kl: 10:15");
        
        frame.pack();
    }
}

    
    

    
    

