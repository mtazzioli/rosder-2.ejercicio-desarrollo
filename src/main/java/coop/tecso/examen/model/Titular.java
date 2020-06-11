package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public abstract class Titular extends AbstractPersistentObject {

	private static final long serialVersionUID = -8901155893511467206L;

	@Column(nullable = false, unique = true)
	private String rut;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

}
