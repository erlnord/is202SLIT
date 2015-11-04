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
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.util.Arrays;
import javax.swing.*;



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
    
    String logInCondition = "";
   
    public guiLogInWindow() {
        // guiLogInWindow arver fra superklassen sin, JFrame
        // Legger til panel1 og panel2 i frame
        super("Logg inn");
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
        panel1.add(spacingLbl1);
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
            if(userTxt.getText().equalsIgnoreCase("student")){
                super.setVisible(false); // Cant see me
                super.dispose(); //Destroy the JFrame object
                logInCondition = "student";
                // Kaller metoden som bygger neste objekt
                Main.studentMainView();
            } else if(userTxt.getText().equalsIgnoreCase("teacher")) {
                super.setVisible(false); // Ser ikkje meg lenger
                super.dispose(); // Begone, heathen
                logInCondition = "teacher";
                // Kaller metoden som bygger lærer
                Main.teacherMainView();
            } else {
                // Bruker har skrevet feil passord, eller finnes ikke i databasen
                // Legger til mer sofisitikert metode senere.
            JOptionPane.showMessageDialog(null, "Passordet/brukernavnet er ikke riktig"
            + " Vennligst prøv igjen");
            }
        });
        
        
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
   
    }
    
    public String getLogInCondition() {
        return logInCondition;
    }

    }
    
        
    
    
    
