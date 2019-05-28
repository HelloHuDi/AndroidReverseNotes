package com.tencent.liteav.network.p812a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.network.a.d */
public final class C41694d {
    /* renamed from: a */
    public static final C41694d f17059a = new C41694d(C25664a.NO_NETWORK, 0);
    /* renamed from: b */
    public static final C41694d f17060b = new C41694d(C25664a.WIFI, 0);
    /* renamed from: c */
    public final int f17061c;
    /* renamed from: d */
    public final C25664a f17062d;

    /* renamed from: com.tencent.liteav.network.a.d$a */
    public enum C25664a {
        NO_NETWORK,
        WIFI,
        MOBILE;

        static {
            AppMethodBeat.m2505o(67634);
        }
    }

    static {
        AppMethodBeat.m2504i(67631);
        AppMethodBeat.m2505o(67631);
    }

    public C41694d(C25664a c25664a, int i) {
        this.f17062d = c25664a;
        this.f17061c = i;
    }
}
