/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;





/**
 *
 * @author Erlend
 */
public abstract class MainViewMaster {
    
    // Lager en JFrame som vi kan plassere alle elementene i
    JFrame frame = new JFrame();
    
    // Lager tre JPanels som blir brukt til Ã¥ plassere innhold
    JPanel topPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel container = new JPanel();
    
    // Lager en menylinje
    JMenuBar menuBar = new JMenuBar();
    
    // Lager "Fil"-delen av menyen og alt som hÃ¸rer til
    JMenu fileMenu = new JMenu("Fil");
    JMenu openFile = new JMenu("Ã…pne");
    JMenuItem fromLocal = new JMenuItem("Lokalt lagret");
    JMenuItem fromCloud = new JMenuItem("Fra sky");
    JMenuItem saveFile = new JMenuItem("Lagre");
    JMenuItem saveAsFile = new JMenuItem("Lagre Som");
    JMenuItem exitApplication = new JMenuItem("Avslutt applikasjonen");
    
    // Lager "Kontakt"-delen av menyen og alt som hÃ¸rer til
    JMenu contactMenu = new JMenu("Kontakt");
    
    // Lager "Hjelp"-delen av menyen og alt som hÃ¸rer til
    JMenu helpMenu = new JMenu("Hjelp");
    
    // Lager hovedknappene, som blir brukt til Ã¥ manÃ¸vrere seg rundt 
    // i systemet. Bruker bilder som ikoner.
    // Initialiserer infoBtn
    ImageIcon infoImg = new ImageIcon(getClass().getResource("/images/info.jpg"));
    JButton infoBtn = new JButton(infoImg);
    
    // Initialiserer bookingBtn
    ImageIcon bookingImg = new ImageIcon(getClass().getResource("/images/booking.jpg"));
    JButton bookingBtn = new JButton(bookingImg);
    
    // Initialiserer moduleBtn
    ImageIcon moduleImg = new ImageIcon(getClass().getResource("/images/module.jpg"));
    JButton moduleBtn = new JButton(moduleImg);
    
    // Initialiserer mailBtn
    ImageIcon mailImg = new ImageIcon(getClass().getResource("/images/mail.jpg"));
    JButton mailBtn = new JButton(mailImg);
    
    // Initialiserer settingsBtn
    ImageIcon settingsImg = new ImageIcon(getClass().getResource("/images/settings.jpg"));
    JButton settingsBtn = new JButton(settingsImg);
    
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
        
        // Legger til fil-menyen i menylinja, og legger til menyelementer
        menuBar.add(fileMenu);
        fileMenu.add(openFile);
        openFile.add(fromLocal);
        openFile.add(fromCloud);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.add(exitApplication);
        
        // Legger til kontakt-menyen i menylinja, og legger til elementer
        menuBar.add(contactMenu);
        
        // Legger til hjelp-menyen i menylinja, og legger til elementer
        menuBar.add(helpMenu);

        
        // Initialiserer top JPanel
        topPanel.setLayout(new GridLayout(1, 5, 10, 10));
        
        // Initialiserer infoBtn
        infoBtn.setBorderPainted(false); // Slipper Ã¥ se linjene til knappen
        infoBtn.setFocusPainted(false); // Slipper Ã¥ se knappen i bakgrunnen
        infoBtn.setContentAreaFilled(false);
        infoBtn.setSize(1, 1);
        infoBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        topPanel.add(infoBtn);
        
        // Initialiserer bookingBtn
        bookingBtn.setBorderPainted(false);
        bookingBtn.setFocusPainted(false);
        bookingBtn.setContentAreaFilled(false);
        bookingBtn.setSize(1, 1);
        topPanel.add(bookingBtn);
        
        // Initialiserer moduleBtn
        moduleBtn.setBorderPainted(false);
        moduleBtn.setFocusPainted(false);
        moduleBtn.setContentAreaFilled(false);
        moduleBtn.setSize(1, 1);
        topPanel.add(moduleBtn);
        
        // Initialiserer mailBtn
        mailBtn.setBorderPainted(false);
        mailBtn.setFocusPainted(false);
        mailBtn.setContentAreaFilled(false);
        mailBtn.setSize(1, 1);
        topPanel.add(mailBtn);
        
        // Initialiserer settingsBtn
        settingsBtn.setBorderPainted(false);
        settingsBtn.setFocusPainted(false);
        settingsBtn.setContentAreaFilled(false);
        settingsBtn.setSize(1, 1);
        topPanel.add(settingsBtn);
        
        
        // Legger til en container for left og rightpanel
        frame.getContentPane().add(container, BorderLayout.CENTER);
        container.setLayout(new GridLayout(1,2));
        container.add(leftPanel);
        container.add(rightPanel);
        
        
        // Legger til topPanel i JFrame
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
        infoBtn.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Du trykte på en knapp.");
            }
        });
        

  
    }
}

    
    

