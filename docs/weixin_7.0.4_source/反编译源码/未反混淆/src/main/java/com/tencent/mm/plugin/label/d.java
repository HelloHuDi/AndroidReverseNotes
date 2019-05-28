package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends c<mp> {
    public d() {
        AppMethodBeat.i(22511);
        this.xxI = mp.class.getName().hashCode();
        AppMethodBeat.o(22511);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(22513);
        boolean aiv = aiv();
        AppMethodBeat.o(22513);
        return aiv;
    }

    private static boolean aiv() {
        int i;
        AppMethodBeat.i(22512);
        aw.ZK();
        if (System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.Ry().get(209408, Long.valueOf(0))).longValue() > 86400000) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            ab.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
            aw.Rg().a(new com.tencent.mm.plugin.label.b.c(), 0);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(209408, Long.valueOf((System.currentTimeMillis() - 86400000) + 1800000));
        }
        AppMethodBeat.o(22512);
        return false;
    }
}
