package edu.infsci2560.models;


import java.io.Serializable;  

public class Tcl_themes implements Serializable {
    private String id;
    private String title;
    private String userName;
    private int numViews;
    private int numVotes;
    private int numComments;
    private int numHearts;
    private int rank;
    private String dateCreated;
    private String[] colors;
    private String description;
    private String url;
    private String imageUrl;
    private String badgeUrl;
    private String apiUrl;
    private int rating;
    private String author;
    private String badge;
    private String thumb;
    
    public Tcl_themes(){
        super();
    }
    
    public String getId() {return id;}
    public void setId(String id){
        this.id =id;
    }
    
    public String getTitle() {return title;}
    public void setTitle( String title){
        this.title = title;
    }
    
    public String getUserName() {return userName;}
    public void setUserName( String userName) {
        this.userName = userName;
    }
    
    public int getNumViews() {return numViews;}
    public void setNumViews(int numViews) {
        this.numViews = numViews;
    }
    
    public int getNumVotes() {return numVotes;}
    public void setNumVotes(int numVotes) {
        this.numVotes = numVotes;
    }
    
    public int getNumComments() {return numComments;}
    public void setNumComments( int numComments) {
        this.numComments = numComments;
    }
    
    public int getNumHearts() {return numHearts;}
    public void setNumHearts( int numHearts){
        this.numHearts = numHearts;
    }
    
    public int getRank() {return rank;}
    public void setRank( int rank) {
        this.rank = rank;
    }
    
    public String getDateCreated() {return dateCreated;}
    public void setDateCreated( String dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    public String[] getColors() {return colors;}
    public void setColors( String[] colors) {
        this.colors = colors;
    }
    
    public String getDescription() {return description;}
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getUrl() {return url;}
    public void setUrl(String url){
        this.url = url;
    }
    
    public String getImageUrl() {return imageUrl;}
    public void setImageUrl( String imageUrl){
        this.imageUrl = imageUrl;
    }
    
    public String getBadgeUrl() {return badgeUrl;}
    public void setBadgeUrl(String badgeUrl){
        this.badgeUrl = badgeUrl;
    }
    
    public String getApiUrl() {return apiUrl;}
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
    
    public int getRating() {return rating;}
    public void setRating( int rating ){
        this.rating = rating;
    }
    
    public String getAuthor() {return author;}
    public void setAuthor( String author) {
        this.author = author;
    }
    
    public String getBadge() {return badge;}
    public void setBadge( String badge) {
        this.badge = badge;
    }
    
    public String getThumb() {return thumb;}
    public void setThumb( String thumb){
        this.thumb = thumb;
    }

}
