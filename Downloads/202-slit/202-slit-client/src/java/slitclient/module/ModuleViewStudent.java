/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.module;

import beans.DeliveryTransfer;
import beans.ModuleTransfer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import slitclient.Main;

/**
 *
 * @author GUI: Atilla, funksjonalitet: Lars Martin
 */
public class ModuleViewStudent extends slitclient.ButtonMenu {
    
    JLabel path = new JLabel("Valgt Path:");
    JLabel pathField = new JLabel();
    JFileChooser fileChooser = new JFileChooser();
    
    public ModuleViewStudent () {
    //legger til hovedframen
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
    //lager border rundt hele panel1 med overskrift
    panel1.setBorder(BorderFactory.createTitledBorder("Modul "+Main.getModuleType()));
    // Setter dimensjoner på det respektive panelet slik at det er halve skjermbredden
    panel1.setPreferredSize(new Dimension(frame.getWidth()/2 - 10, 
            frame.getHeight()/2 - 10)); 
    
    JPanel panel1_1 = new JPanel();
    JPanel panel1_2 = new JPanel();
    JPanel panel1_3 = new JPanel();
    
    
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
    textArea1.setEditable(false);
    textArea2.setEditable(false);
    textArea3.setEditable(false);
    
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
    
    // Oppretter en variabel mf av ModuleTransfer for å kunne hente tekst.
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
    
    
    // Panel 2 - OPPLASTING
    
    JPanel panel2 = new JPanel();
    panel2.setLayout(new FlowLayout());
    panel2.setBorder(BorderFactory.createTitledBorder("Opplasting"));//lager border rundt hele panel1 med overskrift
    panel2.setPreferredSize(new Dimension(frame.getWidth()/2 - 10, frame.getHeight())); // setter dimensjoner p� det respektive panelet 
    
    JPanel upperPanel = new JPanel();
    JPanel lowerPanel = new JPanel();
    JTextField uploadTf = new JTextField();
    JButton blaGjennom = new JButton();
    JButton lastOpp = new JButton();
    
    upperPanel.setLayout(new FlowLayout());
    upperPanel.setPreferredSize(new Dimension(frame.getWidth()/2 - 10 - 10, 100)); // setter dimensjoner p� det respektive panelet
    upperPanel.setBorder(BorderFactory.createTitledBorder(""));
    
    lowerPanel.setLayout(new FlowLayout());
    lowerPanel.setPreferredSize(new Dimension(frame.getWidth()/2 - 10 - 10, 450)); // setter dimensjoner p� det respektive panelet 
    lowerPanel.setBorder(BorderFactory.createTitledBorder("KOMMENTAR"));

    JTextArea kommentarTf = new JTextArea();
    lowerPanel.add(kommentarTf); //legger til kommentarfeltet i lowerpanel
    kommentarTf.setPreferredSize(new Dimension(frame.getWidth()/2 - 40, 410)); //setter kommentarboksens st�rrelse i forhold til bredden og h�yden p� framen og de andre komponentene, h�yde etter komma
    
    //kommentarTf.setText(Main.getDeliveryBean().findDelivery(0));
    
    
    
    for (DeliveryTransfer df : Main.getDeliveryBean().findAllDeliveries()) {
        DeliveryTransfer hei = Main.getDeliveryBean().findDelivery(df.getDeliveryID());
        if (Main.getCurrentUserID() == df.getUserID() 
                && Main.getModuleType() == df.getModuleID()) {
            kommentarTf.setText(hei.getFeedback());
            System.out.println(hei.getFeedback());
        }
    }
    
    uploadTf.setEditable(false);
    kommentarTf.setLineWrap(true);
    kommentarTf.setWrapStyleWord(true);
    kommentarTf.setEditable(false);
    
    blaGjennom.setPreferredSize(new Dimension(frame.getWidth()/2 - 40, 20)); //setter button st�rrelse i forhold til bredden og h�yden p� framen og de andre komponentene, h�yde etter komma
    lastOpp.setPreferredSize(new Dimension(frame.getWidth()/2 - 40, 20)); //setter button st�rrelse i forhold til bredden og h�yden p� framen og de andre komponentene, h�yde etter komma

    blaGjennom.setText("Bla gjennom");
    lastOpp.setText("Last opp!");
    
    
    /**
     * Actionlistener for å bla gjennom filer og velge en fil
     */
    blaGjennom.addActionListener ((ActionEvent e) -> {
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            pathField.setText(selectedFile.getAbsolutePath());
            System.out.println(selectedFile.getName());
        }
    });
    
    /**
     * Actionlistener for å laste opp den selekterte filen.
     * For å oppnå dette har vi brukt kode fra Even sitt SLITv3 prosjekt.
     * Ved testing fant vi ut at denne funksjonen ikke støtter opplasting
     * av filer større enn rundt 2 megabyte.
     */
    lastOpp.addActionListener ((ActionEvent e) -> {
        File selectedFile = fileChooser.getSelectedFile();
        try {
                uploadFile(selectedFile);
            }
            catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                                                  ex.getLocalizedMessage(),
                                                  "Problem uploading file:",
                                                  JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
            }
    });
    
    upperPanel.add(blaGjennom); //legger til knappen i upperpanel
    upperPanel.add(path);
    
    upperPanel.add(pathField);//legger til tekstfeltet i upperpanel
    upperPanel.add(lastOpp); //legger til last opp knappen i upperpanel
    
    panel2.add(upperPanel); //legger til upperpanel i panel2
    panel2.add(lowerPanel); //legger til lowerpanel i panel2
    
    JPanel container = new JPanel();
    container.setLayout(new GridLayout(1,2));
    container.add(panel1);
    container.add(panel2);
    
    frame.add(container, BorderLayout.CENTER);
    
    }
    
    /**
     * Metode for å lese inn en fil til et bytearray
     * Denne metoden er hentet fra Even sitt SLITv3 prosjekt.
     * Filen som skal bli lastet opp leses inn i et bytearray, og deretter
     * lagres bytearrayet i databasen som en BLOB.
     * 
     * @param file
     * @return
     * @throws IOException 
     */
    private byte[] readFile(File file) throws IOException {
        long longSize = (int) file.length();
        if (longSize > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("File is too large to upload");
        }
        int size = (int) longSize;
        byte[] content = new byte[size];
        InputStream in = new FileInputStream(file);

        int bytesRead = 0;
        while (bytesRead < size) {
            int n = in.read(content, bytesRead, size - bytesRead);
            System.out.format("Read %d (total %d) bytes of %d\n",
                              n, n + bytesRead, size);
            if (n == -1) {
                System.out.println("EOF");
                break;
            }
            bytesRead += n;
        }
        in.close();
        return content;
    }
    
    /**
     * Metode for å laste opp fil.
     * Denne metoden tar en fil som input og laster opp i databasen.
     * Her kjøres metodene readFile som gjør en fil om til bytearray og deretter
     * kjøres metoden addDelivery fra DeliveryBean som legger til i databasen.
     * @param file
     * @throws IOException 
     */
    private void uploadFile(File file) throws IOException {
        String filename = file.getName();
        System.out.println("");
        System.out.println("Uploading file" + filename);
        byte[] content = readFile(file);
        System.out.println("Create file transfer object");
        Main.getDeliveryBean().addDelivery(1, "", content, 
                Main.getCurrentUserID(), Main.getModuleType(), file.getName());
    }
    
}
    
