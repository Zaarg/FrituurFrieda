package be.vdab.entities;

import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;

public class Saus implements Serializable {
  
	private static final long serialVersionUID = 1L;
	private long nummer;
	private String naam;
	private CopyOnWriteArrayList<String> ingredienten;
	
	public Saus() {
	
	}

	public Saus(long nummer, String naam, java.util.concurrent.CopyOnWriteArrayList<String> ingredienten) {
		this.nummer = nummer;
		this.naam = naam;
		setIngredienten(ingredienten);		 
	}

	public long getNummer() {
		return nummer;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public CopyOnWriteArrayList<String> getIngredienten() {
		return ingredienten;
	}
	
	public void setNummer(long nummer) {
		this.nummer = nummer;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public void setIngredienten(CopyOnWriteArrayList<String> ingredienten) {
		this.ingredienten= ingredienten;	
	}
	
	public void addIngredient(String ingredient) {
		this.ingredienten.add(ingredient);	
	}
}
