package com.tencent.p177mm.plugin.webview.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.preload.a */
public final class C43924a {
    /* renamed from: kT */
    public static void m78793kT(int i) {
        AppMethodBeat.m2504i(80437);
        C43924a.m78790e(908, i, 1, true);
        AppMethodBeat.m2505o(80437);
    }

    /* renamed from: IT */
    public static void m78787IT(int i) {
        AppMethodBeat.m2504i(80438);
        C43924a.m78790e(974, i, 1, false);
        AppMethodBeat.m2505o(80438);
    }

    /* renamed from: gv */
    public static void m78792gv(int i, int i2) {
        AppMethodBeat.m2504i(80440);
        C43924a.m78790e(908, i, i2, true);
        AppMethodBeat.m2505o(80440);
    }

    /* renamed from: e */
    public static void m78790e(int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(80441);
        C4990ab.m7417i("ConstantsPreload", "id:%d, key:%d, valye:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        C7060h.pYm.mo8378a((long) i, (long) i2, (long) i3, false);
        if (!(!z || i == 908 || i == 0)) {
            C7060h.pYm.mo8378a(908, (long) i2, (long) i3, false);
        }
        C7060h.pYm.mo8381e(15792, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(80441);
    }

    /* renamed from: IU */
    public static void m78788IU(int i) {
        AppMethodBeat.m2504i(80442);
        C43924a.m78789ae(i, 1);
        AppMethodBeat.m2505o(80442);
    }

    /* renamed from: ae */
    public static void m78789ae(int i, long j) {
        AppMethodBeat.m2504i(80443);
        C7060h.pYm.mo15419k(1009, (long) i, j);
        AppMethodBeat.m2505o(80443);
    }

    /* renamed from: gu */
    public static void m78791gu(int i, int i2) {
        AppMethodBeat.m2504i(139080);
        C43924a.m78790e(i, i2, 1, true);
        AppMethodBeat.m2505o(139080);
    }
}
