/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Trygve Åse Lunde
 */
@Entity
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BookingID")
    private int id;
    private String Dag;
    private String Info;
    private String Studenter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDag() {
        return Dag;
    }

    public void setDag(String Dag) {
        this.Dag = Dag;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public String getStudenter() {
        return Studenter;
    }

    public void setStudenter(String Studenter) {
        this.Studenter = Studenter;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Booking other = (Booking) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Dag, other.Dag)) {
            return false;
        }
        if (!Objects.equals(this.Info, other.Info)) {
            return false;
        }
        if (!Objects.equals(this.Studenter, other.Studenter)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", Dag=" + Dag + ", Info=" + Info + ", Studenter=" + Studenter + '}';
    }

 

   

    
    

    
    

    
  

    

  
    

    
    
}
