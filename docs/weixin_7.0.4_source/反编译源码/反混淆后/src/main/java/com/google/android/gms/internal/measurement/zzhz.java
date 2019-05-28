package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhz implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ boolean zzaoc;

    zzhz(zzhk zzhk, boolean z) {
        this.zzanw = zzhk;
        this.zzaoc = z;
    }

    public final void run() {
        AppMethodBeat.m2504i(69231);
        zzhk.zza(this.zzanw, this.zzaoc);
        AppMethodBeat.m2505o(69231);
    }
}
