package edu.infsci2560.models;

public class PictaReqResult{
	private Long paletteId;
	private String[] colors;
	
	public PictaReqResult(){
	    this.paletteId = Long.MAX_VALUE;
	    this.colors = null;
	}
	
	public PictaReqResult( Long paletteId, String[] colors){
	    this.paletteId = paletteId;
	    this.colors = colors;
	}
	
	public Long getPaletteId() {return paletteId;}
	public void setPaletteId(Long paletteId){
		this.paletteId = paletteId;
	}
	
	public String[] getColors() {return colors;}
	public void setColors(String[] colors){
		this.colors = colors;
	}
}