package com.tencent.p177mm.sdk.p603e;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.tencent.mm.sdk.e.i */
public @interface C4930i {
    String dpV();

    int dpW() default 0;
}
