package com.google.firebase.iid;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.iid.v */
final class C32103v implements Runnable {
    private final /* synthetic */ Intent bwo;
    private final /* synthetic */ C37308u bwt;

    C32103v(C37308u c37308u, Intent intent) {
        this.bwt = c37308u;
        this.bwo = intent;
    }

    public final void run() {
        AppMethodBeat.m2504i(108776);
        String action = this.bwo.getAction();
        new StringBuilder(String.valueOf(action).length() + 61).append("Service took too long to process intent: ").append(action).append(" App may get closed.");
        this.bwt.finish();
        AppMethodBeat.m2505o(108776);
    }
}
