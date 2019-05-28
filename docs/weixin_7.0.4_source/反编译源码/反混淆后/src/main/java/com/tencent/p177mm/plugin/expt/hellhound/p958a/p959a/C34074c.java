package com.tencent.p177mm.plugin.expt.hellhound.p958a.p959a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.hellhound.core.C11759b;
import com.tencent.p177mm.plugin.expt.p394a.C43014c.C38982a;
import com.tencent.p177mm.plugin.expt.p395c.C11747d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.a.a.c */
public final class C34074c {
    /* renamed from: a */
    public static void m55846a(String str, int i, C38982a c38982a) {
        AppMethodBeat.m2504i(73458);
        int i2 = -1;
        if (c38982a == C38982a.MMActivity_Back2Front) {
            i2 = 7;
        } else if (c38982a == C38982a.MMActivity_Front2Back) {
            i2 = 8;
        }
        if (C11759b.bqo() && !C11747d.brc()) {
            if (c38982a == C38982a.MMActivity_Back2Front) {
                C7060h.pYm.mo8378a(932, 91, 1, false);
            } else if (c38982a == C38982a.MMActivity_Front2Back) {
                C7060h.pYm.mo8378a(932, 92, 1, false);
            }
            C4990ab.m7416i("HellFrontBackReport", "habbyge-mali, 切换-前后台(3): " + i2 + " / " + str + " 未登录");
        }
        C4990ab.m7416i("HellFrontBackReport", "habbyge-mali, 切换-前后台(3): " + i2 + " / " + str);
        C11747d.brb().mo23509a(str, c38982a, i);
        AppMethodBeat.m2505o(73458);
    }

    /* renamed from: a */
    static void m55847a(String str, C38982a c38982a, int i, long j) {
        AppMethodBeat.m2504i(73459);
        C11747d.brb().mo23510a(str, c38982a, i, j);
        AppMethodBeat.m2505o(73459);
    }
}
