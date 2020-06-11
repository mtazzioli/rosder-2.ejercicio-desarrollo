package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PersonaJuridica extends Titular {

	private static final long serialVersionUID = -8901155893511467206L;

	@Column(length = 100)
	private String razonSocial;

	@Column
	private String anoFundacion;

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getAnoFundacion() {
		return anoFundacion;
	}

	public void setAnoFundacion(String anoFundacion) {
		this.anoFundacion = anoFundacion;
	}

}
