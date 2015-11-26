package slitclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Atilla og Admir
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
        JButton label1 = new JButton("Modul 1");
        JButton label2 = new JButton("modul 2");
        JButton label3 = new JButton("Modul 3");
        JButton label4 = new JButton("Modul 4");
        JButton label5 = new JButton("Modul 5");
        JButton label6 = new JButton("Modul 6");
        JButton label7 = new JButton("Modul 7");
        JButton label8 = new JButton("Modul 8");
        JButton label9 = new JButton("Modul 9");
        JButton label10 = new JButton("Modul 10");
        JButton label11 = new JButton("Modul 11");
        JButton label12 = new JButton("Modul 12");
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        panel.add(label10);
        panel.add(label11);
        panel.add(label12);
        frame.add(panel);
        
        label1.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            new ModuleView();
        });
        
        // Lager en actionListener pÃ¥ infoBtn for Ã¥ teste at ting funker
        // Må legges til i hver klasse
        super.infoBtn.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            Main.studentMainView(); 
        });
        
        super.bookingBtn.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            new TimePlan();
        });
        
        super.settingsBtn.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            new SettingsWindow();
        });
        
        super.moduleBtn.addActionListener ((ActionEvent e) -> {
            frame.dispose();
            new ModuleWindow();
        });
        
        
    }
    
}


