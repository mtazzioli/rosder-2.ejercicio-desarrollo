package coop.tecso.examen.model;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;

import coop.tecso.examen.enumeration.TipoMovimiento;

@Entity
public class Movimiento extends AbstractPersistentObject {

	private static final long serialVersionUID = 8500083257649913922L;

	@ManyToOne
	@JoinColumn(name = "cuentaCorriente_id", nullable = false)
	private CuentaCorriente cuentaCorriente;

	@CreatedDate
	private Instant fecha;

	@Length(max = 200)
	private String descripción;

	@Column(nullable = false, scale = 2)
	private BigDecimal importe;

	// ENUMS
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoMovimiento tipoMovimiento;

	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public Instant getFecha() {
		return fecha;
	}

	public void setFecha(Instant fecha) {
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
