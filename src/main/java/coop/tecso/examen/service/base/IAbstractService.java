package coop.tecso.examen.service.base;

import java.util.List;

import coop.tecso.examen.dto.base.BaseDto;
import coop.tecso.examen.model.AbstractPersistentObject;

public interface IAbstractService<D extends BaseDto, E extends AbstractPersistentObject> {

	public E save(D dto);

	public D toDto(E entity);

	public E fromDto(D dto);

	public D getOne(Long id) throws Exception;

	public List<D> getAll() throws Exception;

	public void delete(Long id) throws Exception;

}
