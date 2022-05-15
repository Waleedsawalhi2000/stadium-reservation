package org.stadium.handler;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionHandler implements ApiHandler {
    @Override
    public ResponseEntity<?> responseHandler(final Object obj,
                                             final HttpStatus httpStatus) {
        return initResponse(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(convertCollectionToList((Collection) obj));
    }

    private List convertCollectionToList(final Collection collection) {
        return Arrays.asList(collection.toArray());
    }
}
