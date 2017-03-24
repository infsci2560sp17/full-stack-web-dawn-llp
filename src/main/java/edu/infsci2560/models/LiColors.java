package edu.infsci2560.models;

import java.io.Serializable;  

public class LiColors implements Serializable { 
    protected String color;
    
    public LiColors(){
        super();
    }
    public LiColors(String color){
        this.color = color;
    }
    
    public String getColor() { return color;}
    public void setColor( String color) {
        this.color = color;
    }
}
