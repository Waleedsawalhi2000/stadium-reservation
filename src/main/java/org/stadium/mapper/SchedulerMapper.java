package org.stadium.mapper;

import org.stadium.dto.SchedulerDto;
import org.stadium.entity.Scheduler;

public class SchedulerMapper extends AbstractMapper<Scheduler, SchedulerDto> {
    @Override
    public Scheduler toEntity(final SchedulerDto schedulerDto) {
        return Scheduler
                .builder()
                .id(schedulerDto.getId())
                .user(new UserMapper().toEntity(schedulerDto.getUserDto()))
                .value(schedulerDto.getValue())
                .timestamp(schedulerDto.getTimestamp())
                .build();
    }

    @Override
    public SchedulerDto toDto(final Scheduler scheduler) {
        return SchedulerDto
                .builder()
                .id(scheduler.getId())
                .userDto(new UserMapper().toDto(scheduler.getUser()))
                .value(scheduler.getValue())
                .timestamp(scheduler.getTimestamp())
                .build();
    }
}
