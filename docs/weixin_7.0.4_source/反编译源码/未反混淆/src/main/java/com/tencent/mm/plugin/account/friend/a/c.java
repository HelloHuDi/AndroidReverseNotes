package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends com.tencent.mm.sdk.b.c<ag> {
    public c() {
        AppMethodBeat.i(108323);
        this.xxI = ag.class.getName().hashCode();
        AppMethodBeat.o(108323);
    }

    private static boolean a(ag agVar) {
        AppMethodBeat.i(108324);
        if (agVar.ctc.cte == 0) {
            try {
                int YK = r.YK() | 4096;
                g.RP().Ry().set(34, Integer.valueOf(YK));
                ((j) g.K(j.class)).XL().c(new k("", "", "", "", "", "", "", "", YK, "", ""));
                ab.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(108324);
        return false;
    }
}
