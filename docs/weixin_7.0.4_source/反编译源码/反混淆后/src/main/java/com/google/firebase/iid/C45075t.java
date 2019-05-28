package com.google.firebase.iid;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.iid.t */
final class C45075t implements Runnable {
    private final /* synthetic */ Intent bwo;
    private final /* synthetic */ Intent bwp;
    private final /* synthetic */ zzb bwq;

    C45075t(zzb zzb, Intent intent, Intent intent2) {
        this.bwq = zzb;
        this.bwo = intent;
        this.bwp = intent2;
    }

    public final void run() {
        AppMethodBeat.m2504i(108773);
        this.bwq.mo32804g(this.bwo);
        this.bwq.m52237h(this.bwp);
        AppMethodBeat.m2505o(108773);
    }
}
