import javax.swing.JFrame*;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;


package slitclient;


public class SettingsWimdow extends ButtonMenu {//extends JFrame?
    JCheckBox show1, show2;
    JLabel1 label1,label2;
    
    public SettingsWindow() {
        setLayout(new GridLayout (2,2));
        
        label1 = new JLabel ("") ; 
        add (label1);
                
        label2 = new JLabel("")
        add (label2);
        
        show1 = new JCheckBox ("show first label");
        add (show1);
        
        show2 = new JCheckBox ("show second label");
        add (show2);
        
        event e = new event ();
        show1.addItemListener (e);
        show2.addItemListener (e);
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

public static void main (String[] args) {   
SettingsWindow gui = new SettingsWindow () ;
gui.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
gui.setSize (600, 600); //1024x768, 800x600
gui.setResizable(true);
gui.setVisible(true);
gui.add(menuBar);
gui.setJMenuBar(menuBar);
gui.setTitle("Instillinger")


}
}