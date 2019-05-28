package com.tencent.p177mm.sdk.p604g.p606b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.p605a.C4939b;
import com.tencent.p177mm.sdk.p604g.p606b.C7299d.C4950a;
import com.tencent.p177mm.sdk.p604g.p606b.C7299d.C4951b;
import com.tencent.p177mm.sdk.p604g.p607c.C4962e;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.tencent.mm.sdk.g.b.b */
final class C4947b {

    /* renamed from: com.tencent.mm.sdk.g.b.b$1 */
    static class C49481 extends C7299d {
        final /* synthetic */ C4939b xEd;

        C49481(int i, int i2, BlockingQueue blockingQueue, C4962e c4962e, C4951b c4951b, C4950a c4950a, C4939b c4939b) {
            this.xEd = c4939b;
            super(i, i2, blockingQueue, c4962e, c4951b, c4950a);
        }

        /* Access modifiers changed, original: protected|final */
        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.m2504i(52591);
            super.beforeExecute(thread, runnable);
            this.xEd.mo10138ap(runnable);
            AppMethodBeat.m2505o(52591);
        }

        /* Access modifiers changed, original: protected|final */
        public final void afterExecute(Runnable runnable, Throwable th) {
            AppMethodBeat.m2504i(52592);
            super.afterExecute(runnable, th);
            this.xEd.afterExecute(runnable, th);
            AppMethodBeat.m2505o(52592);
        }
    }
}
