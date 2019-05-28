package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzji extends zzem {
    private final /* synthetic */ zzjh zzapx;

    zzji(zzjh zzjh, zzhi zzhi) {
        this.zzapx = zzjh;
        super(zzhi);
    }

    public final void run() {
        AppMethodBeat.i(69392);
        zzjh zzjh = this.zzapx;
        zzjh.zzab();
        zzjh.zzge().zzit().zzg("Session started, time", Long.valueOf(zzjh.zzbt().elapsedRealtime()));
        zzjh.zzgf().zzakk.set(false);
        zzjh.zzfu().zza("auto", "_s", new Bundle());
        zzjh.zzgf().zzakl.set(zzjh.zzbt().currentTimeMillis());
        AppMethodBeat.o(69392);
    }
}
