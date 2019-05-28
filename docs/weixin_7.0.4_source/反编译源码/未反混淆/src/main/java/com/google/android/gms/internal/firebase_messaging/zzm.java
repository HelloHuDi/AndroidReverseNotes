package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm extends zzi {
    zzm() {
    }

    public final void zza(Throwable th, Throwable th2) {
        AppMethodBeat.i(108687);
        th.addSuppressed(th2);
        AppMethodBeat.o(108687);
    }
}
