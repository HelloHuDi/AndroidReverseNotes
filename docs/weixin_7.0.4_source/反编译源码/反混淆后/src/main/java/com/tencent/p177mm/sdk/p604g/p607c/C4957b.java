package com.tencent.p177mm.sdk.p604g.p607c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.p608d.C7304a;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

@Deprecated
/* renamed from: com.tencent.mm.sdk.g.c.b */
public final class C4957b {
    private ThreadGroup cme = new ThreadGroup("MM_FREE_THREAD_GROUP");
    private final AtomicInteger xEF = new AtomicInteger(1);

    /* renamed from: com.tencent.mm.sdk.g.c.b$a */
    static class C4956a extends Thread {
        private C7304a xEG;

        C4956a(ThreadGroup threadGroup, C7304a c7304a, String str) {
            super(threadGroup, c7304a, str);
            this.xEG = c7304a;
        }

        public final void start() {
            AppMethodBeat.m2504i(52679);
            super.start();
            AppMethodBeat.m2505o(52679);
        }

        public final void run() {
            AppMethodBeat.m2504i(52680);
            super.run();
            AppMethodBeat.m2505o(52680);
        }
    }

    public C4957b() {
        AppMethodBeat.m2504i(52681);
        AppMethodBeat.m2505o(52681);
    }

    public final Thread newThread(Runnable runnable, String str, int i) {
        Thread thread;
        AppMethodBeat.m2504i(52682);
        Assert.assertNotNull("newThread arg name is null!", str);
        if (runnable != null) {
            Thread c4956a = new C4956a(this.cme, new C7304a(runnable, str, null, 0, null, null, null), "mmt_f".concat(String.valueOf(str)));
            c4956a.setPriority(i);
            thread = c4956a;
        } else {
            thread = new C4956a(this.cme, null, "mmt_f".concat(String.valueOf(str)));
            thread.setPriority(i);
        }
        AppMethodBeat.m2505o(52682);
        return thread;
    }
}
