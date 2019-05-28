package com.google.firebase.iid;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t implements Runnable {
    private final /* synthetic */ Intent bwo;
    private final /* synthetic */ Intent bwp;
    private final /* synthetic */ zzb bwq;

    t(zzb zzb, Intent intent, Intent intent2) {
        this.bwq = zzb;
        this.bwo = intent;
        this.bwp = intent2;
    }

    public final void run() {
        AppMethodBeat.i(108773);
        this.bwq.g(this.bwo);
        this.bwq.h(this.bwp);
        AppMethodBeat.o(108773);
    }
}
