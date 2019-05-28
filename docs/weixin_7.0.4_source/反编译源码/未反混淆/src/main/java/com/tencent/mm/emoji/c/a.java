package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class a {
    private static a ezj;
    public int clickCount;
    public long ezk;
    public int ezl;
    public int ezm;
    public int ezn;
    public int scene;

    public static a OZ() {
        AppMethodBeat.i(62267);
        if (ezj == null) {
            ezj = new a();
        }
        a aVar = ezj;
        AppMethodBeat.o(62267);
        return aVar;
    }

    public final void a(boolean z, int i, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(62268);
        long currentTimeMillis = System.currentTimeMillis() - this.ezk;
        this.clickCount++;
        h.pYm.e(16029, str, str2, str3, str4, Integer.valueOf(this.scene), Long.valueOf(currentTimeMillis), Integer.valueOf(this.clickCount), Boolean.valueOf(z), Integer.valueOf(this.ezl), Integer.valueOf(this.ezm), Integer.valueOf(i), Integer.valueOf(this.ezn));
        AppMethodBeat.o(62268);
    }
}
