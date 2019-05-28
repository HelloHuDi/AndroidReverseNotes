package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

final class zzxi extends zzxe {
    zzxi() {
    }

    public final void zza(Throwable th, PrintStream printStream) {
        AppMethodBeat.i(3545);
        th.printStackTrace(printStream);
        AppMethodBeat.o(3545);
    }
}
