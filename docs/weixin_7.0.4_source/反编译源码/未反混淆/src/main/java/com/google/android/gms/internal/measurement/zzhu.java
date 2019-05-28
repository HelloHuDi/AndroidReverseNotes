package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

final class zzhu implements Runnable {
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ AtomicReference zzanv;
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ boolean zzanz;

    zzhu(zzhk zzhk, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.zzanw = zzhk;
        this.zzanv = atomicReference;
        this.zzanj = str;
        this.zzanh = str2;
        this.zzani = str3;
        this.zzanz = z;
    }

    public final void run() {
        AppMethodBeat.i(69226);
        this.zzanw.zzacw.zzfx().zza(this.zzanv, this.zzanj, this.zzanh, this.zzani, this.zzanz);
        AppMethodBeat.o(69226);
    }
}
