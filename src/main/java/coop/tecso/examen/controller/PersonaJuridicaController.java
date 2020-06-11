package coop.tecso.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.PersonaJuridicaDto;
import coop.tecso.examen.model.PersonaJuridica;
import coop.tecso.examen.service.PersonaJuridicaService;
import coop.tecso.examen.service.base.IAbstractService;
import coop.tecso.examen.validation.PersonaJuridicaI;

@RestController
@RequestMapping("/titular/personaJuridica")
public class PersonaJuridicaController extends BaseController<PersonaJuridica, PersonaJuridicaDto> {

	@Autowired
	private PersonaJuridicaService service;

	@Override
	public IAbstractService<PersonaJuridicaDto, PersonaJuridica> getService() {
		return service;
	}

	@Override
	public ResponseEntity<Object> save(@Validated(PersonaJuridicaI.class) @RequestBody PersonaJuridicaDto dto) {
		return super.save(dto);
	}
}
