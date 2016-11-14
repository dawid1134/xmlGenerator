package com.dwieczorek.studia.integracjasystemow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by dawid on 14.11.2016.
 */
@ResponseStatus(value = HttpStatus.TOO_MANY_REQUESTS)
public class RateLimitException extends RuntimeException {

    public RateLimitException() {
        super("Rate limit exceeded.");
    }

    public RateLimitException(String msg) {
        super(msg);
    }
}
