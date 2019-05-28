package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

final class zzht implements Runnable {
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ AtomicReference zzanv;
    private final /* synthetic */ zzhk zzanw;

    zzht(zzhk zzhk, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zzanw = zzhk;
        this.zzanv = atomicReference;
        this.zzanj = str;
        this.zzanh = str2;
        this.zzani = str3;
    }

    public final void run() {
        AppMethodBeat.i(69225);
        this.zzanw.zzacw.zzfx().zza(this.zzanv, this.zzanj, this.zzanh, this.zzani);
        AppMethodBeat.o(69225);
    }
}
