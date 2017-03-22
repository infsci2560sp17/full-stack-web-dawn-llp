package edu.infsci2560.models;

public class LipicResult {
    private String[] colors;
    private int numLikes;
    private int numDislikes;
    private String url;
    
    public LipicResult(){
        super();
    }
    public LipicResult(String[] colors, int likes, int dislikes, String url){
        this.colors = colors;
        this.numLikes = likes;
        this.numDislikes = dislikes;
        this.url = url;
    }
    
    public String[] getColors() {return colors;}
    public int getnumLikes() {return numLikes;}
    public int getnumDislikes() {return numDislikes;}
    public String getUrl() {return url;}
}
