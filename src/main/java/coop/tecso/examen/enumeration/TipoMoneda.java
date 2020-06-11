package coop.tecso.examen.enumeration;

public enum TipoMoneda {
	PESO(1000), DOLAR(300), EURO(150);

	private double descubiertoPermitido;

	public double getDescubiertoPermitido() {
		return descubiertoPermitido;
	}

	public void setDescubiertoPermitido(double descubiertoPermitido) {
		this.descubiertoPermitido = descubiertoPermitido;
	}

	TipoMoneda(double descubiertoPermitido) {
		this.descubiertoPermitido = descubiertoPermitido;
	}
}
