package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzo implements Runnable {
    private final /* synthetic */ zzd zzao;
    private final /* synthetic */ zzfo zzaq;

    zzo(zzd zzd, zzfo zzfo) {
        this.zzao = zzd;
        this.zzaq = zzfo;
    }

    public final void run() {
        AppMethodBeat.m2504i(71485);
        WearableListenerService.this.onPeerDisconnected(this.zzaq);
        AppMethodBeat.m2505o(71485);
    }
}
