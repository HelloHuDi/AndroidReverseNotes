package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class c {
    public static final int oIa = a.fromDPToPix(ah.getContext(), 3);
    public static final int oIb = a.fromDPToPix(ah.getContext(), 4);
    public static final int oIc = a.fromDPToPix(ah.getContext(), 8);
    public static final int oId = a.fromDPToPix(ah.getContext(), 10);
    public static final int oIe = a.fromDPToPix(ah.getContext(), 14);
    public static final int oIf = a.fromDPToPix(ah.getContext(), 30);
    public static final int oIh = a.fromDPToPix(ah.getContext(), 32);
    public static final int oIi = a.fromDPToPix(ah.getContext(), 96);
    public static final int oIj = a.fromDPToPix(ah.getContext(), 76);
    public static final int oIk = a.fromDPToPix(ah.getContext(), 230);
    private static int teQ = 0;

    static {
        AppMethodBeat.i(135441);
        AppMethodBeat.o(135441);
    }

    public static int fj(Context context) {
        AppMethodBeat.i(135440);
        if (teQ == 0) {
            teQ = a.ge(context);
        }
        int i = teQ;
        AppMethodBeat.o(135440);
        return i;
    }
}
