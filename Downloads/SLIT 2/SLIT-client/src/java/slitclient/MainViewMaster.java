/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;



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
    JTextPane leftPane8 = new JTextPane();
    JTextPane leftPane9 = new JTextPane();
    
    JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane rightsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    
    // Lager tekstfeltet der lÃ¦rerene kan legge ut nyheter
    //JTextArea infoTxt = new JTextArea();
    //JScrollPane infoScroll = new JScrollPane(infoTxt);
    
    // Initialiserer kalender
    UtilDateModel model = new UtilDateModel();
    //model.setDate(20,04,2014);
    // Need this...
    Properties p = new Properties();
       // p.put("text.today", "Today");
       // p.put("text.month", "Month");
       // p.put("text.year", "Year");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    // Don't know about the formatter, but there it is...
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
 

    
    /**
     * Konstruktor for klassen MainViewMaster
     */
    public MainViewMaster() {
        //Legger til alle elementene i JFrame
        frame.add(menuBar);
        frame.setJMenuBar(menuBar);
        //frame.setLayout(new GridLayout(5, 5, 10, 10));
        
       
    
        // Legger til en container for left og rightpanel
        //frame.getContentPane().add(container, BorderLayout.CENTER);
        //container.setLayout(new GridLayout(1,2));
        //container.add(leftPanel);
        //container.add(rightPanel);
        
        
        // Legger til topPanel i JFrame
        // topPanel er panelet med knappene
        // Må alltid legges til på NORTH
        frame.add(topPanel, BorderLayout.NORTH);
        topPanel.setBackground(Color.white);
        // Lager en actionListener pÃ¥ infoBtn for Ã¥ teste at ting funker
        // Må legges til i hver klasse
        super.infoBtn.addActionListener ((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Du trykte på en knapp.");
        });
        
        super.bookingBtn.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            new TimePlan();
        });
        
        super.settingsBtn.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            new SettingsWindow();
        });
        
        
        sp.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.decode("#f0f0f0")));
        
        sp.setResizeWeight(0.7);
        sp.setDividerSize(0);

        sp.add(leftPanel);
        sp.add(rightPanel);
        frame.add(sp, BorderLayout.CENTER);
        
        // Initialiserer left JPanel
        leftPanel.setLayout(new GridLayout(9,1));
        leftPanel.setBackground(Color.white);
        leftPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 1, Color.decode("#f0f0f0")));
        
        leftPane1.setBackground(Color.decode("#f0f0f0"));
        leftPane2.setBackground(Color.white);
        leftPane3.setBackground(Color.decode("#f0f0f0"));
        leftPane4.setBackground(Color.white);
        leftPane5.setBackground(Color.decode("#f0f0f0"));
        leftPane6.setBackground(Color.white);
        leftPane7.setBackground(Color.decode("#f0f0f0"));
        leftPane8.setBackground(Color.white);
        leftPane9.setBackground(Color.decode("#f0f0f0"));
        
        leftPanel.add(leftPane1);
        leftPanel.add(leftPane2);
        leftPanel.add(leftPane3);
        leftPanel.add(leftPane4);
        leftPanel.add(leftPane5);
        leftPanel.add(leftPane6);
        leftPanel.add(leftPane7);
        leftPanel.add(leftPane8);
        leftPanel.add(leftPane9);
        
        leftPane1.setMargin( new Insets(10,10,10,10));
        leftPane2.setMargin( new Insets(10,10,10,10));
        leftPane3.setMargin( new Insets(10,10,10,10));
        leftPane4.setMargin( new Insets(10,10,10,10));
        leftPane5.setMargin( new Insets(10,10,10,10));
        leftPane6.setMargin( new Insets(10,10,10,10));
        leftPane7.setMargin( new Insets(10,10,10,10));
        leftPane8.setMargin( new Insets(10,10,10,10));
        leftPane9.setMargin( new Insets(10,10,10,10));
        
        leftPane1.setText("Hello");
        leftPane2.setText("Halla");
        leftPane3.setText("Helllo");
        leftPane4.setText("Hva skjer?");
        leftPane5.setText("Hello");
        leftPane6.setText("Heihei ja");
        leftPane7.setText("Hello");
        leftPane8.setText("HOLD NU KJÆFT!");
        leftPane9.setText("Hello?");
        
        leftPane1.setEditable(false);
        leftPane2.setEditable(false);
        leftPane3.setEditable(false);
        leftPane4.setEditable(false);
        leftPane5.setEditable(false);
        leftPane6.setEditable(false);
        leftPane7.setEditable(false);
        leftPane8.setEditable(false);
        leftPane9.setEditable(false);

        
        rightPanel.setBackground(Color.white);
        rightPanel.setBorder(BorderFactory.createMatteBorder(2, 1, 0, 0, Color.decode("#f0f0f0")));
        rightPanel.setLayout(new GridLayout(9,1));
        
        
       
        
        
    }
}

    
    

    
    

