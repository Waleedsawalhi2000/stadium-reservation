package org.stadium.handler;

import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.URLConnection;

public class ImageHandler implements ApiHandler {
    @Override
    public ResponseEntity<?> responseHandler(final Object obj, final HttpStatus httpStatus) {
        final InputStreamSource image = (InputStreamSource) obj;
        MediaType mediaType;
        try {
            final String mimeType = URLConnection.guessContentTypeFromStream(image.getInputStream());
            mediaType = mimeType != null ? MediaType.parseMediaType(mimeType) : MediaType.APPLICATION_OCTET_STREAM;
        } catch(Exception io) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }
        return initResponse(httpStatus)
                .contentType(mediaType)
                .body(obj);
    }
}
