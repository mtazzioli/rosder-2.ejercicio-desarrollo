package coop.tecso.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.service.MovimientoService;
import coop.tecso.examen.service.base.IAbstractService;

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
		throw new UnsupportedOperationException();
	}

	@Override
	public ResponseEntity<Object> save(MovimientoDto dto) {
		if (dto.getId() == null) {
			return super.save(dto);
		} else
			throw new UnsupportedOperationException();
	}
}
