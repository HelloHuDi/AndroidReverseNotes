package com.tencent.p177mm.sdk.platformtools;

import android.app.Activity;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.tencent.mm.sdk.platformtools.h */
public @interface C5060h {
    Class<? extends Activity>[] doa() default {};
}
