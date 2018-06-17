package model;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Proizvod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8087226638673213258L;
	private String ime ; 
	private List<Wizard> listaWizarda = new ArrayList<Wizard>();
	private String izvornaAdresa;
	
	public Proizvod(String ime) {
		setIme(ime);
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		if(ime == null) 
			throw new NullPointerException();
		this.ime = ime;
	}
	
	public void addWizard(Wizard w) {
		if(w == null) {
			throw new NullPointerException();
		}
		listaWizarda.add(w);
		
	}
	
	public void removeWizard(Wizard w) {
		listaWizarda.remove(w);
	}
	public List<Wizard> getListaWizarda() {
		return listaWizarda;
	}
	public void setListaWizarda(List<Wizard> listaWizarda) {
		this.listaWizarda = listaWizarda;
	}
	public String getIzvornaAdresa() {
		return izvornaAdresa;
	}
	public void setIzvornaAdresa(String izvornaAdresa) {
		this.izvornaAdresa = izvornaAdresa;
	}

	
}
