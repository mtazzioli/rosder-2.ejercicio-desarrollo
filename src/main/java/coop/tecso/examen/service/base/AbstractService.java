package coop.tecso.examen.service.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
		Optional<T> entity = this.getRepository().findById(id);
		if (entity.isPresent()) {
			return toDto(entity.get());
		}
		return null;
	}

	public T save(U dto) {
		T entity = this.fromDto(dto);
		return this.getRepository().save(entity);
	}

	public void delete(Long id) throws Exception {
		Optional<T> entity = getRepository().findById(id);
		if (entity.isPresent()) {
			this.getRepository().delete(entity.get());
		} else {
			throw new Exception("No se puede eliminar un objeto inexistente.");
		}
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
