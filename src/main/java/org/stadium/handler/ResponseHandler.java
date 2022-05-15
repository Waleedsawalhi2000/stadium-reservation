package org.stadium.handler;

import org.springframework.core.io.ByteArrayResource;
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
        if (object instanceof ByteArrayResource) {
            return new ImageHandler();
        }
        return new BaseHandler();
    }
}
