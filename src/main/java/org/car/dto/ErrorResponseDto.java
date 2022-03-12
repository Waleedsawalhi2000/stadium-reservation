package org.car.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponseDto {
    private String response;
    private String error;
    private String uri;
}
