package com.tencent.p177mm.kiss.p243a;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.kiss.a.a */
public final class C32721a {
    private static C32721a eMK = new C32721a();
    public HandlerThread eMJ = new HandlerThread("InflateThread", 5);
    private Handler mHandler;

    private C32721a() {
        AppMethodBeat.m2504i(105674);
        this.eMJ.start();
        this.mHandler = new Handler(this.eMJ.getLooper());
        AppMethodBeat.m2505o(105674);
    }

    static {
        AppMethodBeat.m2504i(105675);
        AppMethodBeat.m2505o(105675);
    }

    /* renamed from: SL */
    public static C32721a m53394SL() {
        return eMK;
    }
}
