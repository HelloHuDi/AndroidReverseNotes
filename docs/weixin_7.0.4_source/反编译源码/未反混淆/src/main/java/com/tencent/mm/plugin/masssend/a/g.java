package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends c<mp> {
    public g() {
        AppMethodBeat.i(22741);
        this.xxI = mp.class.getName().hashCode();
        AppMethodBeat.o(22741);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(22743);
        boolean aiv = aiv();
        AppMethodBeat.o(22743);
        return aiv;
    }

    private static boolean aiv() {
        AppMethodBeat.i(22742);
        if (aw.RK()) {
            boolean z;
            h.bNF();
            aw.ZK();
            if (bo.gb(bo.a((Long) com.tencent.mm.model.c.Ry().get(102409, null), 0)) > 900000) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                h.bNF().bNA();
                h.bNF();
                c.je(bo.anU());
                AppMethodBeat.o(22742);
            } else {
                ab.d("MicroMsg.PostTaskMassSendListener", "time limit");
                AppMethodBeat.o(22742);
            }
        } else {
            ab.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
            AppMethodBeat.o(22742);
        }
        return false;
    }
}
