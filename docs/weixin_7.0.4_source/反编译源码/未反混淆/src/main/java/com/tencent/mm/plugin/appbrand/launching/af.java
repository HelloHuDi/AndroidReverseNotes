package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

abstract class af<T> implements Callable<T> {
    protected volatile long iil = 0;
    protected volatile long iim = 0;
    protected volatile long iin = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.af$1 */
    class AnonymousClass1 implements d {
        final /* synthetic */ FutureTask iio;

        AnonymousClass1(FutureTask futureTask) {
            this.iio = futureTask;
        }

        public final void a(Runnable runnable, int i) {
            AppMethodBeat.i(131949);
            if (this.iio == runnable) {
                af.this.iil = bo.anU();
            }
            AppMethodBeat.o(131949);
        }

        public final void b(Runnable runnable, int i) {
            AppMethodBeat.i(131950);
            if (this.iio == runnable) {
                af.this.iim = bo.anU();
                af.this.iin = af.this.iim - af.this.iil;
            }
            AppMethodBeat.o(131950);
        }
    }

    public abstract String getTag();

    af() {
    }

    /* Access modifiers changed, original: final */
    public final T aHy() {
        this.iil = bo.anU();
        Object call = call();
        this.iim = bo.anU();
        this.iin = this.iim - this.iil;
        return call;
    }
}
