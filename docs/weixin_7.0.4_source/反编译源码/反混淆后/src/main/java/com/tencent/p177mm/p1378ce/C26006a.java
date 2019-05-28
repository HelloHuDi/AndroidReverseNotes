package com.tencent.p177mm.p1378ce;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.ce.a */
public class C26006a {
    private static volatile C26006a ydx;
    private C7306ak mHandler;
    private HandlerThread mHandlerThread = C7305d.anM("WorkerThread#" + hashCode());
    private C7306ak ydy;

    private static C26006a dvP() {
        AppMethodBeat.m2504i(65378);
        if (ydx == null) {
            synchronized (C26006a.class) {
                try {
                    if (ydx == null) {
                        ydx = new C26006a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(65378);
                    }
                }
            }
        }
        C26006a c26006a = ydx;
        AppMethodBeat.m2505o(65378);
        return c26006a;
    }

    private C26006a() {
        AppMethodBeat.m2504i(65379);
        this.mHandlerThread.start();
        this.mHandler = new C7306ak(this.mHandlerThread.getLooper());
        this.ydy = new C7306ak(Looper.getMainLooper());
        AppMethodBeat.m2505o(65379);
    }

    public static HandlerThread dvQ() {
        AppMethodBeat.m2504i(65380);
        HandlerThread handlerThread = C26006a.dvP().mHandlerThread;
        AppMethodBeat.m2505o(65380);
        return handlerThread;
    }

    public static boolean post(Runnable runnable) {
        AppMethodBeat.m2504i(65381);
        boolean post = C26006a.dvP().mHandler.post(runnable);
        AppMethodBeat.m2505o(65381);
        return post;
    }

    public static boolean postDelayed(Runnable runnable, long j) {
        AppMethodBeat.m2504i(65382);
        boolean postDelayed = C26006a.dvP().mHandler.postDelayed(runnable, j);
        AppMethodBeat.m2505o(65382);
        return postDelayed;
    }

    /* renamed from: q */
    public static boolean m41506q(Runnable runnable) {
        AppMethodBeat.m2504i(65383);
        boolean post = C26006a.dvP().ydy.post(runnable);
        AppMethodBeat.m2505o(65383);
        return post;
    }

    /* renamed from: r */
    public static boolean m41507r(Runnable runnable, long j) {
        AppMethodBeat.m2504i(65384);
        boolean postDelayed = C26006a.dvP().ydy.postDelayed(runnable, j);
        AppMethodBeat.m2505o(65384);
        return postDelayed;
    }
}
