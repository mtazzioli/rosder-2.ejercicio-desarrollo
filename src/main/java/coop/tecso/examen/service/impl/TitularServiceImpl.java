//package coop.tecso.examen.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import coop.tecso.examen.dto.TitularDto;
//import coop.tecso.examen.model.Titular;
//import coop.tecso.examen.repository.TitularRepository;
//import coop.tecso.examen.repository.base.BaseCrudRepository;
//import coop.tecso.examen.service.TitularService;
//import coop.tecso.examen.service.base.AbstractService;
//
//@Service
//public class TitularServiceImpl extends AbstractService<Titular, TitularDto> implements TitularService {
//
//	@Autowired
//	private TitularRepository titularRepository;
//
//	@Override
//	public TitularDto toDto(Titular entity) {
//		return this.getModelMapper().map(entity, TitularDto.class);
//	}
//
//	@Override
//	public Titular fromDto(TitularDto dto) {
//		return this.getModelMapper().map(dto, Titular.class);
//	}
//
//	@Override
//	public BaseCrudRepository<Titular> getRepository() {
//		return titularRepository;
//	}
//
//}
