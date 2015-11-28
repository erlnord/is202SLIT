package slitclient;


import beans.InformationBeanRemote;
import java.awt.event.ActionListener;
import slit.user.UserBeanRemote;
import javax.ejb.EJB;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author larsmartin
 */
public class Main2 {

    @EJB(mappedName="UserBean")
    private static UserBeanRemote userInstance;
    
    @EJB
    private static InformationBeanRemote infoInstance;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);
        JButton button1 = new JButton("New user");
        JButton button2 = new JButton("New info");
        JButton button3 = new JButton("Return user");
        JButton button4 = new JButton("Remove user");
        JButton button5 = new JButton("Print all users");
        JTextField field = new JTextField("");
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        
        
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                    userInstance.addUser(1, "Lars Martin", "Risdal", "lmrisdal", "passord", "larsrisdal@gmail.com");
                    System.out.println("User added");
            }
        });
        
        button2.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                infoInstance.addInfo("Hei på deg.", 1);
                System.out.println("Info added");
            }
        });
        
        button3.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println(userInstance.printUser(1));
            }
        });
        
        button4.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println("removed: \n" +userInstance.printUser(8));
                userInstance.removeUser(8);
            }
        });
        
        button5.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
                System.out.println(userInstance.sfindAllUsers());
            }
        });
        
        frame.setVisible(true);
        frame.setSize(1300,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        //userInstance.addUser(1, "Lars Martin", "Risdal", "lmrisdal", "passord", "larsrisdal@gmail.com");
        //System.out.println("User added");
        
        //infoInstance.addInfo("Hei på deg.", 1);
        //System.out.println("Info added");
        
        //Boolean result = userInstance.addUser("Lars Martin");
        //System.out.println("Result: "+result);
        
        //Collection users = userInstance.findAllUsers();
        //for (User e : users) {
        //    System.out.println("Found user: " + e);
        //}
        
    }

}

