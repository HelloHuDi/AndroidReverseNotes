package com.tencent.p177mm.memory.p259a.p260a.p261a;

import android.app.ActivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.p260a.C6662a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.memory.a.a.a.a */
public final class C1792a {
    private static C1792a fep = new C1792a();
    public static boolean feq = false;
    public int fer = 10485760;
    public int fes = 3;
    public int fet = 2000;
    public double feu = 0.15d;
    public int fev = 3;
    public String few = "default";
    public Class<?> targetClass;

    static {
        AppMethodBeat.m2504i(115461);
        AppMethodBeat.m2505o(115461);
    }

    /* renamed from: Xw */
    public static C1792a m3685Xw() {
        return fep;
    }

    public C1792a() {
        AppMethodBeat.m2504i(115459);
        int largeMemoryClass = ((ActivityManager) C4996ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        C4990ab.m7417i("MicroMsg.CacheInvoke", "BitmapPool %dMB", Integer.valueOf(largeMemoryClass));
        if (largeMemoryClass >= 512) {
            this.fer = 62914560;
        } else if (largeMemoryClass >= 256) {
            this.fer = 31457280;
        } else {
            this.fer = 15728640;
        }
        this.targetClass = C6662a.class;
        this.fes = 3;
        this.fet = 2000;
        this.fev = 3;
        this.feu = 0.15d;
        AppMethodBeat.m2505o(115459);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(115460);
        boolean equals;
        if (obj instanceof C1792a) {
            equals = this.few.equals(((C1792a) obj).few);
            AppMethodBeat.m2505o(115460);
            return equals;
        }
        equals = super.equals(obj);
        AppMethodBeat.m2505o(115460);
        return equals;
    }
}
