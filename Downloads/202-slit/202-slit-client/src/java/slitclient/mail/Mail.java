package slitclient.mail;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import slitclient.ButtonMenu;
import slitclient.Main;

/**
 *
 * @author Erlend
 * 
 * En klasse som fungerer som GUI for mail-delen av klienten. 
 * Notifikasjon og send mail-delene fungerer som de skal, men innboks-delen
 * fungerer dessverre ikke. Dette fordi jeg mangler SSL-certificate.
 * 
 * panel1 til venstre simulerer hvordan vi så for oss at en innboks skulle
 * fungere. panel2 til høyre inneholder knapper som tar deg videre til innboks-tjenesten
 * (som ikke virker), send e-post tjenesten og notifikasjonstjenesten. 
 */
public class Mail extends ButtonMenu {
   JFrame mailFrame = new JFrame();
   JPanel container = new JPanel();
   JPanel p1 = new JPanel();
   JPanel p2 = new JPanel(); 
 
   // Elementer til p1
   JLabel fromLbl = new JLabel("Sender:");
   JLabel topicLbl = new JLabel("Emne:");
   
   JLabel fromLbl1 = new JLabel("Hallgeir Nilsen");
   JLabel topicLbl1 = new JLabel("Hei. M�ter er satt opp til tirsdag 20.11");
   
   JLabel fromLbl2 = new JLabel("Even Larsen");
   JLabel topicLbl2 = new JLabel("Minner om at alle m� levere logg fra git innen torsdag.");
   
   JLabel fromLbl3 = new JLabel("Amanda Olsen");
   JLabel topicLbl3 = new JLabel("Hei! Lurte p� om vi kunne intervjue gruppen deres?");
   
   JLabel fromLbl4 = new JLabel("Oddvar Tengesdal");
   JLabel topicLbl4 = new JLabel("Jeg blir p� lab fra klokken 13 p� tirsdag, bare � stikke innom");
   
   JLabel fromLbl5 = new JLabel("Lars Martin Risdal");
   JLabel topicLbl5 = new JLabel("Gidder du � sende over databasegreiene?");
   
   JLabel fromLbl6 = new JLabel("Atilla Sjusdal");
   JLabel topicLbl6 = new JLabel("Hei. Kan vi ta en hangouts p� noen swing-greier?");
   
   JLabel fromLbl7 = new JLabel("Trygve �se Lunde");
   JLabel topicLbl7 = new JLabel("Kossn skulle vi gjer dn der greio?");
   
   JLabel fromLbl8 = new JLabel("Geir Geiresen");
   JLabel topicLbl8 = new JLabel("Vote Geir Geiresen for UiA-president 2015!");
   
   
   // Elementer til p2
   JLabel displayMsgLbl = new JLabel("Melding: ");
   JLabel spacingLblR = new JLabel("");
   JTextArea displayMessage = new JTextArea("Her kommer meldingene du trykker p� i innboksen din");
   JButton newMessageBtn = new JButton("Ny Melding"); 
   
   MouseListener ml; 
        
    JButton inbxBtn = new JButton("Se innboks"); 
    JButton notificationBtn = new JButton("Notifikasjoner");
    public Mail() {
       
        
        mailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Oppsett av Panels
        p1.setBackground(Color.WHITE);
        p1.setBorder(BorderFactory.createTitledBorder("Innboks"));
        p2.setBackground(Color.WHITE);
        p2.setBorder(BorderFactory.createTitledBorder("Melding"));
        p1.setLayout(new GridLayout(0, 2));
        p2.setLayout(new GridLayout(3, 0)); 
        
        // Oppsett av container
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
        
        // Legger til Container
        mailFrame.add(container);
        
        // PANEL 1
        fromLbl.setFont(new Font("Verdana", Font.CENTER_BASELINE, 16));
        fromLbl.setOpaque(true);
        //fromLbl.setBackground(Color.GRAY);
        p1.add(fromLbl);
        
        topicLbl.setFont(new Font("Verdana", Font.CENTER_BASELINE, 16));
        //topicLbl.setOpaque(true); 
        p1.add(topicLbl);
        
        // Linje 1
        fromLbl1.setOpaque(true);
        //fromLbl1.setBackground(Color.GRAY);
        topicLbl1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        topicLbl1.addMouseListener(ml);
        p1.add(fromLbl1);
        p1.add(topicLbl1);
        
        // Linje 2
        fromLbl2.setOpaque(true);
        //fromLbl2.setBackground(Color.GRAY);
        topicLbl2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        topicLbl2.addMouseListener(ml);
        p1.add(fromLbl2);
        p1.add(topicLbl2);
        
        // Linje 3
        fromLbl3.setOpaque(true);
        //fromLbl3.setBackground(Color.GRAY);
        topicLbl3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        topicLbl3.addMouseListener(ml);
        p1.add(fromLbl3);
        p1.add(topicLbl3);
        
        // Linje 4
        fromLbl4.setOpaque(true);
        //fromLbl4.setBackground(Color.GRAY);
        topicLbl4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        topicLbl4.addMouseListener(ml);
        p1.add(fromLbl4);
        p1.add(topicLbl4);
        
        // Linje 5
        fromLbl5.setOpaque(true);
        //fromLbl5.setBackground(Color.GRAY);
        topicLbl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        topicLbl5.addMouseListener(ml);
        p1.add(fromLbl5);
        p1.add(topicLbl5);
        
        // Linje 6
        fromLbl6.setOpaque(true);
        //fromLbl6.setBackground(Color.GRAY);
        topicLbl6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        topicLbl6.addMouseListener(ml);
        p1.add(fromLbl6);
        p1.add(topicLbl6);
        
        // Linje 7
        fromLbl7.setOpaque(true);
        //fromLbl7.setBackground(Color.GRAY);
        topicLbl7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        topicLbl7.addMouseListener(ml);
        p1.add(fromLbl7);
        p1.add(topicLbl7);
        
        // Linje 8
        fromLbl8.setOpaque(true);
        //fromLbl8.setBackground(Color.GRAY);
        topicLbl8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        topicLbl8.addMouseListener(ml);
        p1.add(fromLbl8);
        p1.add(topicLbl8);
           
        // Ting til panel2
        displayMsgLbl.setFont(new Font("Verdana", Font.CENTER_BASELINE, 16));
        displayMessage.setEditable(false);
        displayMessage.setFont(new Font("Verdana", Font.ITALIC, 14));
        p2.add(newMessageBtn); 
        p2.add(notificationBtn);
        p2.add(inbxBtn);
         
        
        // Legger til panel 1 og 2 i container
        container.add(p1);
        container.add(p2);
        
         // Instansierer MouseListener, som blir brukt p� JLabels
        ml = new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent me) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
             @Override
    public void mousePressed(MouseEvent me) {
        if(me.getComponent() == topicLbl1) {
            displayMessage.setText("M�ter er satt til Tirsdag 20.11.\n"
                    + "Tider f�lger under: \n"
                    + "D�rlig Oppm�te: 1130.\n"
                    + "Superboys: 1200. \n"
                    + "Bad boys: 1230\n"
                    + "Good girls: 1300 \n"
                    + "Barbecue stain: 1530");
        } else if (me.getSource() == topicLbl2) {
            displayMessage.setText("Loggen fra github m� leveres innen torsdag.\n"
                    + "Dette er sv�rt viktig for at vi skal se hvordan dere har jobbet sammen \n"
                    + "som gruppe. Dersom loggen ikke blir levert, blir gruppen trukket en hel karakter");
        }
    };
            
            @Override
            public void mouseReleased(MouseEvent me) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            @Override
            public void mouseEntered(MouseEvent me) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            @Override
            public void mouseExited(MouseEvent me) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        // Oppretter e-postvinduet over mail-vinduet
        newMessageBtn.addActionListener((ActionEvent e) -> {
            //mailFrame.dispose();
            Main.SwingEmailSender();
        });
        
        // Oppretter notifikasjonsvinduet over mail-vinduet
        notificationBtn.addActionListener((ActionEvent e) -> {
            //mailFrame.dispose();
            Main.NotificationWindow();
        });


        // ActionListener til inox-knappen. Denne delen av koden fungere dessverre ikke, 
        // da jeg mangler SSL-certificate.
        inbxBtn.addActionListener((ActionEvent e) -> {
        String protocol = "imap";
        String host = "imap.gmail.com";
        String port = "993";
 
 
        String userName = "sliterino@gmail.com";
        String password = "is202sliterino";
        
       // System.setProperty("javax.net.ssl.trustStore","JAVA_HOME\\lib\\security\\cacerts");
       // System.setProperty("javax.net.ssl.trustStorePassword","changeit");
        
        EmailReceiver receiver = new EmailReceiver();
        receiver.downloadEmails(protocol, host, port, userName, password);
        
    
    });
       
        
      
}
}

    
    

