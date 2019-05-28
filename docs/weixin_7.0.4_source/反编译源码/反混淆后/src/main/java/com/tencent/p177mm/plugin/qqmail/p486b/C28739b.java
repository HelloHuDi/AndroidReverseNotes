package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p230g.p231a.C18211ag;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.qqmail.b.b */
final class C28739b extends C4884c<C18211ag> {
    C28739b() {
        AppMethodBeat.m2504i(67917);
        this.xxI = C18211ag.class.getName().hashCode();
        AppMethodBeat.m2505o(67917);
    }

    /* renamed from: a */
    private static boolean m45668a(C18211ag c18211ag) {
        AppMethodBeat.m2504i(67918);
        if (c18211ag instanceof C18211ag) {
            if (c18211ag.ctc.cte == 0) {
                try {
                    C1720g.m3536RP().mo5239Ry().set(17, Integer.valueOf(2));
                    int YK = C1853r.m3829YK() | 1;
                    C1720g.m3536RP().mo5239Ry().set(34, Integer.valueOf(YK));
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", YK, "", ""));
                    C12884ac.ccE();
                    C4990ab.m7410d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.QQMail.EventListener", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(67918);
        } else {
            C4990ab.m7414f("MicroMsg.QQMail.EventListener", "not bind qq event");
            AppMethodBeat.m2505o(67918);
        }
        return false;
    }
}
