/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.mail;

import beans.NotificationTransfer;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
    
    
    JButton newNotification = new JButton("Send notifikasjon");
    JTextField sendTo = new JTextField("Skriv inn navn her");
    JTextArea viewNotification = new JTextArea("Testerino");
    JButton viewNotificationBtn = new JButton("Se alle notifikasjoner");
    JScrollPane vnScroll = new JScrollPane(viewNotification);
 
    public NotificationWindow() {
        super("Notifikasjoner");
        super.setSize(800, 600);
        super.add(container);
        container.setLayout(new GridLayout(1, 2, 10, 10));
        super.setLocationRelativeTo(null);
        p2.setLayout(new BorderLayout());
        
       // NotificationTransfer nf = Main.getNotificationBean().viewNotification(1);
       // viewNotification.setText(nf.getMessage());
        
        viewNotification.setWrapStyleWord(true);
        viewNotification.setLineWrap(true);
        
        p1.add(newNotification);
        p1.add(sendTo);
        p2.add(viewNotificationBtn, BorderLayout.NORTH);
        p2.add(vnScroll, BorderLayout.CENTER);
        
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
                            + ut.getFirstName() + " " + ut.getLastName() + "\n");
                   
                   
            
            
            
         }
            
            //viewNotification.setText(Main.getNotificationBean().viewNotification(1).getMessage());
            
        
        
        
        
        });
    }
}

