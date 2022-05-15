package org.stadium.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.stadium.dto.SchedulerDto;
import org.stadium.entity.Scheduler;
import org.stadium.entity.User;
import org.stadium.mapper.SchedulerMapper;
import org.stadium.mapper.UserMapper;
import org.stadium.repository.SchedulerRepository;
import org.stadium.repository.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@EnableScheduling
@Service
public class SchedulerService extends AbstractService<Scheduler, SchedulerDto, Integer> {
    @Autowired
    private UserRepository repository;
    @Autowired
    private SchedulerRepository scheduler;

    public SchedulerService(SchedulerRepository repository) {
        super(new SchedulerMapper(), repository);
    }

    public Scheduler create(final String email) {
        final User user = repository.findUserByEmail(email);
        if (user == null) {
            throw new IllegalStateException("This email doesn't found");
        }
        final Scheduler res = scheduler.findSchedulerByUserEmail(email);
        if (res != null) {
            return res;
        }
        final SchedulerDto dto = SchedulerDto
                .builder()
                .timestamp(Timestamp.valueOf(LocalDateTime.now()))
                .value(Integer.parseInt(getRandomNumberString()))
                .userDto(new UserMapper().toDto(user))
                .build();
        return super.create(dto);
    }

    @Scheduled(fixedDelay = 300000)
    public void deleteExpireTickets() {
        scheduler.deleteAllTimestampWhenTheTicketIsExpire(Timestamp.valueOf(LocalDateTime.now().minusMinutes(5)));
    }

    @Override
    public Scheduler update(final SchedulerDto dto,
                            final Integer integer) {
        throw new IllegalStateException("This method isn't supported for this feature");
    }

    @Override
    public List<SchedulerDto> findAll() {
        throw new IllegalStateException("This method isn't supported for this feature");
    }

    @Override
    public Page<SchedulerDto> findAll(final Pageable pageable) {
        throw new IllegalStateException("This method isn't supported for this feature");
    }

    @Override
    public SchedulerDto findById(final Integer integer) {
        throw new IllegalStateException("This method isn't supported for this feature");
    }

    public Boolean deleteByCode(final Integer code) {
        scheduler.deleteTicketByCode(code);
        return true;
    }

    public SchedulerDto findCodeBy(final String email) {
        final Scheduler ticket = scheduler.findSchedulerByUserEmail(email);
        return ticket != null ? mapper.toDto(ticket) : null;
    }

    public static String getRandomNumberString() {
        final Random rnd = new Random();
        final int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}
