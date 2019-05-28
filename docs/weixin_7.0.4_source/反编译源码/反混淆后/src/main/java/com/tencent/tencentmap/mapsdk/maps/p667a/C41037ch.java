package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ch */
public final class C41037ch {
    /* renamed from: a */
    private ThreadPoolExecutor f16453a;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ch$a */
    static class C36490a {
        /* renamed from: a */
        private static final C41037ch f15279a = new C41037ch();

        static {
            AppMethodBeat.m2504i(98635);
            AppMethodBeat.m2505o(98635);
        }
    }

    /* synthetic */ C41037ch(byte b) {
        this();
    }

    /* renamed from: a */
    public static C41037ch m71366a() {
        AppMethodBeat.m2504i(98637);
        C41037ch a = C36490a.f15279a;
        AppMethodBeat.m2505o(98637);
        return a;
    }

    /* renamed from: b */
    public final ThreadPoolExecutor mo65126b() {
        return this.f16453a;
    }

    private C41037ch() {
        AppMethodBeat.m2504i(98636);
        this.f16453a = (ThreadPoolExecutor) Executors.newCachedThreadPool(new C46773bv("halley_" + C46772bt.m88739c() + "_" + "BusinessTaskPool"));
        AppMethodBeat.m2505o(98636);
    }
}
