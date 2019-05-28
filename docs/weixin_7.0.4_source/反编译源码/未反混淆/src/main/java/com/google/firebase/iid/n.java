package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n extends Handler {
    private final /* synthetic */ m bvU;

    n(m mVar, Looper looper) {
        this.bvU = mVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.i(108743);
        m.a(this.bvU, message);
        AppMethodBeat.o(108743);
    }
}
