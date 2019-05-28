package com.tencent.p177mm.vending.p643i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.vending.i.a */
public final class C5708a {
    private static C5708a zYw = new C5708a();
    /* renamed from: a */
    public HandlerThread f1353a = new HandlerThread("Vending-HeavyWorkThread", 10);
    /* renamed from: b */
    private Handler f1354b;

    private C5708a() {
        AppMethodBeat.m2504i(126143);
        this.f1353a.start();
        this.f1354b = new Handler(this.f1353a.getLooper());
        AppMethodBeat.m2505o(126143);
    }

    static {
        AppMethodBeat.m2504i(126144);
        AppMethodBeat.m2505o(126144);
    }

    public static C5708a dMr() {
        return zYw;
    }
}
