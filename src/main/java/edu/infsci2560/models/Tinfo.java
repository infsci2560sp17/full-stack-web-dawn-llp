package edu.infsci2560.models;

import java.io.Serializable;  

public class Tinfo implements Serializable {
        private String[] colors;
        private String url;
        
        public Tinfo() {
            super();
        }
        
        public String[] getColors(){ return colors; }
        public void setColors (String[] colors) {
            this.colors = colors;
        }
        
        public String getUrl() { return url; }
        public void setUrl( String url){
            this.url = url;
        }
        
}
