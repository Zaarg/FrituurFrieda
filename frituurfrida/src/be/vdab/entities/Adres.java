package be.vdab.entities;

import java.io.Serializable;

public class Adres implements Serializable {

	private static final long serialVersionUID = 1L;
	private String straat;
	private String huisNr;
	private Gemeente gemeente;

	public String getStraat() {
		return straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public Gemeente getGemeente() {
		return gemeente;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}

	public void setGemeente(Gemeente gemeente) {
		this.gemeente = gemeente;
	}

}