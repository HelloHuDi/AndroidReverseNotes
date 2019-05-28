package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzyv {
    private static final Class<?> zzbqv = zzfh("libcore.io.Memory");
    private static final boolean zzbqw = (zzfh("org.robolectric.Robolectric") != null);

    static {
        AppMethodBeat.m2504i(3547);
        AppMethodBeat.m2505o(3547);
    }

    private static <T> Class<T> zzfh(String str) {
        AppMethodBeat.m2504i(3546);
        try {
            Class cls = Class.forName(str);
            AppMethodBeat.m2505o(3546);
            return cls;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(3546);
            return null;
        }
    }

    static boolean zzsv() {
        return (zzbqv == null || zzbqw) ? false : true;
    }

    static Class<?> zzsw() {
        return zzbqv;
    }
}
