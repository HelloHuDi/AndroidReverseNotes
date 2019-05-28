package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbm implements Runnable {
    private final /* synthetic */ zzbl zzkm;

    zzbm(zzbl zzbl) {
        this.zzkm = zzbl;
    }

    public final void run() {
        AppMethodBeat.m2504i(60841);
        this.zzkm.zzkk.zzka.disconnect();
        AppMethodBeat.m2505o(60841);
    }
}
