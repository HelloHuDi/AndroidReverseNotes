package com.tencent.p177mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.n */
public final class C46428n {
    /* renamed from: IO */
    public static void m87447IO(int i) {
        int i2;
        AppMethodBeat.m2504i(6856);
        if (2 == i) {
            i2 = 11;
        } else if (1 == i) {
            i2 = 10;
        } else {
            i2 = -1;
        }
        if (-1 == i2) {
            AppMethodBeat.m2505o(6856);
            return;
        }
        C7060h.pYm.mo8378a(238, (long) i2, 1, false);
        AppMethodBeat.m2505o(6856);
    }

    /* renamed from: lQ */
    public static void m87448lQ(long j) {
        AppMethodBeat.m2504i(6857);
        C7060h.pYm.mo8378a(238, j, 1, false);
        AppMethodBeat.m2505o(6857);
    }
}
