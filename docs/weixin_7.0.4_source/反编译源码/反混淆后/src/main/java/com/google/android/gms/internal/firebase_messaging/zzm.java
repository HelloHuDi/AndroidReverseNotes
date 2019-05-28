package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm extends zzi {
    zzm() {
    }

    public final void zza(Throwable th, Throwable th2) {
        AppMethodBeat.m2504i(108687);
        th.addSuppressed(th2);
        AppMethodBeat.m2505o(108687);
    }
}
