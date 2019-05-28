package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzjf implements Runnable {
    private final /* synthetic */ Runnable zzabt;
    private final /* synthetic */ zzjr zzapt;

    zzjf(zzjc zzjc, zzjr zzjr, Runnable runnable) {
        this.zzapt = zzjr;
        this.zzabt = runnable;
    }

    public final void run() {
        AppMethodBeat.m2504i(69362);
        this.zzapt.zzkx();
        this.zzapt.zzg(this.zzabt);
        this.zzapt.zzks();
        AppMethodBeat.m2505o(69362);
    }
}
