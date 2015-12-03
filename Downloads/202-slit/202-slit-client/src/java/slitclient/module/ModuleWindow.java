package slitclient.module;

import beans.DeliveryTransfer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import slit.user.UserTransfer;
import slitclient.ButtonMenu;
import slitclient.Main;

/**
 * @author GUI: Atilla og Admir, funksjonalitet: Lars Martin.
 */
//Arver felt og metoder fra klassen ButtonMenu
public class ModuleWindow extends ButtonMenu { 
   
    //constructor for ModuleView
    public ModuleWindow()
    {
        //lage frame og legger til top panel for buttons
        JFrame frame = new JFrame("Modules");
        frame.add(topPanel, BorderLayout.NORTH);
        topPanel.setBackground(Color.white);
        frame.add(menuBar);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        
        //int rekke, int kolonne, int horisontalt mellomrom, int vertikalt mellomrom
        panel.setLayout(new GridLayout(4, 3, 5, 10));
        JButton button1 = new JButton("Modul 1");
        JButton button2 = new JButton("Modul 2");
        JButton button3 = new JButton("Modul 3");
        JButton button4 = new JButton("Modul 4");
        JButton button5 = new JButton("Modul 5");
        JButton button6 = new JButton("Modul 6");
        JButton button7 = new JButton("Modul 7");
        JButton button8 = new JButton("Modul 8");
        JButton button9 = new JButton("Modul 9");
        JButton button10 = new JButton("Modul 10");
        JButton button11 = new JButton("Modul 11");
        JButton button12 = new JButton("Modul 12");
        
        button1.setOpaque(true);
        button1.setBackground(Color.YELLOW);
        button2.setOpaque(true);
        button2.setBackground(Color.YELLOW);
        button3.setOpaque(true);
        button3.setBackground(Color.YELLOW);
        button4.setOpaque(true);
        button4.setBackground(Color.YELLOW);
        button5.setOpaque(true);
        button5.setBackground(Color.YELLOW);
        button6.setOpaque(true);
        button6.setBackground(Color.YELLOW);
        button7.setOpaque(true);
        button7.setBackground(Color.YELLOW);
        button8.setOpaque(true);
        button8.setBackground(Color.YELLOW);
        button9.setOpaque(true);
        button9.setBackground(Color.YELLOW);
        button10.setOpaque(true);
        button10.setBackground(Color.YELLOW);
        button11.setOpaque(true);
        button11.setBackground(Color.YELLOW);
        button12.setOpaque(true);
        button12.setBackground(Color.YELLOW);
        
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(button10);
        panel.add(button11);
        panel.add(button12);
        frame.add(panel);
        
        for (DeliveryTransfer dt : Main.getDeliveryBean().findAllDeliveries()) {
            if (dt.getModuleID() == 1 && dt.getUserID() == Main.getCurrentUserID() && dt.getDeliveryStatus() == 2) {
                button1.setBackground(Color.green);
            } else if (dt.getModuleID() == 1 && dt.getUserID() == Main.getCurrentUserID() && dt.getDeliveryStatus() == 3) {
                button1.setBackground(Color.RED);
            }
            
            else if (dt.getModuleID() == 2 && dt.getUserID() == Main.getCurrentUserID() && dt.getDeliveryStatus() == 2) {
                button2.setBackground(Color.green);
            } else if (dt.getModuleID() == 2 && dt.getUserID() == Main.getCurrentUserID() && dt.getDeliveryStatus() == 3) {
                button2.setBackground(Color.red);
            }
            
            else if (dt.getModuleID() == 3 && dt.getUserID() == Main.getCurrentUserID() && dt.getDeliveryStatus() == 2) {
                button3.setBackground(Color.green);
            } else if (dt.getModuleID() == 3 && dt.getUserID() == Main.getCurrentUserID() && dt.getDeliveryStatus() == 3) {
                button3.setBackground(Color.red);
            } 
            
            else  if (dt.getModuleID() == 4 && dt.getUserID() == Main.getCurrentUserID() && dt.getDeliveryStatus() == 2) {
                button4.setBackground(Color.green);
            } else if (dt.getModuleID() == 4 && dt.getUserID() == Main.getCurrentUserID() && dt.getDeliveryStatus() == 3) {
                button4.setBackground(Color.red);
            }
            
            else if (dt.getModuleID() == 5 && dt.getUserID() == Main.getCurrentUserID() && dt.getDeliveryStatus() == 2) {
                button5.setBackground(Color.green);
            } else if (dt.getModuleID() == 5 && dt.getUserID() == Main.getCurrentUserID() && dt.getDeliveryStatus() == 3) {
                button5.setBackground(Color.red);
            }
        }
        
        // Lager en variabel av UserBean sin findUser metode.
        UserTransfer uff = Main.getUserBean().findUser(Main.getCurrentUserID());
        /**
         * Under følger 12 actionlisteners til alle 12 modulknappene.
         * Alle knappene bruker en variabel fra Main som heter ModuleType.
         * Denne variabelen blir satt fra 1-12 avhengig av hvilken knapp som
         * blir trykket. Denne variabelen brukes så for å fylle ut
         * modulinformasjonsfelt på modulsiden.
         */
        button1.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.setModuleType(1);
            System.out.println("Modul "+Main.getModuleType());
            if (uff.getUserType() == 1) {
                new ModuleViewStudent();
            } else {
                new ModuleViewTeacher();
            }
        });
        button2.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.setModuleType(2);
            System.out.println("Modul "+Main.getModuleType());
            if (uff.getUserType() == 1) {
                new ModuleViewStudent();
            } else {
                new ModuleViewTeacher();
            }
        });
        button3.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.setModuleType(3);
            System.out.println("Modul "+Main.getModuleType());
            if (uff.getUserType() == 1) {
                new ModuleViewStudent();
            } else {
                new ModuleViewTeacher();
            }
        });
        button4.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.setModuleType(4);
            System.out.println("Modul "+Main.getModuleType());
            if (uff.getUserType() == 1) {
                new ModuleViewStudent();
            } else {
                new ModuleViewTeacher();
            }
        });
        button5.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.setModuleType(5);
            System.out.println("Modul "+Main.getModuleType());
            if (uff.getUserType() == 1) {
                new ModuleViewStudent();
            } else {
                new ModuleViewTeacher();
            }
        });
        button6.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.setModuleType(6);
            System.out.println("Modul "+Main.getModuleType());
            if (uff.getUserType() == 1) {
                new ModuleViewStudent();
            } else {
                new ModuleViewTeacher();
            }
        });
        button7.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.setModuleType(7);
            System.out.println("Modul "+Main.getModuleType());
            if (uff.getUserType() == 1) {
                new ModuleViewStudent();
            } else {
                new ModuleViewTeacher();
            }
        });
        button8.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.setModuleType(8);
            System.out.println("Modul "+Main.getModuleType());
            if (uff.getUserType() == 1) {
                new ModuleViewStudent();
            } else {
                new ModuleViewTeacher();
            }
        });
        button9.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.setModuleType(9);
            System.out.println("Modul "+Main.getModuleType());
            if (uff.getUserType() == 1) {
                new ModuleViewStudent();
            } else {
                new ModuleViewTeacher();
            }
        });
        button10.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.setModuleType(10);
            System.out.println("Modul "+Main.getModuleType());
            if (uff.getUserType() == 1) {
                new ModuleViewStudent();
            } else {
                new ModuleViewTeacher();
            }
        });
        button11.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.setModuleType(11);
            System.out.println("Modul "+Main.getModuleType());
            if (uff.getUserType() == 1) {
                new ModuleViewStudent();
            } else {
                new ModuleViewTeacher();
            }
        });
        button12.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.setModuleType(12);
            System.out.println("Modul "+Main.getModuleType());
            if (uff.getUserType() == 1) {
                new ModuleViewStudent();
            } else {
                new ModuleViewTeacher();
            }
        });
    }
}