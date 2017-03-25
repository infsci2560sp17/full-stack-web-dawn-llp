package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	
	
	
@Entity
public class LipicReqActions {
	
	
	private static final long serialVersionUID = 1L;
	
	public enum ActionType{
		Match,
		Add,
		Delete,
		Update,
		Unknow
		}
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected ActionType actionType;
	protected String url;
	protected Long pictureId;
	protected Long palettesId;
	protected String timeStamp;
	protected Long ownerId;
	
	public LipicReqActions() {
		this.id = Long.MAX_VALUE;
		this.actionType =ActionType.Unknow;
		this.url = null;
		this.pictureId =null;
		this.palettesId = null;
		this.timeStamp =null;
		this.ownerId= null;
	}
	
	//full constructor
	public LipicReqActions( Long id, ActionType actionType, String url, Long pictureId, Long palettesId, String timeStamp, Long ownerId){
		this.id =id;
		this.actionType = actionType;
		this.url = url;
		this.pictureId = pictureId;
		this.palettesId = palettesId;
		this.timeStamp = timeStamp;
		this.ownerId = ownerId;
	}
	
	public Long getId() {return id;}
	public void setId(Long id) {
		this.id = id;
	}
	
	public ActionType getActionType() {return actionType;}
	public void setActionType( ActionType actionType) {
		this.actionType = actionType;
	}
	
	public String getUrl() {return url;}
	public void setUrl(String url){
		this.url = url;
	}
	
	public Long getPictureId() {return pictureId;}
	public void setPictureId( Long pictureId){
		this.pictureId = pictureId;
	}
	
	public Long getPalettesId() {return palettesId;}
	public void setPalettesId( Long palettesId){
		this.palettesId = palettesId;
	}
	
	public String getTimeStamp() {return timeStamp;}
	public void setTimeStamp( String timeStamp){
		this.timeStamp = timeStamp;
	}
	
	public Long getOwnerId() {return ownerId;}
	public void setOwnerId( Long ownerId){
		this.ownerId = ownerId;
	}
	
	
}