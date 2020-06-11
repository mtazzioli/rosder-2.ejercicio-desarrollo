package coop.tecso.examen.service.impl;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;

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
		Optional<CuentaCorriente> ccO = repository.findById(id);

		if (!ccO.isPresent())
			throw new BusinessException("Error, No se encuentra la cuenta corriente a eliminar");

		if (ccO.get().getMovimientos() == null || ccO.get().getMovimientos().isEmpty())
			super.delete(id);
		else
			throw new BusinessException("No pueden eliminarse cuentas con movimientos asociados");
	}

	@Override
	public CuentaCorriente save(CuentaCorrienteDto dto) throws Exception {
		// Alta
		if (dto.getId() == null) {
			dto.setSaldo(BigDecimal.ZERO);
			try {
				return repository.save(fromDto(dto));
			} catch (Exception e) {
				throw new BusinessException(
						"Error, ya existe una cuenta con el numero de cuenta " + dto.getNumeroCuenta());
			}

		}

		throw new BusinessException("Error, No se admite la modificación de cuentas");
	}

	@Override
	public CuentaCorriente actualizarSaldo(Movimiento m) throws BusinessException {
		Optional<CuentaCorriente> ccO = repository.findById(m.getCuentaCorriente().getId());

		if (!ccO.isPresent())
			throw new BusinessException("Error, No se encuentra la cuenta corriente para imputar el movimiento");

		CuentaCorriente cc = ccO.get();

		BigDecimal nuevoSaldo;
		if (m.getTipoMovimiento().getAumentaSaldo()) {
			nuevoSaldo = cc.getSaldo().add(m.getImporte());
		} else {
			nuevoSaldo = cc.getSaldo().subtract(m.getImporte());
		}

		if (cc.getTipoMoneda().getDescubiertoPermitido().compareTo(nuevoSaldo) > 0) {
			throw new BusinessException("Movimiento rechazado, el descubierto para un cuenta en " + cc.getTipoMoneda()
					+ " no puede ser mayor a " + cc.getTipoMoneda().getDescubiertoPermitido());
		}

		cc.setSaldo(nuevoSaldo);
		return repository.save(cc);
	}

	@Override
	public CuentaCorrienteDto getOne(Long id) throws BusinessException {
		CuentaCorrienteDto ccDto = super.getOne(id);

		// Ordenamiento de movimientos por fecha decreciente
		ccDto.setMovimientos(ccDto.getMovimientos().stream().sorted((o1, o2) -> o2.getFecha().compareTo(o1.getFecha()))
				.collect(Collectors.toList()));

		return ccDto;
	}

}
