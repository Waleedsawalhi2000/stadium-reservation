package org.car.handler;

import org.springframework.data.domain.Page;

import java.util.Collection;

public class ResponseHandler {

    public static ApiHandler getInstance(final Object object) {
        if (object instanceof Page) {
            return new PageHandler();
        }
        if (object instanceof Collection) {
            return new CollectionHandler();
        }
        return new BaseHandler();
    }
}
