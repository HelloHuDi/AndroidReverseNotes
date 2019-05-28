package com.tencent.mm.plugin.appbrand.dynamic.k;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CountDownLatch;

public final class a {
    public static <T extends com.tencent.mm.kernel.c.a> T ag(Class<T> cls) {
        AppMethodBeat.i(11036);
        com.tencent.mm.kernel.c.a K = g.K(cls);
        if (K != null) {
            AppMethodBeat.o(11036);
            return K;
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.o(11036);
            return null;
        } else if (g.RQ().eKi.eKC) {
            AppMethodBeat.o(11036);
            return null;
        } else {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            com.tencent.mm.kernel.api.g anonymousClass1 = new com.tencent.mm.kernel.api.g() {
                public final void BR() {
                    AppMethodBeat.i(11034);
                    countDownLatch.countDown();
                    AppMethodBeat.o(11034);
                }

                public final void bi(boolean z) {
                    AppMethodBeat.i(11035);
                    countDownLatch.countDown();
                    AppMethodBeat.o(11035);
                }
            };
            g.RQ().a(anonymousClass1);
            try {
                countDownLatch.await();
                g.RQ().b(anonymousClass1);
            } catch (InterruptedException e) {
                ab.printErrStackTrace("MicroMsg.SyncGetter", e, "", new Object[0]);
                g.RQ().b(anonymousClass1);
            } catch (Throwable th) {
                g.RQ().b(anonymousClass1);
                AppMethodBeat.o(11036);
            }
            T K2 = g.K(cls);
            AppMethodBeat.o(11036);
            return K2;
        }
    }
}
