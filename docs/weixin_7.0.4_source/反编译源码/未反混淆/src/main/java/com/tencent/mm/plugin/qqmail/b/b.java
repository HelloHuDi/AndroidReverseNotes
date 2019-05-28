package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class b extends c<ag> {
    b() {
        AppMethodBeat.i(67917);
        this.xxI = ag.class.getName().hashCode();
        AppMethodBeat.o(67917);
    }

    private static boolean a(ag agVar) {
        AppMethodBeat.i(67918);
        if (agVar instanceof ag) {
            if (agVar.ctc.cte == 0) {
                try {
                    g.RP().Ry().set(17, Integer.valueOf(2));
                    int YK = r.YK() | 1;
                    g.RP().Ry().set(34, Integer.valueOf(YK));
                    ((j) g.K(j.class)).XL().c(new k("", "", "", "", "", "", "", "", YK, "", ""));
                    ac.ccE();
                    ab.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.QQMail.EventListener", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(67918);
        } else {
            ab.f("MicroMsg.QQMail.EventListener", "not bind qq event");
            AppMethodBeat.o(67918);
        }
        return false;
    }
}
