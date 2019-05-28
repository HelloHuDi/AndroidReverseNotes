package com.tencent.mm.memory.a.a.a;

import android.app.ActivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a {
    private static a fep = new a();
    public static boolean feq = false;
    public int fer = 10485760;
    public int fes = 3;
    public int fet = 2000;
    public double feu = 0.15d;
    public int fev = 3;
    public String few = "default";
    public Class<?> targetClass;

    static {
        AppMethodBeat.i(115461);
        AppMethodBeat.o(115461);
    }

    public static a Xw() {
        return fep;
    }

    public a() {
        AppMethodBeat.i(115459);
        int largeMemoryClass = ((ActivityManager) ah.getContext().getSystemService("activity")).getLargeMemoryClass();
        ab.i("MicroMsg.CacheInvoke", "BitmapPool %dMB", Integer.valueOf(largeMemoryClass));
        if (largeMemoryClass >= 512) {
            this.fer = 62914560;
        } else if (largeMemoryClass >= 256) {
            this.fer = 31457280;
        } else {
            this.fer = 15728640;
        }
        this.targetClass = com.tencent.mm.memory.a.a.a.class;
        this.fes = 3;
        this.fet = 2000;
        this.fev = 3;
        this.feu = 0.15d;
        AppMethodBeat.o(115459);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(115460);
        boolean equals;
        if (obj instanceof a) {
            equals = this.few.equals(((a) obj).few);
            AppMethodBeat.o(115460);
            return equals;
        }
        equals = super.equals(obj);
        AppMethodBeat.o(115460);
        return equals;
    }
}
