package coop.tecso.examen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.PersonaFisicaDto;
import coop.tecso.examen.model.PersonaFisica;
import coop.tecso.examen.repository.PersonaFisicaRepository;
import coop.tecso.examen.repository.base.BaseCrudRepository;
import coop.tecso.examen.service.PersonaFisicaService;
import coop.tecso.examen.service.base.AbstractService;

@Service
public class PersonaFisicaServiceImpl extends AbstractService<PersonaFisica, PersonaFisicaDto>
		implements PersonaFisicaService {

	@Autowired
	private PersonaFisicaRepository repository;

	@Override
	public PersonaFisicaDto toDto(PersonaFisica entity) {
		return this.getModelMapper().map(entity, PersonaFisicaDto.class);
	}

	@Override
	public PersonaFisica fromDto(PersonaFisicaDto dto) {
		return this.getModelMapper().map(dto, PersonaFisica.class);
	}

	@Override
	public BaseCrudRepository<PersonaFisica> getRepository() {
		return repository;
	}

}
