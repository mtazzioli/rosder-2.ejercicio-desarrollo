package coop.tecso.examen.model;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PersonaJuridica extends Titular {

	private static final long serialVersionUID = -8901155893511467206L;

	@Column(length = 100)
	private String razonSocial;

	@Column
	private Year anoFundacion;

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Year getAnoFundacion() {
		return anoFundacion;
	}

	public void setAnoFundacion(Year anoFundacion) {
		this.anoFundacion = anoFundacion;
	}

}
