package com.tencent.mm.plugin.soter.d;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.a;
import com.tencent.mm.plugin.appbrand.n.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class i {
    public static void ai(String str, int i, int i2) {
        AppMethodBeat.i(73891);
        ((b) e.C(b.class)).e(13711, Integer.valueOf(0), str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(73891);
    }

    public static void fI(int i, int i2) {
        int i3;
        AppMethodBeat.i(73892);
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
            ab.i("SoterLuggageReportManager", "luggage soter idkey report id: %d, key: %d, value: %d", Integer.valueOf(672), Integer.valueOf(i3), Long.valueOf(1));
            ((a) e.C(a.class)).f(672, (long) i3, 1);
        }
        AppMethodBeat.o(73892);
    }
}
