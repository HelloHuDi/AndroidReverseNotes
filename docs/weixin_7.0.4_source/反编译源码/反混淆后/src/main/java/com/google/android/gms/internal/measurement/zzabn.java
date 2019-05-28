package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class zzabn implements PrivilegedExceptionAction<Unsafe> {
    zzabn() {
    }

    public final /* synthetic */ Object run() {
        AppMethodBeat.m2504i(3425);
        Class cls = Unsafe.class;
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get(null);
            if (cls.isInstance(obj)) {
                Unsafe unsafe = (Unsafe) cls.cast(obj);
                AppMethodBeat.m2505o(3425);
                return unsafe;
            }
        }
        AppMethodBeat.m2505o(3425);
        return null;
    }
}
