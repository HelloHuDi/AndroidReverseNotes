package com.tencent.mm.sdk.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b.d.a;
import com.tencent.mm.sdk.g.c.e;
import java.util.concurrent.BlockingQueue;

final class b {

    /* renamed from: com.tencent.mm.sdk.g.b.b$1 */
    static class AnonymousClass1 extends d {
        final /* synthetic */ com.tencent.mm.sdk.g.a.b xEd;

        AnonymousClass1(int i, int i2, BlockingQueue blockingQueue, e eVar, com.tencent.mm.sdk.g.b.d.b bVar, a aVar, com.tencent.mm.sdk.g.a.b bVar2) {
            this.xEd = bVar2;
            super(i, i2, blockingQueue, eVar, bVar, aVar);
        }

        /* Access modifiers changed, original: protected|final */
        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.i(52591);
            super.beforeExecute(thread, runnable);
            this.xEd.ap(runnable);
            AppMethodBeat.o(52591);
        }

        /* Access modifiers changed, original: protected|final */
        public final void afterExecute(Runnable runnable, Throwable th) {
            AppMethodBeat.i(52592);
            super.afterExecute(runnable, th);
            this.xEd.afterExecute(runnable, th);
            AppMethodBeat.o(52592);
        }
    }
}
