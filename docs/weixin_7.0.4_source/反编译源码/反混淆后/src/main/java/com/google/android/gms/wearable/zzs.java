package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzs implements Runnable {
    private final /* synthetic */ zzd zzao;
    private final /* synthetic */ zzi zzau;

    zzs(zzd zzd, zzi zzi) {
        this.zzao = zzd;
        this.zzau = zzi;
    }

    public final void run() {
        AppMethodBeat.m2504i(71489);
        WearableListenerService.this.onEntityUpdate(this.zzau);
        AppMethodBeat.m2505o(71489);
    }
}
