package com.tencent.p177mm.plugin.appbrand.p328r;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.vending.p642h.C5707g;
import com.tencent.p177mm.vending.p642h.C7369h;

/* renamed from: com.tencent.mm.plugin.appbrand.r.m */
public final class C45673m {
    private static volatile C5004al ftB;
    private static final Object iRa = new Object();
    private static Handler sMainHandler = null;

    static {
        AppMethodBeat.m2504i(91176);
        AppMethodBeat.m2505o(91176);
    }

    public static void aNR() {
        AppMethodBeat.m2504i(91173);
        if (ftB == null) {
            AppMethodBeat.m2505o(91173);
            return;
        }
        synchronized (iRa) {
            try {
                if (ftB != null) {
                    C5707g.asT("SubCoreAppBrand#WorkerThread");
                    ftB.oAl.quit();
                    ftB = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(91173);
            }
        }
    }

    public static C5004al aNS() {
        AppMethodBeat.m2504i(91174);
        if (ftB == null) {
            synchronized (iRa) {
                try {
                    if (ftB == null) {
                        ftB = new C5004al("SubCoreAppBrand#WorkerThread");
                        C5707g.m8573a("SubCoreAppBrand#WorkerThread", new C7369h(ftB.oAl.getLooper(), "SubCoreAppBrand#WorkerThread"));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(91174);
                    }
                }
            }
        }
        C5004al c5004al = ftB;
        AppMethodBeat.m2505o(91174);
        return c5004al;
    }

    public static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.m2504i(91175);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
            AppMethodBeat.m2505o(91175);
            return;
        }
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
        sMainHandler.post(runnable);
        AppMethodBeat.m2505o(91175);
    }
}
