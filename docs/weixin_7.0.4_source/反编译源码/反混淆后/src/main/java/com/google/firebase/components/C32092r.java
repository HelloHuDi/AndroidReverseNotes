package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.components.r */
public final class C32092r {
    /* renamed from: c */
    public static void m52219c(boolean z, String str) {
        AppMethodBeat.m2504i(10631);
        if (z) {
            AppMethodBeat.m2505o(10631);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str);
        AppMethodBeat.m2505o(10631);
        throw illegalStateException;
    }

    public static <T> T zza(T t, String str) {
        AppMethodBeat.m2504i(10630);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException(str);
            AppMethodBeat.m2505o(10630);
            throw nullPointerException;
        }
        AppMethodBeat.m2505o(10630);
        return t;
    }
}
