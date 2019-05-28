package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.QbSdk;

public final class o extends c<mp> {
    public o() {
        AppMethodBeat.i(78498);
        this.xxI = mp.class.getName().hashCode();
        AppMethodBeat.o(78498);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(78500);
        boolean aiv = aiv();
        AppMethodBeat.o(78500);
        return aiv;
    }

    private static boolean aiv() {
        boolean z;
        AppMethodBeat.i(78499);
        if (bo.fp(bo.a((Long) g.RP().Ry().get(66818, null), 0)) * 1000 > 1800000) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int a = bo.a((Integer) g.RP().Ry().get(66820, null), (int) QbSdk.EXTENSION_INIT_FAILURE);
            if (a != QbSdk.EXTENSION_INIT_FAILURE) {
                bv.s(9, String.valueOf(a));
                g.RP().Ry().set(66820, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE));
            }
            g.RP().Ry().set(66818, Long.valueOf(bo.anT()));
        }
        AppMethodBeat.o(78499);
        return false;
    }
}
