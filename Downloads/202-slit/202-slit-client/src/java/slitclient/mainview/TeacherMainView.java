/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.mainview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import slitclient.Main;

/**
 *
 * @author Erlend
 */
public class TeacherMainView extends MainViewMaster {
    
    public TeacherMainView() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnNewInfo = new JButton("Ny info");
        JButton btnCheckProgress = new JButton("Se elevers progresjon");
        
        frame.setVisible(true);
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);
        
        frame.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setBackground(Color.white);
        bottomPanel.add(btnNewInfo);
        bottomPanel.add(btnCheckProgress);
        
        btnNewInfo.addActionListener ((ActionEvent e) -> {
            newInfo();
        });
        
    }  
    
    public void newInfo() {
        JFrame frame2 = new JFrame();
        frame2.setVisible(true);
        frame2.setSize(600,600);
        frame2.setBackground(Color.WHITE);
        // Plasserer applikasjonen midt på skjermen
        frame2.setLocationRelativeTo(null);
        
        JPanel regContainer = new JPanel();
        JPanel regPanel = new JPanel();
        JPanel regBotPanel = new JPanel();
        
        frame2.add(regContainer);
        
        regContainer.setLayout(new BorderLayout());
        regContainer.add(regPanel, BorderLayout.CENTER);
        regContainer.add(regBotPanel, BorderLayout.SOUTH);
        regContainer.setBorder(BorderFactory.createTitledBorder("Ny info"));
        
        JTextArea area1 = new JTextArea("");
        JButton submitBtn = new JButton("Lagre");
        JButton cancelBtn = new JButton("Avbryt");
        
        
        //regPanel.add(area1);
        regBotPanel.add(cancelBtn);
        regBotPanel.add(submitBtn);
        regBotPanel.setBorder(BorderFactory.createTitledBorder("Confirm"));
        
        regPanel.setLayout(new BorderLayout());
        regPanel.add(area1, BorderLayout.CENTER);
        regPanel.setBorder(BorderFactory.createTitledBorder("Skriv her"));
        
        /*
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println(Main.getModuleBean().findModule(1));
                //System.out.println(Main.getUserBean().printUser(1));
            }
        });*/
        
        /*
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
                for (InformationTransfer i : Main.getInformationBean().findInformationEntities(false)) {
                    area1.append(i.getInfoText());
                    
                    System.out.println("fuckerinos");
                }
            }
        });*/
        
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
                Date now = new Date();
                
                Main.getInformationBean().addInfo(area1.getText(), 4, now);
                
                System.out.println("Info added");
            }
        });
        
        
        // Liste ut alle brukere
        /*
        submitBtn.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                //System.out.println(Main.getUserBean().sfindAllUsers());
                
                for (UserTransfer u : Main.getUserBean().sfindAllUsers()) {
                    area1.append(u.getFirstName()+"\n");
                }
            }
        });*/
        
        
        cancelBtn.addActionListener ((ActionEvent e) -> {
            frame2.dispose();
        });
    }
    
    
}