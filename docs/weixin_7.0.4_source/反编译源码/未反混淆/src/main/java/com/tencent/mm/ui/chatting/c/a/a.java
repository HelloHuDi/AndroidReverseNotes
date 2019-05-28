package com.tencent.mm.ui.chatting.c.a;

import com.tencent.mm.ui.chatting.c.v;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface a {

    public static class a implements v {
    }

    Class<? extends v> dFp() default a.class;
}
