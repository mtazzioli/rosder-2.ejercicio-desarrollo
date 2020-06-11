package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.TitularDto;
import coop.tecso.examen.service.PersonaFisicaService;
import coop.tecso.examen.service.PersonaJuridicaService;

@RestController
@RequestMapping("/titular")
public class TitularController {

	@Autowired
	private PersonaFisicaService personaFisicaService;

	@Autowired
	private PersonaJuridicaService personaJuridicaService;

	@GetMapping("/findAll")
	public ResponseEntity<Object> findAll() {
		try {
			List<TitularDto> list = new ArrayList<TitularDto>();
			list.addAll(personaFisicaService.getAll());
			list.addAll(personaJuridicaService.getAll());
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
