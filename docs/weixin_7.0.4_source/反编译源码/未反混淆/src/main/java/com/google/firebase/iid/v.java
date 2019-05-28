package com.google.firebase.iid;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class v implements Runnable {
    private final /* synthetic */ Intent bwo;
    private final /* synthetic */ u bwt;

    v(u uVar, Intent intent) {
        this.bwt = uVar;
        this.bwo = intent;
    }

    public final void run() {
        AppMethodBeat.i(108776);
        String action = this.bwo.getAction();
        new StringBuilder(String.valueOf(action).length() + 61).append("Service took too long to process intent: ").append(action).append(" App may get closed.");
        this.bwt.finish();
        AppMethodBeat.o(108776);
    }
}
