package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;

public final class b {
    private static ak hlg;
    private static ak hlh;
    private static ak hli = new ak(Looper.getMainLooper());

    static {
        AppMethodBeat.i(10659);
        HandlerThread anM = d.anM("DynamicPage#WorkerThread");
        anM.start();
        hlg = new ak(anM.getLooper());
        anM = d.anM("DynamicPage#IPCThread");
        anM.start();
        hlh = new ak(anM.getLooper());
        AppMethodBeat.o(10659);
    }

    public static boolean D(Runnable runnable) {
        AppMethodBeat.i(10656);
        if (runnable == null) {
            AppMethodBeat.o(10656);
            return false;
        }
        boolean post = hlg.post(runnable);
        AppMethodBeat.o(10656);
        return post;
    }

    public static boolean j(Runnable runnable, long j) {
        AppMethodBeat.i(10657);
        if (runnable == null) {
            AppMethodBeat.o(10657);
            return false;
        }
        boolean postDelayed = hlg.postDelayed(runnable, j);
        AppMethodBeat.o(10657);
        return postDelayed;
    }

    public static boolean E(Runnable runnable) {
        AppMethodBeat.i(10658);
        boolean post = hli.post(runnable);
        AppMethodBeat.o(10658);
        return post;
    }
}
