package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzen implements Runnable {
    private final /* synthetic */ zzhi zzafk;
    private final /* synthetic */ zzem zzafl;

    zzen(zzem zzem, zzhi zzhi) {
        this.zzafl = zzem;
        this.zzafk = zzhi;
    }

    public final void run() {
        AppMethodBeat.m2504i(68697);
        this.zzafk.zzgd();
        if (zzgg.isMainThread()) {
            this.zzafk.zzgd().zzc((Runnable) this);
            AppMethodBeat.m2505o(68697);
            return;
        }
        boolean zzef = this.zzafl.zzef();
        this.zzafl.zzye = 0;
        if (zzef) {
            this.zzafl.run();
        }
        AppMethodBeat.m2505o(68697);
    }
}
