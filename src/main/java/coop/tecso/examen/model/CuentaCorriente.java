package coop.tecso.examen.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import coop.tecso.examen.enumeration.TipoMoneda;

@Entity
public class CuentaCorriente extends AbstractPersistentObject {

	private static final long serialVersionUID = -8901155893511467206L;

	@OneToMany(targetEntity = Movimiento.class, mappedBy = "cuentaCorriente")
	private List<Movimiento> movimientos;

	@Column(nullable = false, unique = true)
	private Integer numeroCuenta;

	@Column(nullable = false, unique = true, scale = 2)
	private BigDecimal saldo;

	// ENUMS
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoMoneda tipoMoneda;

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
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
