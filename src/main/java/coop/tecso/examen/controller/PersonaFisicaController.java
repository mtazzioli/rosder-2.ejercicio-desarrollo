package coop.tecso.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.PersonaFisicaDto;
import coop.tecso.examen.exception.BusinessException;
import coop.tecso.examen.model.PersonaFisica;
import coop.tecso.examen.service.PersonaFisicaService;
import coop.tecso.examen.service.base.IAbstractService;
import coop.tecso.examen.validation.PersonaFisicaI;

@RestController
@RequestMapping("/titular/personaFisica")
public class PersonaFisicaController extends BaseController<PersonaFisica, PersonaFisicaDto> {

	@Autowired
	private PersonaFisicaService service;

	@Override
	public IAbstractService<PersonaFisicaDto, PersonaFisica> getService() {
		return service;
	}

	@Override
	public ResponseEntity<Object> save(@Validated(PersonaFisicaI.class) @RequestBody PersonaFisicaDto dto) {
		try {
			return super.save(dto);
		} catch (BusinessException be) {
			return returnResponseBusinessException(be);
		}
	}
}
