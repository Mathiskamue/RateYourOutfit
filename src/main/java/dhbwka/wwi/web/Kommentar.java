/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author mathi
 */
@Entity 
public class Kommentar implements Serializable{
    
    @Id
    @GeneratedValue
    private long id = 0;
    
    private String name = "";
    
    @Lob
    private String comment="";
    
    @Lob
    private byte[] picture;
    
    public Kommentar(){
        
    }
    
    public Kommentar(String name,String comment, byte[] picture){
        this.name = name;
        this.comment= comment;
        this.picture = picture;
    }
    
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    public byte[] getPicture(){
        return picture;
    }
    public void setPicture(byte[] picture){
        this.picture = picture;
    }
    
    @Override
    public String toString(){
        return this.name + " sagt " + this.comment;
    }
}
