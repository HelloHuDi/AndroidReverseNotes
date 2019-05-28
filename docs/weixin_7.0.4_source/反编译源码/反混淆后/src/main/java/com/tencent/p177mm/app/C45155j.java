package com.tencent.p177mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p217ci.C6455d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vending.p642h.C5703d;
import com.tencent.p177mm.vending.p642h.C7369h;

/* renamed from: com.tencent.mm.app.j */
public final class C45155j {
    private static C45155j ces;
    HandlerThread cet;
    C5703d ceu;
    C7306ak handler = new C7306ak(this.cet.getLooper());

    /* renamed from: Bm */
    public static C45155j m83048Bm() {
        AppMethodBeat.m2504i(15380);
        if (ces == null) {
            ces = new C45155j("initThread");
        }
        C45155j c45155j = ces;
        AppMethodBeat.m2505o(15380);
        return c45155j;
    }

    private C45155j(String str) {
        AppMethodBeat.m2504i(15381);
        this.cet = C7305d.m12297ek(str, 10);
        this.cet.start();
        this.ceu = new C7369h(C6455d.m10673c(this.handler), str);
        AppMethodBeat.m2505o(15381);
    }

    /* renamed from: Bn */
    public final void mo73066Bn() {
        AppMethodBeat.m2504i(15382);
        if (this.cet == null || !this.cet.isAlive()) {
            C4990ab.m7412e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
            AppMethodBeat.m2505o(15382);
            return;
        }
        int threadId = this.cet.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                C4990ab.m7420w("MicroMsg.InitThreadController", "setHighPriority No Need.");
                AppMethodBeat.m2505o(15382);
                return;
            }
            Process.setThreadPriority(threadId, -8);
            C4990ab.m7417i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
            AppMethodBeat.m2505o(15382);
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
            C4990ab.printErrStackTrace("MicroMsg.InitThreadController", e, "", new Object[0]);
            AppMethodBeat.m2505o(15382);
        }
    }
}
