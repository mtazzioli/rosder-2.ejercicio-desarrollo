package coop.tecso.examen.enumeration;

public enum TipoMovimiento {
	DEBITO(false), CREDITO(true);

	private Boolean aumentaSaldo;

	public Boolean getAumentaSaldo() {
		return aumentaSaldo;
	}

	public void setAumentaSaldo(Boolean aumentaSaldo) {
		this.aumentaSaldo = aumentaSaldo;
	}

	TipoMovimiento(Boolean aumentaSaldo) {
		this.aumentaSaldo = aumentaSaldo;
	}
}
