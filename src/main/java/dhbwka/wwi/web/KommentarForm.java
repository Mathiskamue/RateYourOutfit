/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author mathi
 */
public class KommentarForm {
    private String name = "";
    private String comment = "";
    private byte[] bild = null;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public byte[] getBild(){
        return bild;
    }
    public void setBild(byte[] bild) {
        this.bild = bild;
    }
    
    
    
}
