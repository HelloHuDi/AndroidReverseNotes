package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzjl implements Runnable {
    private final /* synthetic */ long zzadj;
    private final /* synthetic */ zzjh zzapx;

    zzjl(zzjh zzjh, long j) {
        this.zzapx = zzjh;
        this.zzadj = j;
    }

    public final void run() {
        AppMethodBeat.i(69395);
        zzjh.zzb(this.zzapx, this.zzadj);
        AppMethodBeat.o(69395);
    }
}
