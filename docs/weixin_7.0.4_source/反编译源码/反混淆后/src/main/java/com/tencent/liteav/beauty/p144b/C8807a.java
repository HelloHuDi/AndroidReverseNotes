package com.tencent.liteav.beauty.p144b;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.a */
public class C8807a {
    /* renamed from: a */
    private boolean f2671a = false;

    /* renamed from: a */
    public synchronized void mo19904a() {
        AppMethodBeat.m2504i(66976);
        this.f2671a = true;
        notify();
        AppMethodBeat.m2505o(66976);
    }

    /* renamed from: b */
    public synchronized void mo19905b() {
        AppMethodBeat.m2504i(66977);
        while (!this.f2671a) {
            wait();
        }
        this.f2671a = false;
        AppMethodBeat.m2505o(66977);
    }
}
