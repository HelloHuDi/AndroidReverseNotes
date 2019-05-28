package com.tencent.p177mm.vending.p643i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.vending.i.b */
public final class C5709b {
    private static C5709b zYx = new C5709b();
    /* renamed from: a */
    public HandlerThread f1355a = new HandlerThread("Vending-LogicThread");
    /* renamed from: b */
    private Handler f1356b;

    private C5709b() {
        AppMethodBeat.m2504i(126145);
        this.f1355a.start();
        this.f1356b = new Handler(this.f1355a.getLooper());
        AppMethodBeat.m2505o(126145);
    }

    static {
        AppMethodBeat.m2504i(126146);
        AppMethodBeat.m2505o(126146);
    }

    public static C5709b dMs() {
        return zYx;
    }
}
