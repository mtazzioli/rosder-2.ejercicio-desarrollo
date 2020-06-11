package coop.tecso.examen.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.CuentaCorrienteDto;
import coop.tecso.examen.exception.BusinessException;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.CuentaCorrienteRepository;
import coop.tecso.examen.repository.base.BaseCrudRepository;
import coop.tecso.examen.service.CuentaCorrienteService;
import coop.tecso.examen.service.base.AbstractService;

@Service
public class CuentaCorrienteServiceImpl extends AbstractService<CuentaCorriente, CuentaCorrienteDto>
		implements CuentaCorrienteService {

	@Autowired
	private CuentaCorrienteRepository repository;

	@Override
	public CuentaCorrienteDto toDto(CuentaCorriente entity) {
		return this.getModelMapper().map(entity, CuentaCorrienteDto.class);
	}

	@Override
	public CuentaCorriente fromDto(CuentaCorrienteDto dto) {
		return this.getModelMapper().map(dto, CuentaCorriente.class);
	}

	@Override
	public BaseCrudRepository<CuentaCorriente> getRepository() {
		return repository;
	}

	@Override
	public void delete(Long id) throws Exception {
		CuentaCorriente cc = repository.getOne(id);
		if (cc.getMovimientos() == null || cc.getMovimientos().isEmpty())
			super.delete(id);
		else
			throw new Exception("No pueden eliminarse cuentas con movimientos asociados");
	}

	@Override
	public CuentaCorriente save(CuentaCorrienteDto dto) {
		if (dto.getId() == null) {
			dto.setSaldo(BigDecimal.ZERO);
		}
		return super.save(dto);
	}

	@Override
	public CuentaCorriente actualizarSaldo(Movimiento m) throws BusinessException {
		CuentaCorriente cc = repository.getOne(m.getCuentaCorriente().getId());

		BigDecimal nuevoSaldo;
		if (m.getTipoMovimiento().getAumentaSaldo()) {
			nuevoSaldo = cc.getSaldo().add(m.getImporte());
		} else {
			nuevoSaldo = cc.getSaldo().subtract(m.getImporte());
		}

		if (new BigDecimal(cc.getTipoMoneda().getDescubiertoPermitido()).compareTo(nuevoSaldo) < -1) {
			throw new BusinessException("Movimiento rechazado, el descubierto para un cuenta en :" + cc.getTipoMoneda()
					+ " no puede ser mayor a " + cc.getTipoMoneda().getDescubiertoPermitido());
		}

		cc.setSaldo(nuevoSaldo);
		repository.save(cc);
		return null;
	}

}
