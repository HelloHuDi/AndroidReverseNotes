package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ah extends Handler {
    final /* synthetic */ ag a;

    ah(ag agVar, Looper looper) {
        this.a = agVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.i(64255);
        if (message.what == 150) {
            ag.a(this.a);
        }
        AppMethodBeat.o(64255);
    }
}
