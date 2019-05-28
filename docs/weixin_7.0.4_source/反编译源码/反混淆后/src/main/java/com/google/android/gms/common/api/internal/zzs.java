package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzs implements Runnable {
    private final /* synthetic */ zzr zzgc;

    zzs(zzr zzr) {
        this.zzgc = zzr;
    }

    public final void run() {
        AppMethodBeat.m2504i(60973);
        this.zzgc.zzga.lock();
        try {
            zzr.zzb(this.zzgc);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.m2505o(60973);
        }
    }
}
