package com.tencent.liteav.beauty.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    private boolean a = false;

    public synchronized void a() {
        AppMethodBeat.i(66976);
        this.a = true;
        notify();
        AppMethodBeat.o(66976);
    }

    public synchronized void b() {
        AppMethodBeat.i(66977);
        while (!this.a) {
            wait();
        }
        this.a = false;
        AppMethodBeat.o(66977);
    }
}
