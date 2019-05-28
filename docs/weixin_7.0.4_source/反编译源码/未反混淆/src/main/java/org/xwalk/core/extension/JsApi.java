package org.xwalk.core.extension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsApi {
    boolean isEntryPoint() default false;

    boolean isEventList() default false;

    boolean isWritable() default false;

    boolean withPromise() default false;

    String wrapArgs() default "";

    String wrapReturns() default "";
}
