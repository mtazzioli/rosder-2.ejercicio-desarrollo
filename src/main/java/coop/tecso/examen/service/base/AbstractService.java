package coop.tecso.examen.service.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import coop.tecso.examen.dto.base.BaseDto;
import coop.tecso.examen.model.AbstractPersistentObject;
import coop.tecso.examen.repository.base.BaseCrudRepository;

public abstract class AbstractService<T extends AbstractPersistentObject, U extends BaseDto> {

	private ModelMapper modelMapper = new ModelMapper();

	public abstract U toDto(T entity);

	public List<U> toListDto(List<T> entityList) {
		List<U> returnList = new ArrayList<U>();
		if (entityList != null && entityList.size() > 0) {
			entityList.forEach(e -> {
				returnList.add(this.toDto(e));
			});
		}
		return returnList;
	}

	public abstract T fromDto(U dto);

	public abstract BaseCrudRepository<T> getRepository();

	public U getOne(Long id) throws Exception {
		try {
			T entity = this.getRepository().findFirstById(id);
			return toDto(entity);
		} catch (Exception e) {
			throw new Exception("Error en el getOne, no es posible obtener objeto en " + this.getRepository().getClass()
					+ " con id: " + id + " o error en el toDto");
		}
	}

	public T save(U dto) {
		T entity = this.fromDto(dto);
		return this.getRepository().save(entity);
	}

	public T delete(U dto) {
		T entity = this.fromDto(dto);
		return this.getRepository().save(entity);
	}

	public ModelMapper getModelMapper() {
		return this.modelMapper;
	}

	public List<U> getAll() {
		List<U> list = new ArrayList<U>();
		List<T> listT = this.getRepository().findAll();
		if (listT != null && !listT.isEmpty()) {
			list = listT.stream().map(e -> toDto(e)).collect(Collectors.toList());
		}
		return list;
	}

}
