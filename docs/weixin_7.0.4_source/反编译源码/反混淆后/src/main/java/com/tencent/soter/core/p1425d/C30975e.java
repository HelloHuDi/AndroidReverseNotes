package com.tencent.soter.core.p1425d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.tencent.soter.core.d.e */
public final class C30975e {
    private static Handler AvE = null;
    CountDownLatch vaN = null;

    public final void countDown() {
        AppMethodBeat.m2504i(73089);
        if (this.vaN != null) {
            this.vaN.countDown();
            this.vaN = null;
        }
        AppMethodBeat.m2505o(73089);
    }

    /* renamed from: d */
    static void m49598d(Runnable runnable) {
        AppMethodBeat.m2504i(73090);
        if (AvE == null) {
            AvE = new Handler(Looper.getMainLooper());
        }
        AvE.post(runnable);
        AppMethodBeat.m2505o(73090);
    }
}
