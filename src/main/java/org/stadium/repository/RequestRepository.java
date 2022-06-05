package org.stadium.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.stadium.entity.Request;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RequestRepository extends AbstractJpaRepository<Request, Integer> {
    @Query(value = "select request from Request AS request where request.user.username=:username")
    List<Request> findAll(@Param("username") final String username);

    @Query(value = "select request from Request as request where (request.stadium.admin.username=:username AND request.status=:status)")
    List<Request> findAll(@Param("username") final String username,
                          @Param("status") final String status);
}
