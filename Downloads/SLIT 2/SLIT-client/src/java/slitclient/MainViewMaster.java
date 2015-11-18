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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;



/**
 *
 * @author Erlend
 */
public abstract class MainViewMaster extends ButtonMenu{
    
    // Lager en JFrame som vi kan plassere alle elementene i
    JFrame frame = new JFrame();
    
    // Lager tre JPanels som blir brukt til Ã¥ plassere innhold
    //JPanel topPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel container = new JPanel();
    
    // Lager tekstfeltet der lÃ¦rerene kan legge ut nyheter
    JTextArea infoTxt = new JTextArea();
    JScrollPane infoScroll = new JScrollPane(infoTxt);
    
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
        frame.getContentPane().add(container, BorderLayout.CENTER);
        container.setLayout(new GridLayout(1,2));
        container.add(leftPanel);
        container.add(rightPanel);
        
        
        // Legger til topPanel i JFrame
        // topPanel er panelet med knappene
        // Må alltid legges til på NORTH
        frame.add(topPanel, BorderLayout.NORTH);
        topPanel.setBackground(Color.white);
        
        
        // Initialiserer left JPanel
        leftPanel.setLayout(new BorderLayout()); // Borderlayout for å få textarea til å bruke fullsize
        //leftPanel.setLayout(new GridLayout(4, 3, 10, 10));
        infoTxt.setWrapStyleWord(true); // Linjer pÃ¥ ord istedenfor bokstaver
        infoTxt.setLineWrap(true); // NÃ¥ scroller vi bare horisontalt
        infoTxt.setText("Hei");
        infoTxt.setMargin( new Insets(15,15,15,15)); // teksten går ikke helt til kantene
        leftPanel.add(infoScroll, BorderLayout.CENTER); // legger scrollpanen med textarea inni til leftPanel
        leftPanel.setBackground(Color.white);

        
        rightPanel.setBackground(Color.white);
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

    
    

    
    

