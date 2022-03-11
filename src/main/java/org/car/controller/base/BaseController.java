package org.car.controller.base;

import org.car.handler.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    public ResponseEntity<?> doCall(final ApiCall api) {
        final Object obj = api.call();
        return ResponseHandler.getInstance(obj).responseHandler(obj, HttpStatus.OK);
    }
}
