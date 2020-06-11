package coop.tecso.examen.service.impl;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.exception.BusinessException;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.MovimientoRepository;
import coop.tecso.examen.repository.base.BaseCrudRepository;
import coop.tecso.examen.service.CuentaCorrienteService;
import coop.tecso.examen.service.MovimientoService;
import coop.tecso.examen.service.base.AbstractService;

@Service
public class MovimientoServiceImpl extends AbstractService<Movimiento, MovimientoDto> implements MovimientoService {

	@Autowired
	private MovimientoRepository repository;

	@Autowired
	private CuentaCorrienteService cuentaCorrienteService;

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

	@Override
	@Transactional
	public Movimiento agregarMovimiento(MovimientoDto dto) throws Exception {
		if (dto.getId() == null) {
			dto.setFecha(Instant.now());
			Movimiento m = fromDto(dto);
			cuentaCorrienteService.actualizarSaldo(m);
			repository.save(m);
			return m;
		}
		throw new BusinessException("Los movimientos no pueden modificarse");
	}

	@Override
	public void delete(Long id) throws Exception {
		throw new BusinessException("Los movimientos no pueden eliminarse");
	}

	@Override
	public Movimiento save(MovimientoDto dto) throws Exception {
		throw new BusinessException("Los movimientos no pueden eliminarse", null);
	}
}
