package coop.tecso.examen.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import coop.tecso.examen.dto.base.BaseDto;
import coop.tecso.examen.enumeration.TipoMoneda;
import coop.tecso.examen.validation.New;

public class CuentaCorrienteDto extends BaseDto {

	private static final long serialVersionUID = 10328694530610928L;

	private List<MovimientoDto> movimientos;

	@NotNull(groups = { New.class }, message = "El número de cuenta no puede ser nulo")
	private Integer numeroCuenta;

	private BigDecimal saldo;

	// ENUMS
	@Enumerated(EnumType.STRING)
	@NotNull(groups = { New.class }, message = "El tipo de moneda no puede ser nulo")
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
