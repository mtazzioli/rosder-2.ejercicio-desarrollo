package coop.tecso.examen.dto.base;

import java.io.Serializable;

public class BaseDto implements Serializable {

	public Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
