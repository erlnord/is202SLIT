package slitclient.mail;

import beans.NotificationTransfer;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
 * 
 * Denne klassen lager notifikasjonsvinduet. Notifikasjonsvinduet lar deg 
 * sende notifikasjoner til alle andre brukere av systemet. Notifikasjonene
 * du sender blir lagret i databasen.
 * 
 * Kun lærere kan sende notifikasjoner. Elever kan bare motta. 
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
        viewNotification.setEditable(false);
        sendNotification.setColumns (160);
        sendNotification.setLineWrap (true);
        sendNotification.setWrapStyleWord (true);
        sendNotification.setFont(new Font("Verdana", Font.ITALIC, 14));
        if(Main.getUserType() == 1) {
            sendNotification.setText("Elever har ikke mulighet til å sende notifikasjoner");
            sendNotification.setEditable(false);
        }
        
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
                            + ut.getFirstName() + " " + ut.getLastName() + "\n" + "Dato: " + nu.getNoteDate() + "\n"
                    + "   --------------------------------------------------   ");           
            }
        });
        
        //ActionListener til knappen newNotification
        // Knappen gir brukeren muliget til å sende ut en notifikasjon
        // Som kan bli sett at alle brukerene i systemet
        // Systemer er ikke anonymt
        // Kun lærere kan sende ut notifikasjoner
        newNotification.addActionListener((ActionEvent e) -> {
           // Sjekker om brukeren er en lærer
            if(Main.getUserType() == 2) { 
               Date now = new Date();
                String message = "ADVARSEL! Notifikasjonen du skriver vil bli sett av alle elever og lærere." + "\n"
                        + "Navnet ditt vil stå bak meldingen." + "\n"
                        + "Trykk YES for å sende, eller NO for å avbryte.";
                String title = "Sende melding?";
                int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                Main.getNotificationBean().addNotification(sendNotification.getText(), Main.getCurrentUserID(), now);
                System.out.println("Notifikasjon sendt." + "\n" + "Melding: " + sendNotification.getText());
                        }
            } else {
                // brukeren var elev, og har dermed ikke tillatelse til å sende notifikasjoner
               String message = "Som student har du ikke mulighet til å sende notifikasjoner";
               JOptionPane.showMessageDialog(container, message);
           }
           });
        
        // En mouselistener som tar vekk teksten i tekstfeltet dersom default-teksten er der.
        sendNotification.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me){
                if(sendNotification.getText().equals("Skriv inn din notifikasjon her")) {
                sendNotification.setText("");
                }
            }
        }); 
    }
}

