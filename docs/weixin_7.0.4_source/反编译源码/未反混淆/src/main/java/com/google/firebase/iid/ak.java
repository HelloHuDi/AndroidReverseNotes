package com.google.firebase.iid;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class ak implements Callback {
    private final aj bwX;

    ak(aj ajVar) {
        this.bwX = ajVar;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(108830);
        boolean f = this.bwX.f(message);
        AppMethodBeat.o(108830);
        return f;
    }
}
