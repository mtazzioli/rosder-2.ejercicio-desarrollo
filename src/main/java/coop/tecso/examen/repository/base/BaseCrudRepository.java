package coop.tecso.examen.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import coop.tecso.examen.model.AbstractPersistentObject;

@NoRepositoryBean
public interface BaseCrudRepository<E extends AbstractPersistentObject>
		extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {

}
