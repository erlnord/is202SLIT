/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.mail;

import beans.NotificationTransfer;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    JButton viewNotificationBtn = new JButton("Se en notifkasjon");
 
    public NotificationWindow() {
        super("Notifikasjoner");
        super.setSize(800, 600);
        super.add(container);
        container.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        
        NotificationTransfer nf = Main.getNotificationBean().viewNotification(1);
        viewNotification.setText(nf.getMessage());
        
        p1.add(newNotification);
        p1.add(sendTo);
        p2.add(viewNotificationBtn);
        p2.add(viewNotification);
        
        container.add(p1, BorderLayout.WEST);
        container.add(p2, BorderLayout.EAST);
        
        viewNotificationBtn.addActionListener((ActionEvent e) -> {
            for (NotificationTransfer nu : Main.getNotificationBean().findAllNotifications()) {
                if(nu.getUserID()==1) {
                viewNotification.setText(nu.getMessage()+"\n");
                } else {
                    System.out.println("RIPRIPRIPRIPRIP");
                }
            }
            
            
            
            
            //viewNotification.setText(Main.getNotificationBean().viewNotification(1).getMessage());
        });
    }
}

