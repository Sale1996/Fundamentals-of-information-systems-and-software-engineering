package model;
import java.io.Serializable;



public class Parametar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8729360030011175252L;
	private String parameter_name;
	private Boolean readOnly=false;
	private Boolean changeable=false;
	private Boolean obavezan=false;
	private Boolean vidljiv=false;
	private String data_type;
	private Object value;

	
	public Boolean getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(Boolean readOnly) {
		this.readOnly = readOnly;
	}

	public Boolean getChangeable() {
		return changeable;
	}

	public void setChangeable(Boolean changeable) {
		this.changeable = changeable;
	}

	public Boolean getObavezan() {
		return obavezan;
	}

	public void setObavezan(Boolean obavezan) {
		this.obavezan = obavezan;
	}

	public Boolean getVidljiv() {
		return vidljiv;
	}

	public void setVidljiv(Boolean vidljiv) {
		this.vidljiv = vidljiv;
	}

	public Parametar(String id) {
		this ( id , null );
	}

	public Parametar(String parameter_name, String data_type/*, ImageIcon value*/) {		
		setParameter_name(parameter_name);
		setData_type(data_type);
		//setValue(value);
	}


	
	
	
	public String getParameter_name() {
		return parameter_name;
	}

	public void setParameter_name(String parameter_name) {
		this.parameter_name = parameter_name;
	}




	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}



}
