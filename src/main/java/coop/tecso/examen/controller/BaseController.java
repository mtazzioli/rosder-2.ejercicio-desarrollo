package coop.tecso.examen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import coop.tecso.examen.dto.base.BaseDto;
import coop.tecso.examen.model.AbstractPersistentObject;
import coop.tecso.examen.service.base.IAbstractService;

public abstract class BaseController<E extends AbstractPersistentObject, D extends BaseDto> {

	public abstract IAbstractService<D, E> getService();

	private ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<Object> findAll() {
		try {
			return new ResponseEntity<>(getService().getAll(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.GET)
	public ResponseEntity<Object> getOne(@PathVariable(value = "id") Long id) {
		try {
			return new ResponseEntity<>(getService().getOne(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> save(@RequestBody D dto) {
		try {
			return new ResponseEntity<>(getService().toDto(getService().save(dto)), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		try {
			getService().delete(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ObjectMapper getObjectMapper() {
		return mapper;
	}
}
