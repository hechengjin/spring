package com.example.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * Created by hechengjin on 17-8-2.
 */
@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
    String value() default "";
}
