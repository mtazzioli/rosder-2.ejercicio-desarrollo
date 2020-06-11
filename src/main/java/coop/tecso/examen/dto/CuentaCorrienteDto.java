package coop.tecso.examen.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import coop.tecso.examen.dto.base.BaseDto;
import coop.tecso.examen.enumeration.TipoMoneda;

public class CuentaCorrienteDto extends BaseDto {

	private static final long serialVersionUID = 10328694530610928L;

	private List<MovimientoDto> movimientos;

	@NotNull(message = "El número de cuenta no puede ser nulo")
	private Integer numeroCuenta;

	private BigDecimal saldo;

	// ENUMS
	@Enumerated(EnumType.STRING)
	private TipoMoneda tipoMoneda;

	public List<MovimientoDto> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoDto> movimientos) {
		this.movimientos = movimientos;
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public TipoMoneda getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(TipoMoneda tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

}
