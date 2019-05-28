package com.tencent.p177mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;

/* renamed from: com.tencent.mm.modelsns.c */
public final class C32830c {
    public static int fQr = 0;
    public static C32830c fQs = new C32830c();

    static {
        AppMethodBeat.m2504i(94482);
        AppMethodBeat.m2505o(94482);
    }

    public static void ajL() {
        AppMethodBeat.m2504i(94481);
        C5141c ll = C18624c.abi().mo17131ll("100024");
        C4990ab.m7416i("MicroMsg.StatisticsOplogAbTest", "test " + ll.field_rawXML + " " + ll.isValid());
        if (ll.isValid()) {
            fQr = C5046bo.ank((String) ll.dru().get("Switch"));
            C4990ab.m7416i("MicroMsg.StatisticsOplogAbTest", "switchVal " + fQr);
        }
        AppMethodBeat.m2505o(94481);
    }
}
