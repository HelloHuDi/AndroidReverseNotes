package com.tencent.p177mm.plugin.appbrand.dynamic.p892k;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1675g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.k.a */
public final class C10218a {
    /* renamed from: ag */
    public static <T extends C1694a> T m17859ag(Class<T> cls) {
        AppMethodBeat.m2504i(11036);
        C1694a K = C1720g.m3528K(cls);
        if (K != null) {
            AppMethodBeat.m2505o(11036);
            return K;
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.m2505o(11036);
            return null;
        } else if (C1720g.m3537RQ().eKi.eKC) {
            AppMethodBeat.m2505o(11036);
            return null;
        } else {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            C1675g c102191 = new C1675g() {
                /* renamed from: BR */
                public final void mo5176BR() {
                    AppMethodBeat.m2504i(11034);
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(11034);
                }

                /* renamed from: bi */
                public final void mo5177bi(boolean z) {
                    AppMethodBeat.m2504i(11035);
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(11035);
                }
            };
            C1720g.m3537RQ().mo5252a(c102191);
            try {
                countDownLatch.await();
                C1720g.m3537RQ().mo5255b(c102191);
            } catch (InterruptedException e) {
                C4990ab.printErrStackTrace("MicroMsg.SyncGetter", e, "", new Object[0]);
                C1720g.m3537RQ().mo5255b(c102191);
            } catch (Throwable th) {
                C1720g.m3537RQ().mo5255b(c102191);
                AppMethodBeat.m2505o(11036);
            }
            T K2 = C1720g.m3528K(cls);
            AppMethodBeat.m2505o(11036);
            return K2;
        }
    }
}
