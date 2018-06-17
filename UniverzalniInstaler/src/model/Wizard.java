package model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class Wizard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1225255373033302035L;
	private  String ime;
	private Parametar listaParametara;
	
	

	
	private List<Parametar> parametri = new ArrayList<Parametar>();	

	

	public Wizard(String ime) {	
       
		setIme(ime);
	}
	
	
	
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		if ( ime == null)
			throw new NullPointerException();	
		this.ime = ime;
	}
	
	public Parametar getListaParametara() {
		
		return listaParametara;
	}
	public void setListaParametara(Parametar listaParametara) {
		if  ( listaParametara == null) 
			throw new NullPointerException();
		this.listaParametara = listaParametara;
	}

	
	public List<Parametar> getParametri() {
		return parametri;
	}


	public void setParametri(List<Parametar> parametri) {
		this.parametri = parametri;
	}



	
	public void addParametar(Parametar p) {
		if(p == null) {
			throw new NullPointerException();
		}
		parametri.add(p);
		
	}
	
	public void removeParametar(Parametar p) {
		parametri.remove(p);
	}
	
	
	
	
	
	
	
	
}
