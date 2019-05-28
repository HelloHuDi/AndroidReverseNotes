package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.ae;

public final class b {
    public static final int oIa = a.fromDPToPix(ah.getContext(), 3);
    public static final int oIb = a.fromDPToPix(ah.getContext(), 4);
    public static final int oIc = a.fromDPToPix(ah.getContext(), 8);
    public static final int oId = a.fromDPToPix(ah.getContext(), 10);
    public static final int oIe = a.fromDPToPix(ah.getContext(), 14);
    public static final int oIf = a.fromDPToPix(ah.getContext(), 30);
    public static final int oIg = a.fromDPToPix(ah.getContext(), 26);
    public static final int oIh = a.fromDPToPix(ah.getContext(), 32);
    public static final int oIi = a.fromDPToPix(ah.getContext(), 96);
    public static final int oIj = a.fromDPToPix(ah.getContext(), 76);
    public static final int oIk = a.fromDPToPix(ah.getContext(), 230);
    private static int oIl = 0;

    static {
        AppMethodBeat.i(54187);
        AppMethodBeat.o(54187);
    }

    public static int eC(Context context) {
        AppMethodBeat.i(54186);
        if (oIl <= 0) {
            oIl = ae.hy(context).y - oIk;
            ab.i("MicroMsg.MultiTalkDimensUtil", "getMultiTalkAvatarBoardHeight, displaySize: %s, MultiTalkAvatarBoardHeight: %s", r0, Integer.valueOf(oIl));
        }
        int i = oIl;
        AppMethodBeat.o(54186);
        return i;
    }
}
