/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import beans.BookingTransfer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Trygve �se Lunde
 */
public class TeacherBooking extends ButtonMenu {
  

 
    public TeacherBooking () {
    //legger til hovedframen
    JFrame frame = new JFrame("Timeplan");
    frame.add(topPanel, BorderLayout.NORTH);
    topPanel.setBackground(Color.white);
    frame.add(menuBar);
    frame.setJMenuBar(menuBar);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1024, 768);
    frame.setLocationRelativeTo(null);
    
    // PANEL 1
    
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(3,5));
    
    JPanel p1_1 = new JPanel();
    JPanel p1_2 = new JPanel();
    JPanel p1_3 = new JPanel();
    
    p1_1.setBorder(BorderFactory.createTitledBorder("Mandag"));
    p1_2.setBorder(BorderFactory.createTitledBorder("Info"));
    p1_3.setBorder(BorderFactory.createTitledBorder("Studenter"));
    
    p1_1.setLayout(new GridLayout(1, 1));
    p1_2.setLayout(new GridLayout(1, 1));
    p1_3.setLayout(new GridLayout(1, 1));
    
    
    JTextArea text1 = new JTextArea();
    text1.setEditable(true);
    text1.setLineWrap(true);
    text1.setWrapStyleWord(true);
    JScrollPane scroll1 = new JScrollPane(text1);
    scroll1.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
   
   
    
    JTextArea text2 = new JTextArea();
    text2.setEditable(true);
    text2.setLineWrap(true);
    text2.setWrapStyleWord(true);
    JScrollPane scroll2 = new JScrollPane(text2);
    scroll2.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    JTextArea text3 = new JTextArea();
    text3.setEditable(false);
    text3.setLineWrap(true);
    text3.setWrapStyleWord(true);
    JScrollPane scroll3 = new JScrollPane(text3);
    scroll3.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    
    p1_1.add(scroll1);
    p1_2.add(scroll2);
    p1_3.add(scroll3);
    
    
    
   
      
    frame.add(p1, BorderLayout.CENTER);
      
    // PANEL 2 .3 rader. Rad 1 "Tirsdag"
      
    
    
      
   JPanel p2_1 = new JPanel();
   JPanel p2_2 = new JPanel();
   JPanel p2_3 = new JPanel();
   
   p2_1.setBorder(BorderFactory.createTitledBorder("Tirsdag"));
   p2_2.setBorder(BorderFactory.createTitledBorder("Info"));
   p2_3.setBorder(BorderFactory.createTitledBorder("Studenter"));
   
   p2_1.setLayout(new GridLayout(1, 1));
    p2_2.setLayout(new GridLayout(1, 1));
    p2_3.setLayout(new GridLayout(1, 1));
   
   JTextArea text4 = new JTextArea();
    text4.setEditable(true);
    text4.setLineWrap(true);
    text4.setWrapStyleWord(true);
    
    JScrollPane scroll4 = new JScrollPane(text4);
    scroll4.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    JTextArea text5 = new JTextArea();
    text5.setEditable(true);
    text5.setLineWrap(true);
    text5.setWrapStyleWord(true);
    JScrollPane scroll5 = new JScrollPane(text5);
    scroll5.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    JTextArea text6 = new JTextArea();
    text6.setEditable(false);
    text6.setLineWrap(true);
    text6.setWrapStyleWord(true);
    JScrollPane scroll6 = new JScrollPane(text6);
    scroll6.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    p2_1.add(scroll4);
    p2_2.add(scroll5);
    p2_3.add(scroll6);
    
    // PANEL 3 rad 2 "Onsdag"
      
    JPanel p3_1 = new JPanel();
    JPanel p3_2 = new JPanel();
    JPanel p3_3 = new JPanel();
    
   p3_1.setBorder(BorderFactory.createTitledBorder("Onsdag"));
   p3_2.setBorder(BorderFactory.createTitledBorder("Info"));
   p3_3.setBorder(BorderFactory.createTitledBorder("Studenter"));
   
   p3_1.setLayout(new GridLayout(1, 1));
    p3_2.setLayout(new GridLayout(1, 1));
    p3_3.setLayout(new GridLayout(1, 1));
    
    JTextArea text7 = new JTextArea();
    text7.setEditable(true);
    text7.setLineWrap(true);
    text7.setWrapStyleWord(true);
    JScrollPane scroll7 = new JScrollPane(text7);
    scroll7.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    JTextArea text8 = new JTextArea();
    text8.setEditable(true);
    text8.setLineWrap(true);
    text8.setWrapStyleWord(true);
    JScrollPane scroll8 = new JScrollPane(text8);
    scroll8.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    JTextArea text9 = new JTextArea();
    text9.setEditable(false);
    text9.setLineWrap(true);
    text9.setWrapStyleWord(true);
    JScrollPane scroll9 = new JScrollPane(text9);
    scroll9.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    p3_1.add(scroll7);
    p3_2.add(scroll8);
    p3_3.add(scroll9);
    
    // Panel 4 rad 3 Torsdag
    
    JPanel p4_1 = new JPanel();
    JPanel p4_2 = new JPanel();
    JPanel p4_3 = new JPanel();
    
    p4_1.setBorder(BorderFactory.createTitledBorder("Torsdag"));
   p4_2.setBorder(BorderFactory.createTitledBorder("Info"));
   p4_3.setBorder(BorderFactory.createTitledBorder("Studenter"));
   
   p4_1.setLayout(new GridLayout(1, 1));
    p4_2.setLayout(new GridLayout(1, 1));
    p4_3.setLayout(new GridLayout(1, 1));
    
    JTextArea text11 = new JTextArea();
    text11.setEditable(true);
    text11.setLineWrap(true);
    text11.setWrapStyleWord(true);
    JScrollPane scroll11 = new JScrollPane(text11);
    scroll11.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    JTextArea text12 = new JTextArea();
    text12.setEditable(true);
    text12.setLineWrap(true);
    text12.setWrapStyleWord(true);
    JScrollPane scroll12 = new JScrollPane(text12);
    scroll12.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    JTextArea text13 = new JTextArea();
    text13.setEditable(false);
    text13.setLineWrap(true);
    text13.setWrapStyleWord(true);
     JScrollPane scroll13 = new JScrollPane(text13);
    scroll13.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
     p4_1.add(scroll11);
    p4_2.add(scroll12);
    p4_3.add(scroll13);
    
   
     
     
  
    
    // Panel 5  1 rad Fredag
    
    
    
    
    JPanel p5_1 = new JPanel();
    JPanel p5_2 = new JPanel();
    JPanel p5_3 = new JPanel();
    
    p5_1.setBorder(BorderFactory.createTitledBorder("Fredag"));
   p5_2.setBorder(BorderFactory.createTitledBorder("Info"));
   p5_3.setBorder(BorderFactory.createTitledBorder("Studenter"));
    
   p5_1.setLayout(new GridLayout(1, 1));
    p5_2.setLayout(new GridLayout(1, 1));
    p5_3.setLayout(new GridLayout(1, 1));
    
     JTextArea text14 = new JTextArea();
    text14.setEditable(true);
    text14.setLineWrap(true);
    text14.setWrapStyleWord(true);
     JScrollPane scroll14 = new JScrollPane(text14);
    scroll14.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    JTextArea text15 = new JTextArea();
    text15.setEditable(true);
    text15.setLineWrap(true);
    text15.setWrapStyleWord(true);
     JScrollPane scroll15 = new JScrollPane(text15);
    scroll15.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    JTextArea text16 = new JTextArea();
    text16.setEditable(false);
    text16.setLineWrap(true);
    text16.setWrapStyleWord(true);
     JScrollPane scroll16 = new JScrollPane(text16);
    scroll16.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    p5_1.add(scroll14);
    p5_2.add(scroll15);
    p5_3.add(scroll16);
    
     p1.add(p1_1);
     p1.add(p2_1);
      p1.add(p3_1);
     p1.add(p4_1);
     p1.add(p5_1);
     
     p1.add(p1_2);
     p1.add(p2_2);
    p1.add(p3_2);
     p1.add(p4_2);
     p1.add(p5_2);
     
     
    p1.add(p1_3);
  
    p1.add(p2_3);
    p1.add(p3_3);
    p1.add(p4_3);
       
    
    
    
    
      p1.add(p5_3);
      
     // Hente å sette tekst i vinduene
      
      BookingTransfer mt = Main.getBookingBean().findBooking(1);
    text1.setText(mt.getDag()); // Henter modulbeskrivelse
    text2.setText(mt.getInfo()); // Henter modulressurser
    text3.setText(mt.getStudenter()); // Henter modulkrav
    
     
    BookingTransfer tt = Main.getBookingBean().findBooking(2);
    text4.setText(tt.getDag()); // Henter modulbeskrivelse
    text5.setText(tt.getInfo()); // Henter modulressurser
    text6.setText(tt.getStudenter()); // Henter modulkrav
    
     
    BookingTransfer ot = Main.getBookingBean().findBooking(3);
    text7.setText(ot.getDag()); // Henter modulbeskrivelse
    text8.setText(ot.getInfo()); // Henter modulressurser
    text9.setText(ot.getStudenter()); // Henter modulkrav
    
     
    BookingTransfer tot = Main.getBookingBean().findBooking(4);
    text11.setText(tot.getDag()); // Henter modulbeskrivelse
    text12.setText(tot.getInfo()); // Henter modulressurser
    text13.setText(tot.getStudenter()); // Henter modulkrav
    
     
    BookingTransfer ft = Main.getBookingBean().findBooking(5);
    text14.setText(ft.getDag()); // Henter modulbeskrivelse
    text15.setText(ft.getInfo()); // Henter modulressurser
    text16.setText(ft.getStudenter()); // Henter modulkrav
     
      
      // ButtomPanel
      
      JPanel p6 = new JPanel();
      
      JButton b6 = new JButton("Oppdater");
      b6.addActionListener ((ActionEvent e) -> {
          Main.getBookingBean().addDag(1,text1.getText(), text2.getText(), text3.getText() );
            Main.getBookingBean().addDag(2,text4.getText(), text5.getText(), text6.getText() );
            Main.getBookingBean().addDag(3, text7.getText(), text8.getText(), text9.getText() );
            Main.getBookingBean().addDag(4, text11.getText(), text12.getText(), text13.getText() );
            Main.getBookingBean().addDag(5, text14.getText(), text15.getText(), text16.getText() );
             System.out.println("Ting ble gjort");
        });
      
      
      
      
      p6.add(b6);
     
      
      frame.add(p6, BorderLayout.SOUTH);
      
    
    
            
    
   
    }
    
}
