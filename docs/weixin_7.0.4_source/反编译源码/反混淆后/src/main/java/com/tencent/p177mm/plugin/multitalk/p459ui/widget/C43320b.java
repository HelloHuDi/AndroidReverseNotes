package com.tencent.p177mm.plugin.multitalk.p459ui.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.b */
public final class C43320b {
    public static final int oIa = C1338a.fromDPToPix(C4996ah.getContext(), 3);
    public static final int oIb = C1338a.fromDPToPix(C4996ah.getContext(), 4);
    public static final int oIc = C1338a.fromDPToPix(C4996ah.getContext(), 8);
    public static final int oId = C1338a.fromDPToPix(C4996ah.getContext(), 10);
    public static final int oIe = C1338a.fromDPToPix(C4996ah.getContext(), 14);
    public static final int oIf = C1338a.fromDPToPix(C4996ah.getContext(), 30);
    public static final int oIg = C1338a.fromDPToPix(C4996ah.getContext(), 26);
    public static final int oIh = C1338a.fromDPToPix(C4996ah.getContext(), 32);
    public static final int oIi = C1338a.fromDPToPix(C4996ah.getContext(), 96);
    public static final int oIj = C1338a.fromDPToPix(C4996ah.getContext(), 76);
    public static final int oIk = C1338a.fromDPToPix(C4996ah.getContext(), 230);
    private static int oIl = 0;

    static {
        AppMethodBeat.m2504i(54187);
        AppMethodBeat.m2505o(54187);
    }

    /* renamed from: eC */
    public static int m77261eC(Context context) {
        AppMethodBeat.m2504i(54186);
        if (oIl <= 0) {
            oIl = C5222ae.m7953hy(context).y - oIk;
            C4990ab.m7417i("MicroMsg.MultiTalkDimensUtil", "getMultiTalkAvatarBoardHeight, displaySize: %s, MultiTalkAvatarBoardHeight: %s", r0, Integer.valueOf(oIl));
        }
        int i = oIl;
        AppMethodBeat.m2505o(54186);
        return i;
    }
}
