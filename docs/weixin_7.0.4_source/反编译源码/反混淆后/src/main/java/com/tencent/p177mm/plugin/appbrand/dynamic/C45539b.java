package com.tencent.p177mm.plugin.appbrand.dynamic;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.b */
public final class C45539b {
    private static C7306ak hlg;
    private static C7306ak hlh;
    private static C7306ak hli = new C7306ak(Looper.getMainLooper());

    static {
        AppMethodBeat.m2504i(10659);
        HandlerThread anM = C7305d.anM("DynamicPage#WorkerThread");
        anM.start();
        hlg = new C7306ak(anM.getLooper());
        anM = C7305d.anM("DynamicPage#IPCThread");
        anM.start();
        hlh = new C7306ak(anM.getLooper());
        AppMethodBeat.m2505o(10659);
    }

    /* renamed from: D */
    public static boolean m83987D(Runnable runnable) {
        AppMethodBeat.m2504i(10656);
        if (runnable == null) {
            AppMethodBeat.m2505o(10656);
            return false;
        }
        boolean post = hlg.post(runnable);
        AppMethodBeat.m2505o(10656);
        return post;
    }

    /* renamed from: j */
    public static boolean m83989j(Runnable runnable, long j) {
        AppMethodBeat.m2504i(10657);
        if (runnable == null) {
            AppMethodBeat.m2505o(10657);
            return false;
        }
        boolean postDelayed = hlg.postDelayed(runnable, j);
        AppMethodBeat.m2505o(10657);
        return postDelayed;
    }

    /* renamed from: E */
    public static boolean m83988E(Runnable runnable) {
        AppMethodBeat.m2504i(10658);
        boolean post = hli.post(runnable);
        AppMethodBeat.m2505o(10658);
        return post;
    }
}
