/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;


/**
 *
 * @author Trygve Åse Lunde
 */
    

public class BookingTransfer implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private int id;
    private String Dag;
    private String Info;
    private String Studenter;

        public BookingTransfer(int id, String Dag, String Info, String Studenter) {
            this.id = id;
            this.Dag = Dag;
            this.Info = Info;
            this.Studenter = Studenter;
        }
    
    

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
        public String toString() {
            return "Booking{" + "id=" + id + ", Dag=" + Dag + ", Info=" + Info + ", Studenter=" + Studenter + '}';
        }
    
    
}
    
