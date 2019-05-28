package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Thread.UncaughtExceptionHandler;

final class zzgi implements UncaughtExceptionHandler {
    private final String zzaly;
    private final /* synthetic */ zzgg zzalz;

    public zzgi(zzgg zzgg, String str) {
        this.zzalz = zzgg;
        AppMethodBeat.i(69053);
        Preconditions.checkNotNull(str);
        this.zzaly = str;
        AppMethodBeat.o(69053);
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        AppMethodBeat.i(69054);
        this.zzalz.zzge().zzim().zzg(this.zzaly, th);
        AppMethodBeat.o(69054);
    }
}
