package com.reuben.util.annotation.cache.aspect;


import com.reuben.util.annotation.cache.CacheRemove;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @program: springboot_demo
 * @description:
 * @author: reuben
 * @create: 2020-03-31 19:02
 **/
@Aspect
@Component
public class CacheRemoveAspect {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning("@annotation(com.reuben.util.annotation.cache.CacheRemove)")
    public void remove(JoinPoint point) {
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        CacheRemove cacheRemove = method.getAnnotation(CacheRemove.class);
        String[] keys = cacheRemove.value();
        for (String key : keys) {
            if (key.contains("#")) {
                key = parseKey(key, method, point.getArgs());
            }

            Set<String> deleteKeys = stringRedisTemplate.keys(key);
            stringRedisTemplate.delete(deleteKeys);
            logger.info("cache key: " + key + " deleted");
        }
    }

    /**
     * parseKey from SPEL
     */
    private String parseKey(String key, Method method, Object[] args) {
        LocalVariableTableParameterNameDiscoverer u =
                new LocalVariableTableParameterNameDiscoverer();
        String[] paraNameArr = u.getParameterNames(method);

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        for (int i = 0; i < paraNameArr.length; i++) {
            context.setVariable(paraNameArr[i], args[i]);
        }
        return parser.parseExpression(key).getValue(context, String.class);
    }
}
