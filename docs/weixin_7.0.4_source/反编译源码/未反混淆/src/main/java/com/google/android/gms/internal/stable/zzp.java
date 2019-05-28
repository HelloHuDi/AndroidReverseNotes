package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzp extends zzl {
    zzp() {
    }

    public final void zza(Throwable th, Throwable th2) {
        AppMethodBeat.i(90502);
        th.addSuppressed(th2);
        AppMethodBeat.o(90502);
    }
}
