package coop.tecso.examen.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import coop.tecso.examen.validation.PersonaFisicaI;

public class PersonaFisicaDto extends TitularDto {

	private static final long serialVersionUID = -3252174062401219952L;

	@NotNull(groups = { PersonaFisicaI.class }, message = "El nombre no puede ser nula para personas físicas")
	@Size(groups = { PersonaFisicaI.class }, max = 80, message = "El nombre no puede contener más de 80 caracteres ")
	private String nombre;

	@NotNull(groups = { PersonaFisicaI.class }, message = "El apellido no puede ser nula para personas físicas")
	@Size(groups = {
			PersonaFisicaI.class }, max = 250, message = "El apellido no puede contener más de 250 caracteres ")
	private String apellido;

	@NotNull(groups = { PersonaFisicaI.class }, message = "El cc no puede ser nulo para personas físicas")
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
