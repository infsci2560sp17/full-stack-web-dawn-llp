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
    protected String paletteURL;
    protected String rating;
    
    //0 parameter constructor
    public Picture() {
        this.id = Long.MAX_VALUE;
        this.imgURL = null;
        this.imgColors = null;
        this.paletteTitle = null;
        this.author = null;
        this.paletteColors = null;
        this.paletteURL = null;
        this.rating = null;
    }
   
    //full parameter constructor
    public Picture(Long id, String url1, String colors1,
            String title, String authors, String colors2,
            String url2, String rates) {
        this.id = id;
        this.imgURL = url1;
        this.imgColors = colors1;
        this.paletteTitle = title;
        this.author = authors;
        this.paletteColors = colors2;
        this.paletteURL = url2;
        this.rating = rates;
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
     * @return the imgURL
     */
    public String getimgURL() {
        return imgURL;
    }

    /**
     * @return palette of the image
     */
    public String getimgColors()
    {
        return this.imgColors;
    }
    
    /**
     * @param url1 for user picture url
     * @param colors1 for user picture dominant colors, default 6
     * @param title for palette title
     * @param authors for palette author
     * @param colors2  for palette colors
     * @param url2  for palette url
     * @param rates for palette rating
     */
    public void setimgProperties(String url1, String colors1,
            String title, String authors, String colors2,
            String url2, String rates)
    {
//        use 3rd party API to get imgColors, imgURL ,paletteTitle;
//    ,author,paletteColors[];paletteURL;
    imgURL=url1;
    imgColors=colors1;
    paletteTitle=title;
    author=authors;
    paletteColors=colors2;
    paletteURL=url2;
    rating=rates;  
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

}
