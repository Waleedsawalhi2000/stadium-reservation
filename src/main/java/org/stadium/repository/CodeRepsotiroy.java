package org.stadium.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.stadium.entity.Code;

import javax.transaction.Transactional;
import java.sql.Timestamp;

@Repository
public interface CodeRepsotiroy extends AbstractJpaRepository<Code, Integer> {
    @Transactional
    @Modifying
    @Query("delete from Code AS s where :timestamp > (s.timestamp)")
    void deleteAllTimestampWhenTheTicketIsExpire(@Param("timestamp") final Timestamp timestamp);

    @Transactional
    @Modifying
    @Query("delete from Code as s where :code = s.value")
    void deleteTicketByCode(@Param("code") final Integer code);

    Code findSchedulerByUserEmail(final String email);

    Code findCodeByValue(final Integer value);
}
