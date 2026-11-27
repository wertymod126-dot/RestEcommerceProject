package com.advert.restecommerce.common.exception;


/**
 * Throw this when something the client asked for does not exist.
 * Spring turns it into a 404 Not Found response.
 * (Step 2 replaces this with a full GlobalExceptionHandler.)
 */

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
