package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.iid.n */
final class C17708n extends Handler {
    private final /* synthetic */ C25586m bvU;

    C17708n(C25586m c25586m, Looper looper) {
        this.bvU = c25586m;
        super(looper);
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.m2504i(108743);
        C25586m.m40581a(this.bvU, message);
        AppMethodBeat.m2505o(108743);
    }
}
