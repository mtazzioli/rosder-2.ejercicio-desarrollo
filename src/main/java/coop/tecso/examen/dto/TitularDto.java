package coop.tecso.examen.dto;

import coop.tecso.examen.dto.base.BaseDto;

public abstract class TitularDto extends BaseDto {

	private static final long serialVersionUID = 10328694530610928L;

	private String rut;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

}
