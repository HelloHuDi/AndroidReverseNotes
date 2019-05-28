package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.c.a;
import com.tencent.mm.plugin.expt.c.d;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class c {
    public static void a(String str, int i, a aVar) {
        AppMethodBeat.i(73458);
        int i2 = -1;
        if (aVar == a.MMActivity_Back2Front) {
            i2 = 7;
        } else if (aVar == a.MMActivity_Front2Back) {
            i2 = 8;
        }
        if (b.bqo() && !d.brc()) {
            if (aVar == a.MMActivity_Back2Front) {
                h.pYm.a(932, 91, 1, false);
            } else if (aVar == a.MMActivity_Front2Back) {
                h.pYm.a(932, 92, 1, false);
            }
            ab.i("HellFrontBackReport", "habbyge-mali, 切换-前后台(3): " + i2 + " / " + str + " 未登录");
        }
        ab.i("HellFrontBackReport", "habbyge-mali, 切换-前后台(3): " + i2 + " / " + str);
        d.brb().a(str, aVar, i);
        AppMethodBeat.o(73458);
    }

    static void a(String str, a aVar, int i, long j) {
        AppMethodBeat.i(73459);
        d.brb().a(str, aVar, i, j);
        AppMethodBeat.o(73459);
    }
}
