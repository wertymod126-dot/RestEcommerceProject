package com.advert.restecommerce.common.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

public record ErrorResponse(
        int status,
        String message,
        Instant timestamp,
        String path,
        Map<String,String> errors
){}
