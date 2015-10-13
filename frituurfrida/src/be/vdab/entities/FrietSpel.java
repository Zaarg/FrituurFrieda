package be.vdab.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FrietSpel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final List<Deur> frieten = new ArrayList<>();
	
	
	public FrietSpel() {
		for (int id = 1; id<=7; id++) {
			frieten.add(new Deur(id));
		}
		frieten.get((int)(Math.random()*7)).setDeWareFriet(true);
	}
	
	public Iterable<Deur> findAll() {
		  return frieten;
	}
	
	public Deur read(long id) {
		  return frieten.get((int) (id-1));
	}
	
	public void kiezen(long id) { 
		frieten.get((int) (id-1)).setClicked(true);
	}
	
	public boolean isDeWareFriet(long id){
		return frieten.get((int) (id-1)).isDeWareFriet();
	}
}