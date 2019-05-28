package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.i */
class C44457i implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f17300a;
    /* renamed from: b */
    final /* synthetic */ C40979h f17301b;

    C44457i(C40979h c40979h, boolean z) {
        this.f17301b = c40979h;
        this.f17300a = z;
    }

    public void run() {
        AppMethodBeat.m2504i(63985);
        this.f17301b.f16304c.onReceiveValue(Boolean.valueOf(this.f17300a));
        AppMethodBeat.m2505o(63985);
    }
}
