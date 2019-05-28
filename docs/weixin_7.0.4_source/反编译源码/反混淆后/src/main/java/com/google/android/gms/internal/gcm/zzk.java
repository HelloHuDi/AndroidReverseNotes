package com.google.android.gms.internal.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk extends zzg {
    zzk() {
    }

    public final void zzd(Throwable th, Throwable th2) {
        AppMethodBeat.m2504i(57632);
        th.addSuppressed(th2);
        AppMethodBeat.m2505o(57632);
    }
}
