package org.stadium.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.stadium.entity.Scheduler;

import javax.transaction.Transactional;
import java.sql.Timestamp;

@Repository
public interface SchedulerRepository extends AbstractJpaRepository<Scheduler, Integer> {
    @Transactional
    @Modifying
    @Query("delete from Scheduler AS s where :timestamp > (s.timestamp)")
    void deleteAllTimestampWhenTheTicketIsExpire(@Param("timestamp") final Timestamp timestamp);

    @Transactional
    @Modifying
    @Query("delete from Scheduler as s where :code = s.value")
    void deleteTicketByCode(@Param("code") final Integer code);

    Scheduler findSchedulerByUserEmail(final String email);
}
