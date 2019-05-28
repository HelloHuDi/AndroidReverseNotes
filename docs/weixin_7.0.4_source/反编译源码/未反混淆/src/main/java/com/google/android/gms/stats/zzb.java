package com.google.android.gms.stats;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb implements Runnable {
    private final /* synthetic */ WakeLock zzaei;

    zzb(WakeLock wakeLock) {
        this.zzaei = wakeLock;
    }

    public final void run() {
        AppMethodBeat.i(113995);
        WakeLock.zza(this.zzaei, 0);
        AppMethodBeat.o(113995);
    }
}
