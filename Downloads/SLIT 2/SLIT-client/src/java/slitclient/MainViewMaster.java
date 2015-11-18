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
    
    JTextPane pane1 = new JTextPane();
    JTextPane pane2 = new JTextPane();
    JTextPane pane3 = new JTextPane();
    JTextPane pane4 = new JTextPane();
    JTextPane pane5 = new JTextPane();
    JTextPane pane6 = new JTextPane();
    JTextPane pane7 = new JTextPane();
    JTextPane pane8 = new JTextPane();
    JTextPane pane9 = new JTextPane();
    
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
        
        
        sp.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.decode("#f0f0f0")));
        
        sp.setResizeWeight(0.8);
        sp.setDividerSize(0);

        sp.add(leftPanel);
        sp.add(rightPanel);
        frame.add(sp, BorderLayout.CENTER);
        
        // Initialiserer left JPanel
        leftPanel.setLayout(new GridLayout(9,1)); // Borderlayout
        leftPanel.setBackground(Color.white);
        leftPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 1, Color.decode("#f0f0f0")));
        
        pane1.setBackground(Color.decode("#f0f0f0"));
        pane2.setBackground(Color.white);
        pane3.setBackground(Color.decode("#f0f0f0"));
        pane4.setBackground(Color.white);
        pane5.setBackground(Color.decode("#f0f0f0"));
        pane6.setBackground(Color.white);
        pane7.setBackground(Color.decode("#f0f0f0"));
        pane8.setBackground(Color.white);
        pane9.setBackground(Color.decode("#f0f0f0"));
        
        leftPanel.add(pane1);
        leftPanel.add(pane2);
        leftPanel.add(pane3);
        leftPanel.add(pane4);
        leftPanel.add(pane5);
        leftPanel.add(pane6);
        leftPanel.add(pane7);
        leftPanel.add(pane8);
        leftPanel.add(pane9);
        
        pane1.setMargin( new Insets(5,5,5,5));
        pane2.setMargin( new Insets(5,5,5,5));
        pane3.setMargin( new Insets(5,5,5,5));
        pane4.setMargin( new Insets(5,5,5,5));
        pane5.setMargin( new Insets(5,5,5,5));
        pane6.setMargin( new Insets(5,5,5,5));
        pane7.setMargin( new Insets(5,5,5,5));
        pane8.setMargin( new Insets(5,5,5,5));
        pane9.setMargin( new Insets(5,5,5,5));
        
        pane1.setText("Hello");
        pane2.setText("Hello");
        pane3.setText("Hello");
        pane4.setText("Hello");
        pane5.setText("Hello");
        pane6.setText("Hello");
        pane7.setText("Hello");
        pane8.setText("Hello");
        pane9.setText("Hello");
        
        pane1.setEditable(false);
        pane2.setEditable(false);
        pane3.setEditable(false);
        pane4.setEditable(false);
        pane5.setEditable(false);
        pane6.setEditable(false);
        pane7.setEditable(false);
        pane8.setEditable(false);
        pane9.setEditable(false);

        
        rightPanel.setBackground(Color.white);
        rightPanel.setBorder(BorderFactory.createMatteBorder(2, 1, 0, 0, Color.decode("#f0f0f0")));
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        rightPanel.add(datePicker);
        
        /**
         * Legger til en actionListener som avslutter applikasjonen
         * dersom man trykker pÃ¥ "avslutt" i menyen.
         * SpÃ¸r ogsÃ¥ brukeren om han/hun er sikker pÃ¥ at applikasjonen skal
         * avsluttes.
         */
        exitApplication.addActionListener(new ActionListener() {
            String message = "Where were you when application was kill?";
            String title = "Avslutt applikasjon";
            @Override
            public void actionPerformed(ActionEvent e) {
                    int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Application is kill RIP.");
                        System.exit(0);
                    }
            }
        }); 
        
        // Lager en actionListener pÃ¥ infoBtn for Ã¥ teste at ting funker
        super.infoBtn.addActionListener ((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Du trykte på en knapp.");
        });
        
    }
}

    
    

    
    

