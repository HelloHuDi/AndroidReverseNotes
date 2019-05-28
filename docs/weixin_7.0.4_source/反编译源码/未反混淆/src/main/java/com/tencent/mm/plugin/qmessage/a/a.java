package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class a extends c<ag> {
    a() {
        AppMethodBeat.i(24069);
        this.xxI = ag.class.getName().hashCode();
        AppMethodBeat.o(24069);
    }

    private static boolean a(ag agVar) {
        AppMethodBeat.i(24070);
        if (agVar instanceof ag) {
            if (agVar.ctc.cte == 0) {
                try {
                    int YK = r.YK() | 32;
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(34, Integer.valueOf(YK));
                    aw.ZK();
                    com.tencent.mm.model.c.XL().c(new k("", "", "", "", "", "", "", "", YK, "", ""));
                    g.ccc();
                    ab.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.QMsg.EventListener", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(24070);
        } else {
            ab.f("MicroMsg.QMsg.EventListener", "not bind qq event");
            AppMethodBeat.o(24070);
        }
        return false;
    }
}
