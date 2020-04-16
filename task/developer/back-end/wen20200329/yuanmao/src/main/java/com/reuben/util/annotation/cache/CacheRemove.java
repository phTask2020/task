package com.reuben.util.annotation.cache;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;


/**
* @author reuben
 * @Description: 用于模糊清除redis缓存
* @Param:
* @return:
*/
@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheRemove {

    String[] value() default {};
}
