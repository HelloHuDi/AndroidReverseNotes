package com.tencent.p177mm.plugin.soter.p528d;

import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p326n.C2402a;
import com.tencent.p177mm.plugin.appbrand.p326n.C33458b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.soter.d.i */
public final class C39855i {
    /* renamed from: ai */
    public static void m68267ai(String str, int i, int i2) {
        AppMethodBeat.m2504i(73891);
        ((C33458b) C37384e.m62986C(C33458b.class)).mo53944e(13711, Integer.valueOf(0), str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(73891);
    }

    /* renamed from: fI */
    public static void m68268fI(int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(73892);
        switch (i2) {
            case 4:
                i3 = 1;
                break;
            case 5:
                i3 = 3;
                break;
            case 9:
                i3 = 2;
                break;
            case 10:
                i3 = 4;
                break;
            case 26:
                if (i != 3) {
                    i3 = -1;
                    break;
                } else {
                    i3 = 0;
                    break;
                }
            case 1001:
                i3 = 5;
                break;
            default:
                i3 = -1;
                break;
        }
        if (i3 != -1) {
            C4990ab.m7417i("SoterLuggageReportManager", "luggage soter idkey report id: %d, key: %d, value: %d", Integer.valueOf(672), Integer.valueOf(i3), Long.valueOf(1));
            ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(672, (long) i3, 1);
        }
        AppMethodBeat.m2505o(73892);
    }
}
