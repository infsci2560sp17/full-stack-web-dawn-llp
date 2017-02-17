/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author lili8
 */
@Entity
public class Picture {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String imgURL;
    protected String imgColors;
    protected String paletteTitle;
    protected String author;
    protected String paletteColors;
    protected String paletteSource;
    protected String rating;
    
    //0 parameter constructor
    public Picture() {
        this.id = Long.MAX_VALUE;
        this.imgURL = null;
        this.imgColors = null;
        this.paletteTitle = null;
        this.author = null;
        this.paletteColors = null;
        this.paletteSource = null;
        this.rating = null;
    }
   
    //full parameter constructor
    public Picture(Long id, String imgURL, String imgColors,
            String paletteTitle, String author, String paletteColors,
            String paletteSource, String rating) {
        this.id = id;
        this.imgURL = imgURL;
        this.imgColors = imgColors;
        this.paletteTitle = paletteTitle;
        this.author = author;
        this.paletteColors = paletteColors;
        this.paletteSource = paletteSource;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "[ id=" + this.id + ", picture palette =" + this.imgColors + ","
                + " suggested palette ="+ this.paletteColors+" ]";
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    } 

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
        /**
     * @return the imgURL
     */
    public String getImgURL() {
        return imgURL;
    }
    
    public void setImgURL(String imgURL) {
        this.imgURL=imgURL;
    }
    /**
     * @return palette of the image
     */
    public String getImgColors()
    {
        return this.imgColors;
    }
    
      public void setImgColors(String imgColors) {
        this.imgColors=imgColors;
    }
    
       public String getPaletteSource() {
        return this.paletteSource;
    }
    
    public void setPaletteSource(String paletteSource) {
        this.paletteSource=paletteSource;
    }
    /*
     * @return palette of the image
     */
    public String getPaletteColors()
    {
        return this.paletteColors;
    }
    
      public void setPaletteColors(String paletteColors) {
        this.paletteColors=paletteColors;
    }
      
        public String getPaletteTitle()
    {
        return this.paletteTitle;
    }
    
      public void setPaletteTitle(String paletteTitle) {
        this.paletteTitle=paletteTitle;
    }
          public String getAuthor()
    {
        return this.author;
    }
    
      public void setAuthor(String author) {
        this.author=author;
    }
    
      public String getRating()
    {
        return this.rating;
    }
    
      public void setRating(String rating) {
        this.rating=rating;
    }
}
