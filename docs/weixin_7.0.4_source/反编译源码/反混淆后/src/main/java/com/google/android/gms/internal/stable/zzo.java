package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzo extends zzl {
    private final zzm zzahm = new zzm();

    zzo() {
        AppMethodBeat.m2504i(90500);
        AppMethodBeat.m2505o(90500);
    }

    public final void zza(Throwable th, Throwable th2) {
        AppMethodBeat.m2504i(90501);
        if (th2 == th) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Self suppression is not allowed.", th2);
            AppMethodBeat.m2505o(90501);
            throw illegalArgumentException;
        } else if (th2 == null) {
            NullPointerException nullPointerException = new NullPointerException("The suppressed exception cannot be null.");
            AppMethodBeat.m2505o(90501);
            throw nullPointerException;
        } else {
            this.zzahm.zza(th, true).add(th2);
            AppMethodBeat.m2505o(90501);
        }
    }
}
