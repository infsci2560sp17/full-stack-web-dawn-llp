package edu.infsci2560.models;

import java.io.Serializable;  
import java.util.List;  

public class TpictaResp implements Serializable {
    private Tinfo info;
    private List<Tkuler_themes> kuler_themes;
    private List<Tcl_themes> cl_themes;
    
    public TpictaResp() {
        super();
    }
    
    public Tinfo getInfo(){ return info;}
    public void setInfo(Tinfo info){
        this.info = info;
    }
    
    public List<Tkuler_themes> getKuler_themes(){ return kuler_themes;}
    public void setKuler_themes(List<Tkuler_themes> kuler_themes){
        this.kuler_themes = kuler_themes;
    }
    
    public List<Tcl_themes> getCl_themes() { return cl_themes;}
    public void setCl_themes(List<Tcl_themes> cl_themes) {
        this.cl_themes = cl_themes;
    }
}
