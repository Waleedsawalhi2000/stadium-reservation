package org.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractJpaRepository<ENTITY, ID> extends JpaRepository<ENTITY, ID> {
}
