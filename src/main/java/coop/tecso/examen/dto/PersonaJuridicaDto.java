package coop.tecso.examen.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import coop.tecso.examen.validation.PersonaJuridicaI;

public class PersonaJuridicaDto extends TitularDto {

	private static final long serialVersionUID = -7297733627219717802L;

	@NotNull(groups = { PersonaJuridicaI.class }, message = "La razón social no puede ser nula para personas jurídicas")
	@Size(groups = {
			PersonaJuridicaI.class }, max = 100, message = "La razón social no puede contener más de 100 caracteres ")
	private String razonSocial;

	@Pattern(groups = {
			PersonaJuridicaI.class }, regexp = "[0-9]{4}", message = "El formato del año de fundación es incorrecto, se esperan 4 números en formato AAAA")
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
