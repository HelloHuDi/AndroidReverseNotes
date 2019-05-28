package com.tencent.p177mm.plugin.qmessage.p739a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p230g.p231a.C18211ag;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.qmessage.a.a */
final class C7024a extends C4884c<C18211ag> {
    C7024a() {
        AppMethodBeat.m2504i(24069);
        this.xxI = C18211ag.class.getName().hashCode();
        AppMethodBeat.m2505o(24069);
    }

    /* renamed from: a */
    private static boolean m11729a(C18211ag c18211ag) {
        AppMethodBeat.m2504i(24070);
        if (c18211ag instanceof C18211ag) {
            if (c18211ag.ctc.cte == 0) {
                try {
                    int YK = C1853r.m3829YK() | 32;
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(34, Integer.valueOf(YK));
                    C9638aw.m17190ZK();
                    C18628c.m29077XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", YK, "", ""));
                    C46142g.ccc();
                    C4990ab.m7410d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.QMsg.EventListener", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(24070);
        } else {
            C4990ab.m7414f("MicroMsg.QMsg.EventListener", "not bind qq event");
            AppMethodBeat.m2505o(24070);
        }
        return false;
    }
}
