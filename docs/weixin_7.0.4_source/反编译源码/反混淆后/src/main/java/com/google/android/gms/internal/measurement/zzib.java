package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzib implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ long zzaod;

    zzib(zzhk zzhk, long j) {
        this.zzanw = zzhk;
        this.zzaod = j;
    }

    public final void run() {
        AppMethodBeat.m2504i(69233);
        this.zzanw.zzgf().zzakj.set(this.zzaod);
        this.zzanw.zzge().zzis().zzg("Session timeout duration set", Long.valueOf(this.zzaod));
        AppMethodBeat.m2505o(69233);
    }
}
