package org.stadium.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.stadium.entity.AvailableTime;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface AvailableTimeRepository extends AbstractJpaRepository<AvailableTime, Integer> {
    //substring(r.ended,11,3) ==> HOURS
//substring(r.ended,1,10) ==> date
//    @Query(nativeQuery = true, value = "SELECT t.id FROM available_time AS t " +
//            " WHERE t.id not in (SELECT case when t.id between hour(r1.started) and hour(r1.ended) then t.id end FROM request AS r1 WHERE  (r1.stadium.id = 1))")
//            "   ((substring(r1.started,1,10) = substring(:date,1))  AND  (substring(r1.ended,1,10) = substring(:date,1))))")
    @Query(nativeQuery = true,
            value = "select t.id from available_time as t where t.id not in " +
                    "(select case when r1.started IS NULL AND r1.ended IS NULL then t.id " +
                    " when t.id between hour(r1.started) and hour(r1.ended) then t.id end from request as r1 " +
                    "INNER JOIN stadium_request AS s ON s.id = r1.id " +
                    "where (s.stadium_id=:stadiumId) AND ((r1.ended is not null OR r1.started is not null) AND (date(r1.ended)=date(:date)) OR (date(r1.started)=date(:date))))")
    List<Integer> getAvailableTime(@Param("stadiumId") final Integer stadiumId,
                                   @Param("date") final LocalDate date);

    //SELECT t.id from available_time AS t where t.id not in (0,1,2,3)
}
