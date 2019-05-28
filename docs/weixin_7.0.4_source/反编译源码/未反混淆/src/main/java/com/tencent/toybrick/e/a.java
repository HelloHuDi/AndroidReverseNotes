package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static a AGU = new a();
    private a AGV;
    private Handler AGW;
    private HandlerThread mThread;

    public interface a {
    }

    static {
        AppMethodBeat.i(113227);
        AppMethodBeat.o(113227);
    }

    public static a dSz() {
        return AGU;
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.i(113226);
        if (this.AGV == null) {
            if (this.mThread == null || !this.mThread.isAlive()) {
                this.mThread = new HandlerThread("WhenHandler");
                this.mThread.start();
                this.AGW = new Handler(this.mThread.getLooper());
            }
            this.AGW.post(runnable);
        }
        AppMethodBeat.o(113226);
    }
}
