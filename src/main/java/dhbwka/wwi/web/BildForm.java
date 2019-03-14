/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

/**
 *
 * @author mathi
 */
public class BildForm {
    private String beschreibung = "";
    private byte[] bild = null;
    public static int id;
    

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String comment) {
        this.beschreibung = comment;
    }
    
    public byte[] getBild(){
        return bild;
    }
    public void setBild(byte[] bild) {
        this.bild = bild;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
}
