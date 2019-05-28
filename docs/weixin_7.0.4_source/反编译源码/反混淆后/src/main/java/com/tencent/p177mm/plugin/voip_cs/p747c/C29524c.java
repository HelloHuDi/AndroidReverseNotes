package com.tencent.p177mm.plugin.voip_cs.p747c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.voip_cs.c.c */
public final class C29524c {
    public static final int oIa = C1338a.fromDPToPix(C4996ah.getContext(), 3);
    public static final int oIb = C1338a.fromDPToPix(C4996ah.getContext(), 4);
    public static final int oIc = C1338a.fromDPToPix(C4996ah.getContext(), 8);
    public static final int oId = C1338a.fromDPToPix(C4996ah.getContext(), 10);
    public static final int oIe = C1338a.fromDPToPix(C4996ah.getContext(), 14);
    public static final int oIf = C1338a.fromDPToPix(C4996ah.getContext(), 30);
    public static final int oIh = C1338a.fromDPToPix(C4996ah.getContext(), 32);
    public static final int oIi = C1338a.fromDPToPix(C4996ah.getContext(), 96);
    public static final int oIj = C1338a.fromDPToPix(C4996ah.getContext(), 76);
    public static final int oIk = C1338a.fromDPToPix(C4996ah.getContext(), 230);
    private static int teQ = 0;

    static {
        AppMethodBeat.m2504i(135441);
        AppMethodBeat.m2505o(135441);
    }

    /* renamed from: fj */
    public static int m46872fj(Context context) {
        AppMethodBeat.m2504i(135440);
        if (teQ == 0) {
            teQ = C1338a.m2869ge(context);
        }
        int i = teQ;
        AppMethodBeat.m2505o(135440);
        return i;
    }
}
