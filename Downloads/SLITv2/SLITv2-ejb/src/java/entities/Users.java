/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//ROLESALLOWED

/**
 *
 * @author larsmartin
 */
@Entity
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserID;
    
    private int UserType;
    private String FirstName;
    private String LastName;
    private String UserName;
    private String PassPhrase;
    private String Email;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.UserID;
        hash = 17 * hash + this.UserType;
        hash = 17 * hash + Objects.hashCode(this.FirstName);
        hash = 17 * hash + Objects.hashCode(this.LastName);
        hash = 17 * hash + Objects.hashCode(this.UserName);
        hash = 17 * hash + Objects.hashCode(this.PassPhrase);
        hash = 17 * hash + Objects.hashCode(this.Email);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if (this.UserID != other.UserID) {
            return false;
        }
        if (this.UserType != other.UserType) {
            return false;
        }
        if (!Objects.equals(this.FirstName, other.FirstName)) {
            return false;
        }
        if (!Objects.equals(this.LastName, other.LastName)) {
            return false;
        }
        if (!Objects.equals(this.UserName, other.UserName)) {
            return false;
        }
        if (!Objects.equals(this.PassPhrase, other.PassPhrase)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ id=" + UserID + "  ]";
    }
    
}
