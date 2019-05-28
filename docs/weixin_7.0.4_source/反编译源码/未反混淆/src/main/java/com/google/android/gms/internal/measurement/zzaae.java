package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaae implements zzaak {
    zzaae() {
    }

    public final boolean zzd(Class<?> cls) {
        return false;
    }

    public final zzaaj zze(Class<?> cls) {
        AppMethodBeat.i(3335);
        IllegalStateException illegalStateException = new IllegalStateException("This should never be called.");
        AppMethodBeat.o(3335);
        throw illegalStateException;
    }
}
