package slitclient;

import static com.sun.glass.ui.Cursor.setVisible;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import slitclient.ButtonMenu;





public class SettingsWindow extends ButtonMenu {
    JCheckBox show1; 
    JCheckBox show2;
    JLabel label1;
    JLabel label2;
    JPanel panel1;
    
    public SettingsWindow() {
        JFrame frame = new JFrame("Innstillinger");
        panel1 = new JPanel ();
        panel1.setLayout (new GridLayout (2,2));
        frame.add(panel1, BorderLayout.CENTER);
        
        frame.add(topPanel, BorderLayout.NORTH);
        topPanel.setBackground(Color.white);
        frame.add(menuBar);
        frame.setJMenuBar(menuBar);
        label1 = new JLabel ("") ; 
        panel1.add (label1);
                
        label2 = new JLabel("");
        panel1.add (label2);
        
        show1 = new JCheckBox ("show first label");
        panel1.add (show1);
        
        show2 = new JCheckBox ("show second label");
        panel1.add (show2);
        

frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
frame.setSize (1024, 768); 
frame.setResizable(true);
frame.setVisible(true);

       // Event e = new Event ();
       // show1.addItemListener (e);
       // show2.addItemListener (e);
    }
    public class evert implements ItemListener {
        public void itemStateChanged (ItemEvent e){
            if (show1.isSelected () ) {
                label1.setText ("Du har takket ja til mottak av epost fra systemet");
            }else {label1.setText ("Ønsker du å motta epost fra systemet?");
            }
            if (show2.isSelected()){
                label2.setText ("you pushed second checkbox");
            }else {label2.setText ("JAAAAAA");
            
            }
        }
    }

 


        
}
