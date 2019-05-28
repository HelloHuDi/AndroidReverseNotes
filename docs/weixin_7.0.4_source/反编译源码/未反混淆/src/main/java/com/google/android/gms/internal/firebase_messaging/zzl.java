package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl extends zzi {
    private final zzj zzk = new zzj();

    zzl() {
        AppMethodBeat.i(108685);
        AppMethodBeat.o(108685);
    }

    public final void zza(Throwable th, Throwable th2) {
        AppMethodBeat.i(108686);
        if (th2 == th) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Self suppression is not allowed.", th2);
            AppMethodBeat.o(108686);
            throw illegalArgumentException;
        } else if (th2 == null) {
            NullPointerException nullPointerException = new NullPointerException("The suppressed exception cannot be null.");
            AppMethodBeat.o(108686);
            throw nullPointerException;
        } else {
            this.zzk.zza(th, true).add(th2);
            AppMethodBeat.o(108686);
        }
    }
}
