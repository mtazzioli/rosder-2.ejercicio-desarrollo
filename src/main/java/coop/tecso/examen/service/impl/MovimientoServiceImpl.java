package coop.tecso.examen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.MovimientoRepository;
import coop.tecso.examen.repository.base.BaseCrudRepository;
import coop.tecso.examen.service.MovimientoService;
import coop.tecso.examen.service.base.AbstractService;

@Service
public class MovimientoServiceImpl extends AbstractService<Movimiento, MovimientoDto> implements MovimientoService {

	@Autowired
	private MovimientoRepository repository;

	@Override
	public MovimientoDto toDto(Movimiento entity) {
		return this.getModelMapper().map(entity, MovimientoDto.class);
	}

	@Override
	public Movimiento fromDto(MovimientoDto dto) {
		return this.getModelMapper().map(dto, Movimiento.class);
	}

	@Override
	public BaseCrudRepository<Movimiento> getRepository() {
		return repository;
	}

}
