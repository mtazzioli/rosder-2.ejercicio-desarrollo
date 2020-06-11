package coop.tecso.examen.exception;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {

	private List<String> errorMsjs = new ArrayList<String>();

	public BusinessException(String msj) {
		this.errorMsjs.add(msj);
	}

	public BusinessException(List<String> errorMsjs) {
		this.errorMsjs = errorMsjs;
	}

	public BusinessException(String msj, List<String> errorMsjs) {
		super(msj);
		this.errorMsjs = errorMsjs;
	}

	public List<String> getErrorMsjs() {
		return errorMsjs;
	}

	public void setErrorMsjs(List<String> errorMsjs) {
		this.errorMsjs = errorMsjs;
	}

}
