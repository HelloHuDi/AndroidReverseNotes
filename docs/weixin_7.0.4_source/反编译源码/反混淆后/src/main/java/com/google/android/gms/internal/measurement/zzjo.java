package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzjo extends zzem {
    private final /* synthetic */ zzjr zzapt;
    private final /* synthetic */ zzjn zzapz;

    zzjo(zzjn zzjn, zzhi zzhi, zzjr zzjr) {
        this.zzapz = zzjn;
        this.zzapt = zzjr;
        super(zzhi);
    }

    public final void run() {
        AppMethodBeat.m2504i(69427);
        this.zzapz.cancel();
        this.zzapz.zzge().zzit().log("Starting upload from DelayedRunnable");
        this.zzapt.zzks();
        AppMethodBeat.m2505o(69427);
    }
}
