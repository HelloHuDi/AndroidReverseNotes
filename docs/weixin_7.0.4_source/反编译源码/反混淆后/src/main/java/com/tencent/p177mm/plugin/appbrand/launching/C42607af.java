package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.p605a.C4942d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.af */
abstract class C42607af<T> implements Callable<T> {
    protected volatile long iil = 0;
    protected volatile long iim = 0;
    protected volatile long iin = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.af$1 */
    class C271591 implements C4942d {
        final /* synthetic */ FutureTask iio;

        C271591(FutureTask futureTask) {
            this.iio = futureTask;
        }

        /* renamed from: a */
        public final void mo10145a(Runnable runnable, int i) {
            AppMethodBeat.m2504i(131949);
            if (this.iio == runnable) {
                C42607af.this.iil = C5046bo.anU();
            }
            AppMethodBeat.m2505o(131949);
        }

        /* renamed from: b */
        public final void mo10146b(Runnable runnable, int i) {
            AppMethodBeat.m2504i(131950);
            if (this.iio == runnable) {
                C42607af.this.iim = C5046bo.anU();
                C42607af.this.iin = C42607af.this.iim - C42607af.this.iil;
            }
            AppMethodBeat.m2505o(131950);
        }
    }

    public abstract String getTag();

    C42607af() {
    }

    /* Access modifiers changed, original: final */
    public final T aHy() {
        this.iil = C5046bo.anU();
        Object call = call();
        this.iim = C5046bo.anU();
        this.iin = this.iim - this.iil;
        return call;
    }
}
