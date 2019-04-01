/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathi
 */
public class BildForm {
    public List<String> errors = new ArrayList<>();
    
    private String beschreibung;
    private byte[] bild;
    private long id = 0;
    

    public List<String> getErrors(){
        return errors;
    }
    public void setErrors(List<String> errors){
        this.errors = errors;
    }
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
    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return id;
    }
    
    public void checkValues() {
        this.errors = new ArrayList<>();
        if (bild == null) {
            this.errors.add("Lade erst ein Bild hoch.");
        }
        if (beschreibung == null || beschreibung.equals("")) {
            beschreibung = "";
            this.errors.add("Gib erst eine Beschreibung ein!");
        }
        
    }
}
