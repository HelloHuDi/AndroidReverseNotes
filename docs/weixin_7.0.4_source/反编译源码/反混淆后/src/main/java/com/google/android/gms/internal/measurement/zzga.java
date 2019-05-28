package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzga implements Runnable {
    private final /* synthetic */ zzfz zzakz;

    zzga(zzfz zzfz) {
        this.zzakz = zzfz;
    }

    public final void run() {
        AppMethodBeat.m2504i(68980);
        this.zzakz.zzaky.zzc(this.zzakz.zzaky.zzjj());
        AppMethodBeat.m2505o(68980);
    }
}
