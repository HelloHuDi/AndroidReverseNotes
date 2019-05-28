package com.google.android.gms.iid;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzh implements Runnable {
    private final /* synthetic */ Intent zzbb;
    private final /* synthetic */ zzg zzbh;

    zzh(zzg zzg, Intent intent) {
        this.zzbh = zzg;
        this.zzbb = intent;
    }

    public final void run() {
        AppMethodBeat.m2504i(57566);
        String action = this.zzbb.getAction();
        new StringBuilder(String.valueOf(action).length() + 61).append("Service took too long to process intent: ").append(action).append(" App may get closed.");
        this.zzbh.finish();
        AppMethodBeat.m2505o(57566);
    }
}
