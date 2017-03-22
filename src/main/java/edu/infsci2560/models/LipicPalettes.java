package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LipicPalettes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String kuler_id;
    private String cl_id;
    private String[] colors;
    private int numLikes;
    private int numDislikes;
    private String kuler_rating;
    private String cl_rating;
    private String author;
    private String dateCreated;
    private String userFirst;           /// user id of the fist creator
//    private String lastRefered;
//    private int numRefered;
    
    public LipicPalettes(){
        super();
    }
    
 //   public LipicPalettes()
    
    public String getId() {return id;}
    public void setId(String id){
        this.id = id;
    }
    
    public String getKuler_id() {return kuler_id;}
    public void setKuler_id(String kuler_id){
        this.kuler_id = kuler_id;
    }
    
    public String getCl_id() {return cl_id;}
    public void setCl_id(String cl_id){
        this.cl_id = cl_id;
    }
    
    public String[] getColors() {return colors;}
    public void setColors( String[] colors){
        this.colors = colors;
    }
    
    public int getNumLikes() {return numLikes;}
    public void setNumLikes(int numLikes){
        this.numLikes = numLikes;
    }
    public void like(){
        this.numLikes = this.numLikes + 1;
    }
    
    public int getNumDislikes(){return numDislikes;}
    public void setNumDislikes(int numDislikes){
        this.numDislikes = numDislikes;
    }
    public void dislike(){
        this.numDislikes = this.numDislikes + 1;
    }
    
    public String getKuler_rating() {return kuler_rating;}
    public void setKuler_rating(String kuler_rating){
        this.kuler_rating = kuler_rating;
    }
    
    public String getCl_rating() {return cl_rating;}
    public void setCl_rating(String cl_rating) {
        this.cl_rating = cl_rating;
    }
    
    public String getAuthor() {return author;}
    public void setAuthor( String author) {
        this.author = author;
    }
    
    public String getDateCreated() {return dateCreated;}
    public void setDateCreated(String dateCreated){
        this.dateCreated = dateCreated;
    }
    
    public String getUserFirst() {return userFirst;}
    public void setUserFirst( String userFirst){
        this.userFirst = userFirst;
    }
    

    
}
