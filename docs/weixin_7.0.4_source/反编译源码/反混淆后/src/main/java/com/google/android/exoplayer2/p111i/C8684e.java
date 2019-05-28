package com.google.android.exoplayer2.p111i;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.i.e */
public final class C8684e {
    /* renamed from: RP */
    private boolean f2435RP;

    public final synchronized boolean open() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(95873);
            if (this.f2435RP) {
                z = false;
                AppMethodBeat.m2505o(95873);
            } else {
                this.f2435RP = true;
                notifyAll();
                AppMethodBeat.m2505o(95873);
            }
        }
        return z;
    }

    /* renamed from: tw */
    public final synchronized boolean mo19214tw() {
        boolean z;
        z = this.f2435RP;
        this.f2435RP = false;
        return z;
    }

    public final synchronized void block() {
        AppMethodBeat.m2504i(95874);
        while (!this.f2435RP) {
            wait();
        }
        AppMethodBeat.m2505o(95874);
    }
}
