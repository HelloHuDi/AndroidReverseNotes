package com.google.firebase.iid;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class x implements Runnable {
    private final /* synthetic */ u bwv;
    private final /* synthetic */ w bww;

    x(w wVar, u uVar) {
        this.bww = wVar;
        this.bwv = uVar;
    }

    public final void run() {
        AppMethodBeat.i(108777);
        Log.isLoggable("EnhancedIntentService", 3);
        this.bww.bwu.g(this.bwv.intent);
        this.bwv.finish();
        AppMethodBeat.o(108777);
    }
}
