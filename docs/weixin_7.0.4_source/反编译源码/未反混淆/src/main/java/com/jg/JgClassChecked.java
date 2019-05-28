package com.jg;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface JgClassChecked {
    int author();

    String fComment();

    String lastDate();

    int level() default 1;

    int reviewer();

    EType[] vComment();
}
