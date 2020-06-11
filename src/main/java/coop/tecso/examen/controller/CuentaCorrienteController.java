package coop.tecso.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.CuentaCorrienteDto;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.service.CuentaCorrienteService;
import coop.tecso.examen.service.base.IAbstractService;

@RestController
@RequestMapping("/cc")
public class CuentaCorrienteController extends BaseController<CuentaCorriente, CuentaCorrienteDto> {

	@Autowired
	private CuentaCorrienteService service;

	@Override
	public IAbstractService<CuentaCorrienteDto, CuentaCorriente> getService() {
		return service;
	}

}
