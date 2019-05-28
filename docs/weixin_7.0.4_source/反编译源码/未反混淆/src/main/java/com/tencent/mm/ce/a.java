package com.tencent.mm.ce;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;

public class a {
    private static volatile a ydx;
    private ak mHandler;
    private HandlerThread mHandlerThread = d.anM("WorkerThread#" + hashCode());
    private ak ydy;

    private static a dvP() {
        AppMethodBeat.i(65378);
        if (ydx == null) {
            synchronized (a.class) {
                try {
                    if (ydx == null) {
                        ydx = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(65378);
                    }
                }
            }
        }
        a aVar = ydx;
        AppMethodBeat.o(65378);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(65379);
        this.mHandlerThread.start();
        this.mHandler = new ak(this.mHandlerThread.getLooper());
        this.ydy = new ak(Looper.getMainLooper());
        AppMethodBeat.o(65379);
    }

    public static HandlerThread dvQ() {
        AppMethodBeat.i(65380);
        HandlerThread handlerThread = dvP().mHandlerThread;
        AppMethodBeat.o(65380);
        return handlerThread;
    }

    public static boolean post(Runnable runnable) {
        AppMethodBeat.i(65381);
        boolean post = dvP().mHandler.post(runnable);
        AppMethodBeat.o(65381);
        return post;
    }

    public static boolean postDelayed(Runnable runnable, long j) {
        AppMethodBeat.i(65382);
        boolean postDelayed = dvP().mHandler.postDelayed(runnable, j);
        AppMethodBeat.o(65382);
        return postDelayed;
    }

    public static boolean q(Runnable runnable) {
        AppMethodBeat.i(65383);
        boolean post = dvP().ydy.post(runnable);
        AppMethodBeat.o(65383);
        return post;
    }

    public static boolean r(Runnable runnable, long j) {
        AppMethodBeat.i(65384);
        boolean postDelayed = dvP().ydy.postDelayed(runnable, j);
        AppMethodBeat.o(65384);
        return postDelayed;
    }
}
