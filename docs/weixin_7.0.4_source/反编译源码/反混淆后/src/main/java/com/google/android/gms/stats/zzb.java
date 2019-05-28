package com.google.android.gms.stats;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb implements Runnable {
    private final /* synthetic */ WakeLock zzaei;

    zzb(WakeLock wakeLock) {
        this.zzaei = wakeLock;
    }

    public final void run() {
        AppMethodBeat.m2504i(113995);
        WakeLock.zza(this.zzaei, 0);
        AppMethodBeat.m2505o(113995);
    }
}
