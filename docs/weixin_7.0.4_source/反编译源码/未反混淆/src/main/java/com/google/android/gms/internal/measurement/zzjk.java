package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzjk implements Runnable {
    private final /* synthetic */ long zzadj;
    private final /* synthetic */ zzjh zzapx;

    zzjk(zzjh zzjh, long j) {
        this.zzapx = zzjh;
        this.zzadj = j;
    }

    public final void run() {
        AppMethodBeat.i(69394);
        zzjh.zza(this.zzapx, this.zzadj);
        AppMethodBeat.o(69394);
    }
}
