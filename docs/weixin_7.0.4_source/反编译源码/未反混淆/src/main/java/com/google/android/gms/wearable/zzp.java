package com.google.android.gms.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class zzp implements Runnable {
    private final /* synthetic */ zzd zzao;
    private final /* synthetic */ List zzar;

    zzp(zzd zzd, List list) {
        this.zzao = zzd;
        this.zzar = list;
    }

    public final void run() {
        AppMethodBeat.i(71486);
        WearableListenerService.this.onConnectedNodes(this.zzar);
        AppMethodBeat.o(71486);
    }
}
