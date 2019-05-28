package com.tencent.soter.a.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

public class g {
    private static volatile g Awz = null;
    private Handler AvE = null;
    private Handler AwA = null;

    private g() {
        AppMethodBeat.i(10489);
        HandlerThread handlerThread = new HandlerThread("SoterGenKeyHandlerThreadName");
        handlerThread.start();
        if (handlerThread.getLooper() != null) {
            this.AwA = new Handler(handlerThread.getLooper());
        } else {
            d.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
            this.AwA = new Handler(Looper.getMainLooper());
        }
        this.AvE = new Handler(Looper.getMainLooper());
        AppMethodBeat.o(10489);
    }

    public static g dRq() {
        AppMethodBeat.i(10490);
        g gVar;
        if (Awz == null) {
            synchronized (g.class) {
                try {
                    if (Awz == null) {
                        Awz = new g();
                    }
                    gVar = Awz;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(10490);
                }
            }
            return gVar;
        }
        gVar = Awz;
        AppMethodBeat.o(10490);
        return gVar;
    }

    public final void R(Runnable runnable) {
        AppMethodBeat.i(10491);
        this.AwA.post(runnable);
        AppMethodBeat.o(10491);
    }

    public final void s(Runnable runnable, long j) {
        AppMethodBeat.i(10492);
        this.AwA.postDelayed(runnable, j);
        AppMethodBeat.o(10492);
    }

    public final void d(Runnable runnable) {
        AppMethodBeat.i(10493);
        this.AvE.post(runnable);
        AppMethodBeat.o(10493);
    }
}
