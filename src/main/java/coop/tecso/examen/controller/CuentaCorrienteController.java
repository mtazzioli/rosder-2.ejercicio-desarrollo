package coop.tecso.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.CuentaCorrienteDto;
import coop.tecso.examen.exception.BusinessException;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.service.CuentaCorrienteService;
import coop.tecso.examen.service.base.IAbstractService;
import coop.tecso.examen.validation.New;

@RestController
@RequestMapping("/cc")
public class CuentaCorrienteController extends BaseController<CuentaCorriente, CuentaCorrienteDto> {

	@Autowired
	private CuentaCorrienteService service;

	@Override
	public IAbstractService<CuentaCorrienteDto, CuentaCorriente> getService() {
		return service;
	}

	@Override
	public ResponseEntity<Object> save(@Validated(New.class) @RequestBody CuentaCorrienteDto dto) {
		try {
			return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
		} catch (BusinessException be) {
			return returnResponseBusinessException(be);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
