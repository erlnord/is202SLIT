//lastOpp.setPreferredSize(new Dimension(frame.getWidth()/2 -30, 10));
package slitclient;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SettingsWindow extends ButtonMenu {
   JFrame frame = new JFrame("Innstillinger");
   JPanel panel1 = new JPanel(); 
   JLabel jl1;
   JTextField tf1;
   JButton jb1;
   JLabel jl2;
   JComboBox dropdownmeny;
   JButton jb2;
   JLabel jl3;
   JTextField tf2;
   JTextField tf3;
   JTextField tf4;
   JButton jb3;
   
   
    /**
     *
     */
    public SettingsWindow() {
    
    jl1 = new JLabel ("vil du ha varsler videresendt til din personlige epost?");
    tf1 = new JTextField ("skriv inn epost", 45);
    jb1 = new JButton("Opprett Regel");
    jl2 = new JLabel ("velg selv hvor tidlig du skal få varsler");
    String [] dager = {"1 dag" , "2 dager", "3 dager", "4 dager", "5 dager"};
    dropdownmeny = new JComboBox(dager);
    jb2 = new JButton ("Opprett Regel");
    jl3 = new JLabel ("Endre passord?");
    tf2 = new JTextField ("nytt passord", 45);
    tf3 = new  JTextField ("bekreft nytt passord", 45);
    tf4 = new  JTextField ("Nåværende passord", 45);
    jb3 = new JButton ("Skift passord");
        
 
    //hovedramme   
    frame.add(topPanel, BorderLayout.NORTH);
    topPanel.setBackground(Color.white);
    frame.add(menuBar);
    frame.setJMenuBar(menuBar);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1024, 768);
    frame.setLocationRelativeTo(null);
    
    
    JPanel panel1_1 = new JPanel();
    JPanel panel1_2 = new JPanel();
    JPanel panel1_3 = new JPanel();
    
    // setter dimensjoner på det respektive panelet slik at det er halve skjermbredden
    panel1_1.setBorder(BorderFactory.createTitledBorder("Epost"));
    panel1_2.setBorder(BorderFactory.createTitledBorder("Varsling"));
    panel1_3.setBorder(BorderFactory.createTitledBorder("Passord"));

       
    
    //bruker gridlayout på panelene inni hovedpanelet
    panel1_1.setLayout(new FlowLayout());
    panel1_2.setLayout(new FlowLayout());
    panel1_3.setLayout(new FlowLayout());
    
 
    //legger til textfelt i underpanelene
    panel1_1.add (jl1);
    panel1_1.add (tf1);
    panel1_1.add (jb1);
    panel1_2.add (jl2);
    panel1_2.add (dropdownmeny);
    panel1_3.add (jl3);
    panel1_3.add (tf2);
    panel1_3.add (tf3);
    panel1_3.add (tf4);
    panel1_3.add (jb3);
  

    //legger til panel
    
    JPanel container = new JPanel();
    container.setLayout(new GridLayout (3,1));
    container.add (panel1_1);
    container.add (panel1_2);
    container.add (panel1_3);
    frame.add(container);
    
    
    }
}

