/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import slit.user.UserTransfer;



/**
 *
 * @author Erlend
 */
public class guiLogInWindow extends JFrame {
    
    
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel userLbl = new JLabel("Brukernavn");
    JTextField userTxt = new JTextField("Brukernavn", 20);
    JLabel passwordLbl = new JLabel("Passord");
    JPasswordField passwordField = new JPasswordField("passord", 20);
    JLabel spacingLbl1 = new JLabel("");
    
    JButton logInBtn = new JButton("Logg inn");
    JButton newUser = new JButton("Registrer bruker");
    
    //Registrer bruker
    JTextField emailTxt = new JTextField("Epost",20);
    JTextField UserNameTxt = new JTextField("Brukernavn",20);
    JTextField FirstNameTxt = new JTextField("Fornavn",20);
    JTextField LastNameTxt = new JTextField("Etternavn",20);
    //JTextField regPassword = new JTextField("Passord",20);
    JPasswordField regPassword = new JPasswordField("Passord", 20);
    JButton cancelBtn = new JButton("Avbryt");
    JButton regUserBtn = new JButton("Registrer");
    
    int logInType; 
    
   
    public guiLogInWindow() {
        // guiLogInWindow arver fra superklassen sin, JFrame
        // Legger til panel1 og panel2 i frame
        super("Logg inn");
        // Setter defaultknappen i frame til logInBtn
        super.getRootPane().setDefaultButton(logInBtn);
        super.setVisible(true);
        super.setSize(600,150);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setBackground(Color.WHITE);
        // Plasserer applikasjonen midt på skjermen
        super.setLocationRelativeTo(null);
        
        super.add(panel1);
        super.add(panel2);
        
        // Lager en FlowLayout på panel2, og legger til panel1 der,
        // av estetiske grunner
        panel2.setLayout(new FlowLayout());
        panel2.add(panel1);
        panel2.setBackground(Color.WHITE);
        
        // Legger til alle elementene som trengs i panel1
        panel1.setLayout(new GridLayout(3, 2));
        panel1.setBackground(Color.WHITE);
        panel1.add(userLbl);
        panel1.add(userTxt);
        panel1.add(passwordLbl);
        panel1.add(passwordField);
        // Dette er en blank label, brukt for å få logInBtn på riktig sted
        //panel1.add(spacingLbl1);
        panel1.add(newUser);
        panel1.add(logInBtn);
        
        // ActionListenere følger under
        
        /**
         * ActionListener for å trykke på logInBtn
         * Her er brukt lambdaclass, som basically lar oss behandle
         * den indre klassen som en metode for logInBtn.
         * Popper opp en frekk JOptionPane uansett.
         */
        logInBtn.addActionListener((ActionEvent e) -> {
            // Dersom logIn-informasjonen stemmer overens med student, 
            // lukker vi denne klassen og kaller metoden fra main
            // som bygger studentMainView-klassen
            
            
            // Looper gjennom alle brukere og leter etter brukernavn
            for (UserTransfer u : Main.getUserBean().findAllUsers()) {
                // Sjekker etter brukernavn som er oppgitt
                if (userTxt.getText().equals(u.getUserName())) {
                    // Henter ut passord fra passwordfield
                    String password = new String(passwordField.getPassword());
                    // Sjekker at passordet stemmer med brukernavn
                    if (password.equals(u.getPassPhrase())) {
                        System.out.println("Found user: " + u.getFirstName());
                        // Lagrer UserID til en lokal variabel
                        Main.setCurrentUserID(u.getUserID());
                        // Lagrer en variabel for å hente ut brukertypen
                        UserTransfer uff = Main.getUserBean().findUser(u.getUserID());
                        // sjekker om bruker er student eller foreleser
                        if (uff.getUserType() == 1) {
                            super.dispose();
                            Main.studentMainView();
                            logInType = 1;
                        } else {
                            super.dispose();
                            Main.teacherMainView();
                            logInType = 2;
                        }
                    } else {
                        // Feilmelding ved feil brukernavn
                        JOptionPane.showMessageDialog(null, "Passordet/brukernavnet er ikke riktig");
                    }
                }
            }
        });
            
        // Dette er den gamle metoden for å logge inn. Erstattet med en  mer sofistikert.
            /*if(userTxt.getText().equalsIgnoreCase("student")){
                super.setVisible(false); // Cant see me
                super.dispose(); //Destroy the JFrame object
                //logInCondition = "student";
                // Kaller metoden som bygger neste objekt
                Main.setCurrentUserID(1);
                Main.studentMainView();
            } else if(userTxt.getText().equalsIgnoreCase("teacher")) {
                super.setVisible(false); // Ser ikkje meg lenger
                super.dispose(); // Begone, heathen

                // Kaller metoden som bygger lærer
                Main.setCurrentUserID(4);
                Main.teacherMainView();
            } else {
                // Bruker har skrevet feil passord, eller finnes ikke i databasen
                // Legger til mer sofisitikert metode senere.
            JOptionPane.showMessageDialog(null, "Passordet/brukernavnet er ikke riktig"
            + " Vennligst prøv igjen");
            }
        }); */
        
        /**
         * Legger til en MouseListener som klarerer tekstfeltet
         * når brukeren klikker på det.
         * DENNE ER DOG IKKE PERFEKT:
         * Har mekket sammen en klønete måte å kun fjerne teksten dersom
         * default-teksten "Brukernavn" er i tekstfeltet.
         * Det må vel finnes en mer elegant løsning?
         */
        userTxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me){
                if("Brukernavn".equals(userTxt.getText())) {
                userTxt.setText("");
                }
            }
        }); 
        
        /**
         * Legger til en MouseListener som klarerer passordfeltet
         * når brukeren klikker på det, dersom teksten i passordfeltet
         * er default tekst.
         * Må legge til et Array med bokstaver, fordi char[] ikke er identisk
         * med String.
         */
        passwordField.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent me) {
               if(Arrays.equals(passwordField.getPassword(), new char[]{'p','a','s','s','o','r','d'})) {
                   passwordField.setText("");
               }
           }
        });  
        
        newUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                registerUser();
            }
        });   
    }
    
    public void registerUser() {
        super.dispose();
        JFrame frame2 = new JFrame();
        frame2.setVisible(true);
        frame2.setSize(600,170);
        frame2.setBackground(Color.WHITE);
        // Plasserer applikasjonen midt på skjermen
        frame2.setLocationRelativeTo(null);
        
        
        JPanel regContainer = new JPanel();
        JPanel regPanel = new JPanel();
        
        frame2.add(regContainer);
        
        // Lager en FlowLayout på panel2, og legger til panel1 der,
        // av estetiske grunner
        regContainer.setLayout(new FlowLayout());
        regContainer.add(regPanel);
        regContainer.setBackground(Color.WHITE);
        
        // Legger til alle elementene som trengs i panel1
        regPanel.setLayout(new GridLayout(4, 2));
        regPanel.setBackground(Color.WHITE);
        regPanel.add(FirstNameTxt);
        regPanel.add(LastNameTxt);
        regPanel.add(UserNameTxt);
        regPanel.add(emailTxt);
        regPanel.add(regPassword);
        regPanel.add(spacingLbl1);
        regPanel.add(cancelBtn);
        regPanel.add(regUserBtn);
        
        
        regUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String password = new String(regPassword.getPassword());
                
                Main.getUserBean().addUser(1, FirstNameTxt.getText(), LastNameTxt.getText(), 
                        UserNameTxt.getText(), password, emailTxt.getText());
                
                System.out.println("User: "+FirstNameTxt.getText() + " " + LastNameTxt.getText() + " added.");
            }
        });
        
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frame2.dispose();
                new guiLogInWindow();
            }
        });
        
    }
    
    public int getLogInType() {
        return logInType;
    }

}