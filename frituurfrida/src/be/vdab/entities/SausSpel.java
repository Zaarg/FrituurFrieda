package be.vdab.entities;

import java.io.Serializable;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Resource;
import javax.sql.DataSource;

import be.vdab.dao.SausDAO;

public class SausSpel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final int MAX_BEURTEN = 10;
	private int keerGeraden = 0;
	private String saus,juist;
	private String spelstatus="bezig";
	
	public SausSpel(SausDAO sausDAO) {
		CopyOnWriteArrayList<Saus> sauzen = new CopyOnWriteArrayList<>();
		sauzen = sausDAO.findAll();
		this.saus = sauzen.get(new Random().nextInt(sauzen.size())).getNaam();									// mooie constructie :-) int i = new Random().nextInt(new ArrayList<Saus>((ArrayList)new SausDAO().findAll()).size());
		this.juist = saus.replaceAll(".", ".");
	}
		
	public void raden(String gok) {
		StringBuilder j = new StringBuilder(this.juist);
		for (int i=0; i<this.saus.length(); i++) {
			if (this.saus.toLowerCase().charAt(i) == gok.toLowerCase().charAt(0) && j.charAt(i)!=gok.charAt(0)) {
				 j.setCharAt(i, this.saus.charAt(i));
			} 	
		} 
		if (this.juist.equals(j.toString()) && saus.indexOf(gok.charAt(0))==-1) {
			this.keerGeraden++;
			if (this.keerGeraden == MAX_BEURTEN) {this.spelstatus="verloren";}
		} else {
			this.juist = j.toString();
			if (j.indexOf(".") == -1) {this.spelstatus="gewonnen";}
		}
	}
	
	public void setKeerGeraden(int keerGeraden) {
		this.keerGeraden = keerGeraden;
	}

	public void setJuist(String juist) {
		this.juist = juist;
	}
	
	public int getKeerGeraden() {
		return keerGeraden;
	}

	public String getSaus() {
		return saus;
	}

	public String getJuist() {
		return juist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static int getMaxBeurten() {
		return MAX_BEURTEN;
	}

	public String getSpelstatus() {
		return spelstatus;
	}

	
}