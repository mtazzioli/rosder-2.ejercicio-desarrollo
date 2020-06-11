package coop.tecso.examen.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonBackReference;

import coop.tecso.examen.dto.base.BaseDto;
import coop.tecso.examen.enumeration.TipoMovimiento;

public class MovimientoDto extends BaseDto {

	private static final long serialVersionUID = 10328694530610928L;

	@JsonBackReference
	private CuentaCorrienteDto cuentaCorriente;

	private Date fecha;

	private String descripción;

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
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
