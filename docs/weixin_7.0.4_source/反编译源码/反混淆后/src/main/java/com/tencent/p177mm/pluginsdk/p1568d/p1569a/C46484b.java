package com.tencent.p177mm.pluginsdk.p1568d.p1569a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.pluginsdk.d.a.b */
public final class C46484b {
    private CountDownLatch vaN = null;

    public final void countDown() {
        AppMethodBeat.m2504i(27230);
        if (this.vaN != null) {
            this.vaN.countDown();
            this.vaN = null;
        }
        AppMethodBeat.m2505o(27230);
    }

    /* renamed from: b */
    public final void mo74707b(long j, Runnable runnable) {
        AppMethodBeat.m2504i(27231);
        C4990ab.m7416i("MicroMsg.SyncJob", "doAsSyncJob");
        if (this.vaN == null) {
            this.vaN = new CountDownLatch(1);
        }
        C5004al.m7441d(runnable);
        C4990ab.m7416i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
        if (this.vaN != null) {
            try {
                this.vaN.await(j, TimeUnit.MILLISECONDS);
                AppMethodBeat.m2505o(27231);
                return;
            } catch (InterruptedException e) {
                C4990ab.m7420w("MicroMsg.SyncJob", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.SyncJob", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(27231);
    }
}
