/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.user;

import java.io.Serializable;

//ROLESALLOWED

/**
 *
 * @author larsmartin
 */
public class UserTransfer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int UserID;
    private int UserType;
    private String FirstName;
    private String LastName;
    private String UserName;
    private String PassPhrase;
    private String Email;
    private String UserTypeTxt;
    
    public UserTransfer(int UserID) {
        this.UserID = UserID;
    }
    
    public UserTransfer (int UserID, int UserType, String FirstName,
            String LastName, String UserName, String PassPhrase,
            String Email) {
   
        this.UserID = UserID;
        this.UserType = UserType;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.PassPhrase = PassPhrase;
        this.Email = Email;
        
        //Lager en string som forteller hvilken type brukeren er.
        if (UserType == 1) {
            this.UserTypeTxt = "Student";
        }
        else if (UserType == 2)
            this.UserTypeTxt = "Teacher";
        else
            this.UserTypeTxt = "Administrator";
    }

    public int getUserType() {
        return UserType;
    }

    public void setUserType(int UserType) {
        this.UserType = UserType;
    }
    
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassPhrase() {
        return PassPhrase;
    }

    public void setPassPhrase(String PassPhrase) {
        this.PassPhrase = PassPhrase;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    
    /*
    @Override
    public String toString() {
        return "Id: " + UserID + "\nUsertype: " + UserTypeTxt + 
                "\nFirstName: " + FirstName + 
                "\nLastName: " + LastName + "\nUsername: " + UserName +
                "\nEmail: " + Email;
    }*/
    @Override
    public String toString() {
        return FirstName + " " + LastName;
    }

}
