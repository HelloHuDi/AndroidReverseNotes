package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzia implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ long zzaod;

    zzia(zzhk zzhk, long j) {
        this.zzanw = zzhk;
        this.zzaod = j;
    }

    public final void run() {
        AppMethodBeat.m2504i(69232);
        this.zzanw.zzgf().zzaki.set(this.zzaod);
        this.zzanw.zzge().zzis().zzg("Minimum session duration set", Long.valueOf(this.zzaod));
        AppMethodBeat.m2505o(69232);
    }
}
