package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r {
    public static void c(boolean z, String str) {
        AppMethodBeat.i(10631);
        if (z) {
            AppMethodBeat.o(10631);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str);
        AppMethodBeat.o(10631);
        throw illegalStateException;
    }

    public static <T> T zza(T t, String str) {
        AppMethodBeat.i(10630);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException(str);
            AppMethodBeat.o(10630);
            throw nullPointerException;
        }
        AppMethodBeat.o(10630);
        return t;
    }
}
