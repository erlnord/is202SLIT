/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.module;

import beans.DeliveryBeanRemote;
import beans.DeliveryTransfer;
import beans.ModuleTransfer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import slit.user.UserTransfer;
import slitclient.ButtonMenu;
import slitclient.Main;

/**
 *
 * @author GUI: Atilla, funksjonalitet: Lars Martin
 */
public class ModuleViewTeacher extends ButtonMenu {
    
    JFileChooser fileChooser = new JFileChooser();
    List<UserTransfer> utList;
    int selectedUser;
    int selectedDelivery;
    JTextArea kommentarTf = new JTextArea();
    
    public ModuleViewTeacher () {
        
    JFrame frame = new JFrame("Module 1");
    frame.add(topPanel, BorderLayout.NORTH);
    topPanel.setBackground(Color.white);
    frame.add(menuBar);
    frame.setJMenuBar(menuBar);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1024, 768);
    frame.setLocationRelativeTo(null);
  
   
    // Panel 1
    JPanel panel1 = new JPanel();    
    panel1.setLayout(new GridLayout(3, 1));
    panel1.setBorder(BorderFactory.createTitledBorder("Modul "+Main.getModuleType()));//lager border rundt hele panel1 med overskrift
    panel1.setPreferredSize(new Dimension(frame.getWidth()/2 - 10, frame.getHeight()/2 - 10)); // setter dimensjoner p� det respektive panelet slik at det er halve skjermbredden
    
    JPanel panel1_1 = new JPanel();
    JPanel panel1_2 = new JPanel();
    JPanel panel1_3 = new JPanel();
    
    JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
    JPanel bottomLeft = new JPanel(new FlowLayout(LEFT));
    JPanel bottomRight = new JPanel (new FlowLayout(LEFT));
    JButton btnLagreLeft = new JButton("Lagre");     
    JButton btnLagreRight = new JButton("Lagre");
    JRadioButton godkjent = new JRadioButton("Godkjent");
    JRadioButton ikkeGodkjent = new JRadioButton("Ikke godkjent");
    
    ButtonGroup bg = new ButtonGroup();
    bg.add(godkjent);
    bg.add(ikkeGodkjent);
    
    frame.add(bottomPanel, BorderLayout.SOUTH);
    bottomPanel.setBackground(Color.white);
    bottomPanel.add(bottomLeft);
    bottomPanel.add(bottomRight);
    bottomLeft.add(btnLagreLeft);
    bottomRight.add(btnLagreRight);
    bottomRight.add(godkjent);
    bottomRight.add(ikkeGodkjent);
    
    godkjent.setMnemonic(KeyEvent.VK_C);
    ikkeGodkjent.setMnemonic(KeyEvent.VK_C); 
    
    panel1_1.setBorder(BorderFactory.createTitledBorder("Info"));
    panel1_2.setBorder(BorderFactory.createTitledBorder("Ressurser"));
    panel1_3.setBorder(BorderFactory.createTitledBorder("Godkjenning/læringsmål"));
    
    
    JTextArea textArea1 = new JTextArea();
    JTextArea textArea2 = new JTextArea();
    JTextArea textArea3 = new JTextArea();    
    
    //bruker gridlayout p� panelene inni hovedpanelet
    panel1_1.setLayout(new GridLayout(1, 1));
    panel1_2.setLayout(new GridLayout(1, 1));
    panel1_3.setLayout(new GridLayout(1, 1));
    textArea1.setEditable(true);
    textArea2.setEditable(true);
    textArea3.setEditable(true);
    
    textArea1.setLineWrap(true);
    textArea1.setWrapStyleWord(true);
    textArea2.setLineWrap(true);
    textArea2.setWrapStyleWord(true);
    textArea3.setLineWrap(true);
    textArea3.setWrapStyleWord(true);
    
    //legger til textfelt i underpanelene
    
    JScrollPane scroll1 = new JScrollPane(textArea1);
    JScrollPane scroll2 = new JScrollPane(textArea2);
    JScrollPane scroll3 = new JScrollPane(textArea3);
    
    panel1_1.add(scroll1);
    panel1_2.add(scroll2);
    panel1_3.add(scroll3);
    
    // Oppretter en variabel mf av ModuleTransfer for å kunne sette tekst.
    ModuleTransfer mf = Main.getModuleBean().findModule(Main.getModuleType());
    textArea1.setText(mf.getModuleDescription()); // Henter modulbeskrivelse
    textArea2.setText(mf.getModuleResource()); // Henter modulressurser
    textArea3.setText(mf.getModuleApproval()); // Henter modulkrav
    
    textArea1.setCaretPosition(0);
    textArea2.setCaretPosition(0);
    textArea3.setCaretPosition(0);
    
    // Legg panelene til i hovedpanel.
    panel1.add(panel1_1);
    panel1.add(panel1_2);
    panel1.add(panel1_3);
    
    // Actionlistener for å oppdatere modulteksten. Tar input fra tre tekstareas
    // som oppdaterer modulen i databasen.
    btnLagreLeft.addActionListener((ActionEvent e) -> {
          Main.getModuleBean().updateModule(Main.getModuleType(), textArea1.getText(), 
                  textArea3.getText(), textArea2.getText(), 4);
          JOptionPane.showMessageDialog(null, "Modultekst oppdatert.");
    });
    
    
    // Panel 2 - Godkjenning
    
    JPanel panel2 = new JPanel();
    panel2.setLayout(new GridLayout(2, 1));
    panel2.setBorder(BorderFactory.createTitledBorder("Godkjenning"));//lager border rundt hele panel1 med overskrift
    panel2.setPreferredSize(new Dimension(frame.getWidth()/2 - 10, frame.getHeight()/2 - 10)); // setter dimensjoner p� det respektive panelet 
    
    JPanel upperPanel = new JPanel();
    JPanel lowerPanel = new JPanel();
    DefaultListModel model = new DefaultListModel();
    JList navneListe = new JList(model);
    
              
    
    navneListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // kan bare velge en
    JScrollPane scrollPane = new JScrollPane(navneListe);
    
    JButton download = new JButton("Last ned");
        
    // Looper gjennom alle brukere for å legge til studenter i listen
    for (UserTransfer u : Main.getUserBean().findAllUsers()) {
        // Hvis bruker har brukertype = student så legges dem til i listen
        if (u.getUserType() == 1) {
            System.out.println("added "+ u);
            model.addElement(u);
        }
    }
        
    navneListe.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            kommentarTf.setText("");
            int index = navneListe.getSelectedIndex();
            UserTransfer ut = (UserTransfer)model.getElementAt(index);
            selectedUser = ut.getUserID();
            System.out.println(selectedUser);
            
            for (DeliveryTransfer df : Main.getDeliveryBean().findAllDeliveries()) {
                if (df.getUserID() == selectedUser && 
                        df.getModuleID() == Main.getModuleType()) {
                    selectedDelivery = df.getDeliveryID();
                    System.out.println("Selected user's delivery is: "
                            +selectedDelivery);
                    kommentarTf.setText(Main.getDeliveryBean()
                .findDelivery(selectedDelivery).getFeedback());
                }
            }
        }
    });
    
    btnLagreRight.addActionListener ((ActionEvent e) -> {
        Main.getDeliveryBean().updateModule(selectedDelivery, 
                kommentarTf.getText());
        JOptionPane.showMessageDialog(null, "Feedback oppdatert.");
        
        if (ikkeGodkjent.isSelected()) {
            Main.getDeliveryBean().setStatus(selectedDelivery, 3);
        } else if (godkjent.isSelected()) {
            Main.getDeliveryBean().setStatus(selectedDelivery, 2);
        }
    });
    
    upperPanel.setLayout(new BorderLayout());
    upperPanel.setBorder(BorderFactory.createTitledBorder("Studenter"));
        
    scrollPane.setVisible(true);
    upperPanel.add(new JScrollPane(navneListe),BorderLayout.CENTER);
    upperPanel.add(download, BorderLayout.SOUTH);

    lowerPanel.setLayout(new FlowLayout());
    lowerPanel.setBorder(BorderFactory.createTitledBorder("KOMMENTAR"));
    
    kommentarTf.setPreferredSize(new Dimension
        (frame.getWidth()/2 - 30, frame.getHeight() - 20));
    lowerPanel.add(kommentarTf); //legger til kommentarfeltet i lowerpanel
    
    kommentarTf.setLineWrap(true);
    kommentarTf.setWrapStyleWord(true);
    kommentarTf.setEditable(true);
    
    panel2.add(upperPanel); //legger til upperpanel i panel2
    panel2.add(lowerPanel); //legger til lowerpanel i panel2
    
    JPanel container = new JPanel();
    container.setLayout(new GridLayout(1,2));
    container.add(panel1);
    container.add(panel2);
    
    frame.add(container, BorderLayout.CENTER);
    
    // Actionlistener for å laste ned en modul. Foreløpig blir bare
    // delivery med ID = 8 lastet ned. Planen er at man skal kunne velge
    // fra en JList over studenter som har levert og så laste ned deres 
    // innlevering.
    download.addActionListener ((ActionEvent e) -> {
        DeliveryTransfer dt = Main.getDeliveryBean().findDelivery(selectedDelivery);
            try {
                // Kjører metoden downloadDelivery
                downloadDelivery(dt);
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
    });
}
    
    /**
     * Metode for å laste ned en innlevering. Denne metoden kjøres når
     * download-knappen trykkes. Denne metoden ble hentet fra Even
     * sitt SLITv3 prosjekt.
     * 
     * @param df
     * @throws IOException 
     */
    private void downloadDelivery(DeliveryTransfer df) throws IOException {
        DeliveryBeanRemote bean = Main.getDeliveryBean();
        DeliveryTransfer ft = bean.findDelivery(df.getDeliveryID());
        fileChooser.setSelectedFile(new File(ft.getFileName()));
        int retval = fileChooser.showSaveDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION)
            saveFile(fileChooser.getSelectedFile(), ft.getDeliveryFile());
    }
    
    /**
     * Metode for å lagre fil til disk.
     * Denne metoden ble hentet fra Even sitt SLITv3 prosjekt.
     * 
     * @param file
     * @param content
     * @throws IOException 
     */
    private void saveFile(File file, byte[] content) throws IOException {
        OutputStream out = new FileOutputStream(file);
        out.write(content);
        out.close();
    }
}
    
