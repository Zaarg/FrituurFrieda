package be.vdab.entities;

import java.io.Serializable;

public class Deur implements Serializable {
  
	private static final long serialVersionUID = 1L;
	private long id;
	private boolean clicked = false;
	private boolean deWareFriet = false;
		
	public Deur(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	public boolean isClicked() {
		return clicked;
	}
	public boolean isDeWareFriet() {
		return deWareFriet;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	public void setDeWareFriet(boolean deWareFriet) {
		this.deWareFriet = deWareFriet;
	}
	
}
