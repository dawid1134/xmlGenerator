package com.dwieczorek.studia.integracjasystemow.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * Created by dawid on 14.11.2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RateLimit {

    int limit() default Integer.MAX_VALUE;

    long duration() default 1;

    TimeUnit unit() default TimeUnit.MINUTES;
}
