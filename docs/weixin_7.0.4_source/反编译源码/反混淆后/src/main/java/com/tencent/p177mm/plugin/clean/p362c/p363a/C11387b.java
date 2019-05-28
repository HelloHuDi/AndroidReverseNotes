package com.tencent.p177mm.plugin.clean.p362c.p363a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.clean.c.a.b */
public final class C11387b implements C2805c {
    public HashMap<Long, C7306ak> kwM;
    private HashSet<Long> kwN;

    /* renamed from: com.tencent.mm.plugin.clean.c.a.b$1 */
    class C113881 implements Runnable {
        C113881() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18726);
            Looper.prepare();
            C11387b.this.kwM.put(Long.valueOf(Thread.currentThread().getId()), new C7306ak(Looper.myLooper()));
            Looper.loop();
            AppMethodBeat.m2505o(18726);
        }
    }

    public C11387b() {
        this((byte) 0);
    }

    private C11387b(byte b) {
        AppMethodBeat.m2504i(18727);
        this.kwN = new HashSet(5);
        this.kwM = new HashMap(5);
        for (int i = 0; i <= 5; i++) {
            C7305d.m12285a(new C113881(), "ThreadController_handler", 1).start();
        }
        AppMethodBeat.m2505o(18727);
    }

    /* renamed from: e */
    private synchronized void m19152e(Long l) {
        AppMethodBeat.m2504i(18729);
        if (this.kwN.remove(l)) {
            C4990ab.m7411d("MicroMsg.ThreadController", "thread is idle, id=%d", l);
        }
        AppMethodBeat.m2505o(18729);
    }

    /* renamed from: f */
    public final void mo6924f(Long l) {
        AppMethodBeat.m2504i(18730);
        m19152e(l);
        AppMethodBeat.m2505o(18730);
    }

    /* renamed from: b */
    public final synchronized boolean mo23131b(C33819a c33819a) {
        boolean z;
        AppMethodBeat.m2504i(18728);
        c33819a.kwL = this;
        C4990ab.m7411d("MicroMsg.ThreadController", "running threads %s", this.kwN.toString());
        for (Entry entry : this.kwM.entrySet()) {
            if (!this.kwN.contains(entry.getKey())) {
                ((C7306ak) entry.getValue()).post(c33819a);
                this.kwN.add(entry.getKey());
                AppMethodBeat.m2505o(18728);
                z = true;
                break;
            }
        }
        AppMethodBeat.m2505o(18728);
        z = false;
        return z;
    }
}
