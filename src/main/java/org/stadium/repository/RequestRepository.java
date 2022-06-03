package org.stadium.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.stadium.entity.Request;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RequestRepository extends AbstractJpaRepository<Request, Integer> {
}
