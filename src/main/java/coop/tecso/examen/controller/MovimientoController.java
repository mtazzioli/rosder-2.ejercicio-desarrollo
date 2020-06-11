package coop.tecso.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.exception.BusinessException;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.service.MovimientoService;
import coop.tecso.examen.service.base.IAbstractService;
import coop.tecso.examen.validation.New;
import coop.tecso.examen.validation.PersonaJuridicaI;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController extends BaseController<Movimiento, MovimientoDto> {

	@Autowired
	private MovimientoService service;

	@Override
	public IAbstractService<MovimientoDto, Movimiento> getService() {
		return service;
	}

	@Override
	public ResponseEntity<Object> delete(Long id) {
		return new ResponseEntity<>(null, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@Override
	public ResponseEntity<Object> save(@Validated(New.class) @RequestBody MovimientoDto dto) {
		try {
			return new ResponseEntity<>(service.agregarMovimiento(dto), HttpStatus.OK);
		} catch (BusinessException be) {
			return returnResponseBusinessException(be);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
