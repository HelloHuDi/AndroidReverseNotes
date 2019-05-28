package com.tencent.mm.plugin.appbrand.r;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;

public final class m {
    private static volatile al ftB;
    private static final Object iRa = new Object();
    private static Handler sMainHandler = null;

    static {
        AppMethodBeat.i(91176);
        AppMethodBeat.o(91176);
    }

    public static void aNR() {
        AppMethodBeat.i(91173);
        if (ftB == null) {
            AppMethodBeat.o(91173);
            return;
        }
        synchronized (iRa) {
            try {
                if (ftB != null) {
                    g.asT("SubCoreAppBrand#WorkerThread");
                    ftB.oAl.quit();
                    ftB = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(91173);
            }
        }
    }

    public static al aNS() {
        AppMethodBeat.i(91174);
        if (ftB == null) {
            synchronized (iRa) {
                try {
                    if (ftB == null) {
                        ftB = new al("SubCoreAppBrand#WorkerThread");
                        g.a("SubCoreAppBrand#WorkerThread", new h(ftB.oAl.getLooper(), "SubCoreAppBrand#WorkerThread"));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(91174);
                    }
                }
            }
        }
        al alVar = ftB;
        AppMethodBeat.o(91174);
        return alVar;
    }

    public static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(91175);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
            AppMethodBeat.o(91175);
            return;
        }
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
        sMainHandler.post(runnable);
        AppMethodBeat.o(91175);
    }
}
