package com.google.firebase.iid;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.iid.x */
final class C17710x implements Runnable {
    private final /* synthetic */ C37308u bwv;
    private final /* synthetic */ C17709w bww;

    C17710x(C17709w c17709w, C37308u c37308u) {
        this.bww = c17709w;
        this.bwv = c37308u;
    }

    public final void run() {
        AppMethodBeat.m2504i(108777);
        Log.isLoggable("EnhancedIntentService", 3);
        this.bww.bwu.mo32804g(this.bwv.intent);
        this.bwv.finish();
        AppMethodBeat.m2505o(108777);
    }
}
