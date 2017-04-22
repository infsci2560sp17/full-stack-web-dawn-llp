package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.text.SimpleDateFormat;
//import org.springframework.beans.factory.annotation.Autowired;
	
	
	
@Entity
public class LipicUsers {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String name;
	protected String password;
	protected String email;
	protected String dateCreated;
	protected Long[] historyId;
	protected boolean isAdmin;
	
	public LipicUsers() {
		this.id = Long.MAX_VALUE;
		this.name = null;
		this.password = null;
		this.email = null;
		this.dateCreated = null;
		this.historyId = null;
		this.isAdmin = false;
	}
	
	public LipicUsers(String name, String password, String email){
	    this.id = Long.MAX_VALUE;
	    this.name = name;
	    this.password = password;
	    this.email = email;
	    
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    this.dateCreated = formatter.format(new Date());
	    Long[] hId = {new Long(999)};
	    this.historyId = hId;
	    this.isAdmin = false;
	}
	
	public LipicUsers(Long id, String name, String password, String email, String dateCreated, Long[] historyId, boolean isAdmin){
		this.id =id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.dateCreated = dateCreated;
		this.historyId = historyId;
		this.isAdmin = isAdmin;
	}
	
	public Long getId() {return id;}
	public void setId(Long id){
		this.id =id;
	}
	
	public String getName() {return name;}
	public void setName( String name) {
		this.name = name;
	}
	
	public String getPassword() { return password;}
	public void setPassword( String password) {
		this.password = password;
	}
	
	public String getEmail() {return email;}
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getDateCreated() {return dateCreated;}
	public void setDateCreated( String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public Long[] getHistoryId() {return historyId;}
	public void setHistoryId( Long[] historyId) {
		this.historyId = historyId;
	}
	
	public boolean getIsAdmin() {return isAdmin;}
	public void setIsAdmin(boolean isAdmin) {
	    this.isAdmin = isAdmin;
	}
	
}
	
	
	