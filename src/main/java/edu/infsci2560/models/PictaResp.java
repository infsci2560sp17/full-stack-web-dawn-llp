package edu.infsci2560.models;

import java.util.List;


public class PictaResp {
    public Info info;
    public List<Kuler_themes> kuler_themes;
    public List<Cl_themes> cl_themes;
    
    public static class Info {
        public String[] colors;
        public String url;
    }
    
    public static class Kuler_themes {
        public String title;
        public String[] colors;
        public String id;
        public String author;
        public String url;
        public int rating;
        public  String thumb;
    
    }
    
    public static class Cl_themes {
        public String id;
        public String title;
        public String userName;
        public int numViews;
        public int numVotes;
        public int numComments;
        public int numHearts;
        public int rank;
        public String dateCreated;
        public String[] colors;
        public String description;
        public String url;
        public String imageUrl;
        public String badgeUrl;
        public String apiUrl;
        public int rating;
        public String author;
        public String badge;
        public String thumb;
    }
}
