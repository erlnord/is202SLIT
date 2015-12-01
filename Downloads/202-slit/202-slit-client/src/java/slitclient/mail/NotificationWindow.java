/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.mail;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
    JTextArea viewNotification = new JTextArea("");
    JButton viewNotificationBtn = new JButton("Se en notifkasjon");
 
    public NotificationWindow() {
        super("Notifikasjoner");
       // super.setSize(1024, 768);
        super.add(container);
        container.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        
        p1.add(newNotification);
        p1.add(sendTo);
        p2.add(viewNotificationBtn);
        p2.add(viewNotification);
        
        container.add(p1, BorderLayout.WEST);
        container.add(p2, BorderLayout.EAST);
        
        viewNotificationBtn.addActionListener((ActionEvent e) -> {
            viewNotification.setText(Main.getNotificationBean().viewNotification(1).getMessage());
        });
    }
}

