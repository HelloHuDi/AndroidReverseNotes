package com.tencent.p177mm.sdk.p604g.p607c;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

@Deprecated
/* renamed from: com.tencent.mm.sdk.g.c.a */
public final class C4955a {
    private ThreadGroup cme = new ThreadGroup("MM_FREE_THREAD_GROUP");
    private final AtomicInteger xEF = new AtomicInteger(1);

    /* renamed from: com.tencent.mm.sdk.g.c.a$a */
    static class C4954a extends HandlerThread {
        C4954a(String str, int i) {
            super(str, i);
        }

        public final void start() {
            AppMethodBeat.m2504i(52675);
            super.start();
            AppMethodBeat.m2505o(52675);
        }

        public final void run() {
            AppMethodBeat.m2504i(52676);
            super.run();
            AppMethodBeat.m2505o(52676);
        }
    }

    public C4955a() {
        AppMethodBeat.m2504i(52677);
        AppMethodBeat.m2505o(52677);
    }

    /* renamed from: em */
    public static HandlerThread m7359em(String str, int i) {
        AppMethodBeat.m2504i(52678);
        Assert.assertNotNull("newThread arg name is null!", str);
        C4954a c4954a = new C4954a("mmt_h".concat(String.valueOf(str)), i);
        AppMethodBeat.m2505o(52678);
        return c4954a;
    }
}
