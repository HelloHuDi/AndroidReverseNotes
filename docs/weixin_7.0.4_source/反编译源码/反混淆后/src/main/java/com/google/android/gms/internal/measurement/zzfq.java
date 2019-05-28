package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzfq implements Runnable {
    private final /* synthetic */ boolean zzajq;
    private final /* synthetic */ zzfp zzajr;

    zzfq(zzfp zzfp, boolean z) {
        this.zzajr = zzfp;
        this.zzajq = z;
    }

    public final void run() {
        AppMethodBeat.m2504i(68939);
        this.zzajr.zzajp.zzm(this.zzajq);
        AppMethodBeat.m2505o(68939);
    }
}
