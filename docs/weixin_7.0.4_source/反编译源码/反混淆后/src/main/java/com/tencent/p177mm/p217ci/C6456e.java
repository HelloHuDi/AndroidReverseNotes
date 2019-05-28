package com.tencent.p177mm.p217ci;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p642h.C5703d;

/* renamed from: com.tencent.mm.ci.e */
public final class C6456e extends C5703d {
    /* renamed from: o */
    public final void mo10061o(Runnable runnable) {
        AppMethodBeat.m2504i(123367);
        runnable.run();
        AppMethodBeat.m2505o(123367);
    }

    /* renamed from: l */
    public final void mo10060l(Runnable runnable, long j) {
        AppMethodBeat.m2504i(123368);
        runnable.run();
        AppMethodBeat.m2505o(123368);
    }

    public final String getType() {
        return "WxNoLooperScheduler";
    }

    public final void cancel() {
    }
}
