package coop.tecso.examen.service;

import coop.tecso.examen.dto.CuentaCorrienteDto;
import coop.tecso.examen.exception.BusinessException;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.service.base.IAbstractService;

public interface CuentaCorrienteService extends IAbstractService<CuentaCorrienteDto, CuentaCorriente> {

	CuentaCorriente actualizarSaldo(Movimiento m) throws BusinessException;

}
