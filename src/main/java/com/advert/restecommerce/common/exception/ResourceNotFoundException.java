package com.advert.restecommerce.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Throw this when something the client asked for does not exist.
 * Spring turns it into a 404 Not Found response.
 * (Step 2 replaces this with a full GlobalExceptionHandler.)
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
