package org.stadium.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponseDto {
    private String response;
}
