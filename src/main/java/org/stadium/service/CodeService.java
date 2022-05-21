package org.stadium.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.stadium.dto.CodeDto;
import org.stadium.entity.Code;
import org.stadium.entity.User;
import org.stadium.mapper.CodeMapper;
import org.stadium.mapper.UserMapper;
import org.stadium.repository.CodeRepsotiroy;
import org.stadium.repository.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;


@EnableScheduling
@Service
public class CodeService extends AbstractService<Code, CodeDto, Integer> {
    @Autowired
    private UserRepository repository;
    @Autowired
    private CodeRepsotiroy scheduler;

    public CodeService(CodeRepsotiroy repository) {
        super(new CodeMapper(), repository);
    }

    public Code create(final String email) {
        final User user = repository.findUserByEmail(email);
        if (user == null) {
            throw new IllegalStateException("This email doesn't found");
        }
        final Code res = scheduler.findSchedulerByUserEmail(email);
        if (res != null) {
            return res;
        }
        final CodeDto dto = CodeDto
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
    public Code update(final CodeDto dto,
                       final Integer integer) {
        throw new IllegalStateException("This method isn't supported for this feature");
    }

    @Override
    public List<CodeDto> findAll() {
        throw new IllegalStateException("This method isn't supported for this feature");
    }

    @Override
    public Page<CodeDto> findAll(final Pageable pageable) {
        throw new IllegalStateException("This method isn't supported for this feature");
    }

    @Override
    public CodeDto findById(final Integer integer) {
        throw new IllegalStateException("This method isn't supported for this feature");
    }

    public Boolean deleteByCode(final Integer code) {
        scheduler.deleteTicketByCode(code);
        return true;
    }

    public CodeDto findCodeBy(final String email) {
        final Code ticket = scheduler.findSchedulerByUserEmail(email);
        return ticket != null ? mapper.toDto(ticket) : null;
    }

    public static String getRandomNumberString() {
        final Random rnd = new Random();
        final int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}
