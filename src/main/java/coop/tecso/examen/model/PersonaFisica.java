package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PersonaFisica extends Titular {

	private static final long serialVersionUID = -8901155893511467206L;

	@Column(length = 80)
	private String nombre;

	@Column(length = 250)
	private String apellido;

	@Column
	private String cc;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

}
