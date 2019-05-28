package com.tencent.toybrick.p682e;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.toybrick.e.a */
public final class C5972a {
    private static C5972a AGU = new C5972a();
    private C5971a AGV;
    private Handler AGW;
    private HandlerThread mThread;

    /* renamed from: com.tencent.toybrick.e.a$a */
    public interface C5971a {
    }

    static {
        AppMethodBeat.m2504i(113227);
        AppMethodBeat.m2505o(113227);
    }

    public static C5972a dSz() {
        return AGU;
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.m2504i(113226);
        if (this.AGV == null) {
            if (this.mThread == null || !this.mThread.isAlive()) {
                this.mThread = new HandlerThread("WhenHandler");
                this.mThread.start();
                this.AGW = new Handler(this.mThread.getLooper());
            }
            this.AGW.post(runnable);
        }
        AppMethodBeat.m2505o(113226);
    }
}
