package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.List;

final class zzxh extends zzxe {
    private final zzxf zzbod = new zzxf();

    zzxh() {
        AppMethodBeat.i(3543);
        AppMethodBeat.o(3543);
    }

    public final void zza(Throwable th, PrintStream printStream) {
        AppMethodBeat.i(3544);
        th.printStackTrace(printStream);
        List<Throwable> zza = this.zzbod.zza(th, false);
        if (zza == null) {
            AppMethodBeat.o(3544);
            return;
        }
        synchronized (zza) {
            try {
                for (Throwable th2 : zza) {
                    printStream.print("Suppressed: ");
                    th2.printStackTrace(printStream);
                }
            } finally {
                AppMethodBeat.o(3544);
            }
        }
    }
}
