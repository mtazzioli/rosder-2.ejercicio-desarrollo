package coop.tecso.examen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.CuentaCorrienteDto;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.repository.CuentaCorrienteRepository;
import coop.tecso.examen.repository.base.BaseCrudRepository;
import coop.tecso.examen.service.CuentaCorrienteService;
import coop.tecso.examen.service.base.AbstractService;

@Service
public class CuentaCorrienteServiceImpl extends AbstractService<CuentaCorriente, CuentaCorrienteDto>
		implements CuentaCorrienteService {

	@Autowired
	private CuentaCorrienteRepository repository;

	@Override
	public CuentaCorrienteDto toDto(CuentaCorriente entity) {
		return this.getModelMapper().map(entity, CuentaCorrienteDto.class);
	}

	@Override
	public CuentaCorriente fromDto(CuentaCorrienteDto dto) {
		return this.getModelMapper().map(dto, CuentaCorriente.class);
	}

	@Override
	public BaseCrudRepository<CuentaCorriente> getRepository() {
		return repository;
	}

}
