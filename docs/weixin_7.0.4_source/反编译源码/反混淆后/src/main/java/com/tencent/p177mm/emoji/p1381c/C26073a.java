package com.tencent.p177mm.emoji.p1381c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;

/* renamed from: com.tencent.mm.emoji.c.a */
public final class C26073a {
    private static C26073a ezj;
    public int clickCount;
    public long ezk;
    public int ezl;
    public int ezm;
    public int ezn;
    public int scene;

    /* renamed from: OZ */
    public static C26073a m41631OZ() {
        AppMethodBeat.m2504i(62267);
        if (ezj == null) {
            ezj = new C26073a();
        }
        C26073a c26073a = ezj;
        AppMethodBeat.m2505o(62267);
        return c26073a;
    }

    /* renamed from: a */
    public final void mo43942a(boolean z, int i, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(62268);
        long currentTimeMillis = System.currentTimeMillis() - this.ezk;
        this.clickCount++;
        C7060h.pYm.mo8381e(16029, str, str2, str3, str4, Integer.valueOf(this.scene), Long.valueOf(currentTimeMillis), Integer.valueOf(this.clickCount), Boolean.valueOf(z), Integer.valueOf(this.ezl), Integer.valueOf(this.ezm), Integer.valueOf(i), Integer.valueOf(this.ezn));
        AppMethodBeat.m2505o(62268);
    }
}
