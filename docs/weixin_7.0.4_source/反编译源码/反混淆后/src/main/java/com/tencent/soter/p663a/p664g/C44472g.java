package com.tencent.soter.p663a.p664g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.p1351c.C44476d;

/* renamed from: com.tencent.soter.a.g.g */
public class C44472g {
    private static volatile C44472g Awz = null;
    private Handler AvE = null;
    private Handler AwA = null;

    private C44472g() {
        AppMethodBeat.m2504i(10489);
        HandlerThread handlerThread = new HandlerThread("SoterGenKeyHandlerThreadName");
        handlerThread.start();
        if (handlerThread.getLooper() != null) {
            this.AwA = new Handler(handlerThread.getLooper());
        } else {
            C44476d.m80483e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
            this.AwA = new Handler(Looper.getMainLooper());
        }
        this.AvE = new Handler(Looper.getMainLooper());
        AppMethodBeat.m2505o(10489);
    }

    public static C44472g dRq() {
        AppMethodBeat.m2504i(10490);
        C44472g c44472g;
        if (Awz == null) {
            synchronized (C44472g.class) {
                try {
                    if (Awz == null) {
                        Awz = new C44472g();
                    }
                    c44472g = Awz;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(10490);
                }
            }
            return c44472g;
        }
        c44472g = Awz;
        AppMethodBeat.m2505o(10490);
        return c44472g;
    }

    /* renamed from: R */
    public final void mo70644R(Runnable runnable) {
        AppMethodBeat.m2504i(10491);
        this.AwA.post(runnable);
        AppMethodBeat.m2505o(10491);
    }

    /* renamed from: s */
    public final void mo70646s(Runnable runnable, long j) {
        AppMethodBeat.m2504i(10492);
        this.AwA.postDelayed(runnable, j);
        AppMethodBeat.m2505o(10492);
    }

    /* renamed from: d */
    public final void mo70645d(Runnable runnable) {
        AppMethodBeat.m2504i(10493);
        this.AvE.post(runnable);
        AppMethodBeat.m2505o(10493);
    }
}
