package com.tencent.soter.core.d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

public final class e {
    private static Handler AvE = null;
    CountDownLatch vaN = null;

    public final void countDown() {
        AppMethodBeat.i(73089);
        if (this.vaN != null) {
            this.vaN.countDown();
            this.vaN = null;
        }
        AppMethodBeat.o(73089);
    }

    static void d(Runnable runnable) {
        AppMethodBeat.i(73090);
        if (AvE == null) {
            AvE = new Handler(Looper.getMainLooper());
        }
        AvE.post(runnable);
        AppMethodBeat.o(73090);
    }
}
