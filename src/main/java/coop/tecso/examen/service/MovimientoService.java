package coop.tecso.examen.service;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.exception.BusinessException;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.service.base.IAbstractService;

public interface MovimientoService extends IAbstractService<MovimientoDto, Movimiento> {

	Movimiento agregarMovimiento(MovimientoDto dto) throws BusinessException;

}
