package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class i implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ h b;

    i(h hVar, boolean z) {
        this.b = hVar;
        this.a = z;
    }

    public void run() {
        AppMethodBeat.i(63985);
        this.b.c.onReceiveValue(Boolean.valueOf(this.a));
        AppMethodBeat.o(63985);
    }
}
