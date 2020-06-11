package coop.tecso.examen.enumeration;

import java.math.BigDecimal;

public enum TipoMoneda {
	PESO(-1000), DOLAR(-300), EURO(-150);

	private double descubiertoPermitido;

	public BigDecimal getDescubiertoPermitido() {
		return new BigDecimal(descubiertoPermitido);
	}

	public void setDescubiertoPermitido(double descubiertoPermitido) {
		this.descubiertoPermitido = descubiertoPermitido;
	}

	TipoMoneda(double descubiertoPermitido) {
		this.descubiertoPermitido = descubiertoPermitido;
	}
}
