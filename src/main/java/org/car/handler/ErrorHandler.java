package org.car.handler;

import org.car.dto.ErrorResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ErrorResponseDto globalExceptionHandler(final Exception exception,
                                                   final WebRequest request) {
        return ErrorResponseDto
                .builder()
                .response(exception.getMessage())
                .uri(request.getDescription(false))
                .error(exception.toString())
                .build();
    }
}
