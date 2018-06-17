package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Workspace implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6117543124483989686L;

	private List<Proizvod> listaProizvoda = new ArrayList<Proizvod>();
	
	private File lokacija = null;

	public File getLokacija() {
		return lokacija;
	}


	public void setLokacija(File lokacija) {
		this.lokacija = lokacija;
	}


	public Workspace() {
		
	}
	
	
	public List<Proizvod> getListaProizvoda() {
		return listaProizvoda;
	}


	public void setListaProizvoda(List<Proizvod> listaProizvoda) {
		this.listaProizvoda = listaProizvoda;
	}


	public void addProizvod(Proizvod p) {
		if( p == null)
			throw new NullPointerException();
		listaProizvoda.add(p);
	}

	public void removeProizvod(Proizvod p) {
		listaProizvoda.remove(p);
	}
	
	
	
	

	
}
