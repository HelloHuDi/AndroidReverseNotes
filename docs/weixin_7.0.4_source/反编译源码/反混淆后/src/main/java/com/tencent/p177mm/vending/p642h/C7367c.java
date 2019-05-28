package com.tencent.p177mm.vending.p642h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p640f.C5687a;

/* renamed from: com.tencent.mm.vending.h.c */
public final class C7367c extends C5703d {
    public C7367c() {
        AppMethodBeat.m2504i(126127);
        C5687a.printErrStackTrace("Vending.NoLooperScheduler", new Exception("This is not a handler thread!"), "This is not a handler thread!", new Object[0]);
        AppMethodBeat.m2505o(126127);
    }

    /* renamed from: o */
    public final void mo10061o(Runnable runnable) {
        AppMethodBeat.m2504i(126128);
        C5687a.m8543w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
        runnable.run();
        AppMethodBeat.m2505o(126128);
    }

    /* renamed from: l */
    public final void mo10060l(Runnable runnable, long j) {
        AppMethodBeat.m2504i(126129);
        C5687a.m8543w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
        runnable.run();
        AppMethodBeat.m2505o(126129);
    }

    public final String getType() {
        AppMethodBeat.m2504i(126130);
        String thread = Thread.currentThread().toString();
        AppMethodBeat.m2505o(126130);
        return thread;
    }

    public final void cancel() {
    }
}
