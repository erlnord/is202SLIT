/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.mail;

import beans.NotificationTransfer;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import static java.awt.font.TextAttribute.FONT;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import slit.user.UserTransfer;
import slitclient.Main;

/**
 *
 * @author Erlend
 */
public class NotificationWindow extends JFrame {
    JPanel container = new JPanel();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    
    // Alle elementene som skal være med
    JButton newNotification = new JButton("Send notifikasjon");
    JTextArea sendNotification= new JTextArea("Skriv inn din notifikasjon her");
    JTextArea viewNotification = new JTextArea("Testerino");
    JButton viewNotificationBtn = new JButton("Se alle notifikasjoner");
    JScrollPane vnScroll = new JScrollPane(viewNotification);
    JScrollPane nnScroll = new JScrollPane(sendNotification);
    
    // Constructor
    public NotificationWindow() {
        super("Notifikasjoner");
        super.setSize(800, 600);
        super.add(container);
        container.setLayout(new GridLayout(1, 2, 10, 10));
        super.setLocationRelativeTo(null);
        p1.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());
        p1.setBorder(BorderFactory.createTitledBorder("Ny notifikasjon"));
        p2.setBorder(BorderFactory.createTitledBorder("Se Notifikasjoner"));

        // Initialisering av tekstfeltene
        viewNotification.setWrapStyleWord(true);
        viewNotification.setLineWrap(true);
        viewNotification.setFont(new Font("Verdana", Font.ITALIC, 14));
        sendNotification.setColumns (160);
        sendNotification.setLineWrap (true);
        sendNotification.setWrapStyleWord (false);
        sendNotification.setFont(new Font("Verdana", Font.ITALIC, 14));
        
        // Initialiserings av innholdspanelene
        p1.add(newNotification, BorderLayout.NORTH);
        p1.add(nnScroll, BorderLayout.CENTER);
        p2.add(viewNotificationBtn, BorderLayout.NORTH);
        p2.add(vnScroll, BorderLayout.CENTER);
        
        // Legg til innholdspaneler i container
        container.add(p1);
        container.add(p2);
        
        // ActionListener til knappen viewNotification.
        // Denne viser alle notifikasjoner som er registrert i systemet, og
        // hvem de forskjellige notifikasjonene er sendt av. 
        // Notifikasjonene blir sortert i rekkefølge fra nyest til eldst. 
        viewNotificationBtn.addActionListener((ActionEvent e) -> {
            viewNotification.setText("");
            int i = 0;
            for (NotificationTransfer nu : Main.getNotificationBean().findAllNotifications()) {
                UserTransfer ut = Main.getUserBean().findUser(nu.getUserID());
                i++;
                    viewNotification.append("\n" + "Notifikasjon " + i + ": "  + nu.getMessage() + "\n" + "Sendt av: " 
                            + ut.getFirstName() + " " + ut.getLastName() + "\n" + "Dato: " + nu.getNoteDate() + "\n");           
            }
        });
        
        //ActionListener til knappen newNotification
        // Knappen gir brukeren muliget til å sende ut en notifikasjon
        // Som kan bli sett at alle brukerene i systemet
        // Systemer er ikke anonymt
        newNotification.addActionListener((ActionEvent e) -> {
            Date now = new Date();
            String message = "ADVARSEL! Det du nå sender kan bli lest av alle som bruker systemet." + "\n"
                    + "Systemet er ikke anonymt, alle kan se hvem som har sendt meldingen." + "\n"
                    + "Trykk YES for å sende, eller NO for å avbryte.";
            String title = "Sende melding?";
            int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
            Main.getNotificationBean().addNotification(sendNotification.getText(), Main.getCurrentUserID(), now);
            System.out.println("Notifikasjon sendt." + "\n" + "Melding: " + sendNotification.getText());
                    }
        });
    }
}

