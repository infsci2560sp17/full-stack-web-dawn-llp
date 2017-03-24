package edu.infsci2560.models;

import java.io.Serializable;  

public class Tkuler_themes implements Serializable {
    private String title;
    private String[] colors;
    private String id;
    private String author;
    private String url;
    private String rating;
    private String thumb;
    
    public Tkuler_themes(){
        super();
    }
    
    public String getTitle() { return title; }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String[] getColors() { return colors; }
    public void setColors( String[] colors) {
        this.colors = colors;
    }
    
    public String getId() { return id; }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getAuthor() { return author; }
    public void setAuthor( String author ) {
        this.author = author;
    }
    
    public String getUrl() { return url; }
    public void setUrl( String url ){
        this.url = url;
    }
    
    public String getRating() { return rating; }
    public void setRating( String rating ) {
        this.rating = rating;
    }
    
    public String getThumb() { return thumb; }
    public void setThumb( String thumb ) {
        this.thumb = thumb;
    }
}
