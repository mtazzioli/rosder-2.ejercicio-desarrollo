package coop.tecso.examen.dto;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import coop.tecso.examen.dto.base.BaseDto;
import coop.tecso.examen.enumeration.TipoMovimiento;
import coop.tecso.examen.validation.New;

public class MovimientoDto extends BaseDto {

	private static final long serialVersionUID = 10328694530610928L;

    @JsonBackReference
	private CuentaCorrienteDto cuentaCorriente;

	private Instant fecha;

	@Size(groups = { New.class }, max = 200, message = "La descripcion no puede contener más de 200 caracteres ")
	private String descripcion;

	@Min(groups = { New.class }, value = 0, message = "El importe de los movimientos tiene que ser mayor a 0")
	private BigDecimal importe;

	// ENUMS
	@Enumerated(EnumType.STRING)
	private TipoMovimiento tipoMovimiento;

	public CuentaCorrienteDto getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorrienteDto cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public Instant getFecha() {
		return fecha;
	}

	public void setFecha(Instant fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

}
