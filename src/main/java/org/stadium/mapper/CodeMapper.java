package org.stadium.mapper;

import org.stadium.dto.CodeDto;
import org.stadium.entity.Code;

public class CodeMapper extends AbstractMapper<Code, CodeDto> {
    @Override
    public Code toEntity(final CodeDto codeDto) {
        return Code
                .builder()
                .id(codeDto.getId())
                .user(new UserMapper().toEntity(codeDto.getUserDto()))
                .value(codeDto.getValue())
                .timestamp(codeDto.getTimestamp())
                .build();
    }

    @Override
    public CodeDto toDto(final Code code) {
        return CodeDto
                .builder()
                .id(code.getId())
                .userDto(new UserMapper().toDto(code.getUser()))
                .value(code.getValue())
                .timestamp(code.getTimestamp())
                .build();
    }
}
