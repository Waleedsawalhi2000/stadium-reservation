package org.stadium.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ApiHandler {
    ResponseEntity<?> responseHandler(final Object obj, final HttpStatus httpStatus);

    default ResponseEntity.BodyBuilder initResponse(final HttpStatus httpStatus) {
        return ResponseEntity
                .status(httpStatus);
    }
}
