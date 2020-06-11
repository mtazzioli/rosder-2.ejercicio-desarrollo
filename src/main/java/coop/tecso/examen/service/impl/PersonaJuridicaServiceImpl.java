package coop.tecso.examen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.PersonaJuridicaDto;
import coop.tecso.examen.model.PersonaJuridica;
import coop.tecso.examen.repository.PersonaJuridicaRepository;
import coop.tecso.examen.repository.base.BaseCrudRepository;
import coop.tecso.examen.service.PersonaJuridicaService;
import coop.tecso.examen.service.base.AbstractService;

@Service
public class PersonaJuridicaServiceImpl extends AbstractService<PersonaJuridica, PersonaJuridicaDto>
		implements PersonaJuridicaService {

	@Autowired
	private PersonaJuridicaRepository repository;

	@Override
	public PersonaJuridicaDto toDto(PersonaJuridica entity) {
		return this.getModelMapper().map(entity, PersonaJuridicaDto.class);
	}

	@Override
	public PersonaJuridica fromDto(PersonaJuridicaDto dto) {
		return this.getModelMapper().map(dto, PersonaJuridica.class);
	}

	@Override
	public BaseCrudRepository<PersonaJuridica> getRepository() {
		return repository;
	}

}
