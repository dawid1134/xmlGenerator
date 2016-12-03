package com.dwieczorek.studia.integracjasystemow.aspect;

/**
 * Created by dawid on 14.11.2016.
 */

import com.dwieczorek.studia.integracjasystemow.annotation.RateLimit;
import com.dwieczorek.studia.integracjasystemow.exception.RateLimitException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class RateLimitAspect {
    private static final Logger logger =
            LoggerFactory.getLogger(RateLimitAspect.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("@annotation(rateLimit)")
    private void annotatedWithRateLimit(RateLimit rateLimit) {
    }

    @Pointcut("@within(org.springframework.stereotype.Controller)"
            + " || @within(org.springframework.web.bind.annotation.RestController)")
    private void controllerMethods() {
    }

    @Before("controllerMethods() && annotatedWithRateLimit(rateLimit)")
    public void rateLimitProcess(final JoinPoint joinPoint,
                                 RateLimit rateLimit) throws RateLimitException {
        logger.debug("rateLimitProcess()");
        HttpServletRequest request = getRequest(joinPoint.getArgs());
        if (request == null) {
            logger.error(String.format("HttpServletRequest error",
                    joinPoint.getSignature().toShortString()));
            return;
        }
        String ip = request.getRemoteHost();
        String url = request.getRequestURI();
        String key = String.format("req:lim:%s:%s", url, ip);
        long count = redisTemplate.opsForValue().increment(key, 1);
        logger.debug(String.format("[Redis] %s = %s", key, count));
        if (count == 1) {
            redisTemplate.expire(key, rateLimit.duration(), rateLimit.unit());
        }
        if (count > rateLimit.limit()) {
            logger.warn(String.format("Block user data: ",
                    ip, count, url, rateLimit.limit()));
            throw new RateLimitException();
        }
    }

    private HttpServletRequest getRequest(Object[] args) {
        for (Object arg : args) {
            if (arg instanceof HttpServletRequest) {
                return (HttpServletRequest) arg;
            }
        }
        return null;
    }
}