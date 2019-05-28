package com.tencent.mm.plugin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.ab;
import junit.framework.Assert;

public final class f extends a {
    public final void execute(g gVar) {
        AppMethodBeat.i(18528);
        int Lw = m.Lw();
        if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            ab.i("MicroMsg.SightInitTask", "load wechatsight_v7a, core number[%d]", Integer.valueOf(Lw >> 12));
            k.a("wechatsight_v7a", getClass().getClassLoader());
            if ((Lw >> 12) >= 4) {
                b.qwW = 3;
                b.qwY = 3;
                b.qwZ = 544000;
                AppMethodBeat.o(18528);
                return;
            }
            b.qwW = 1;
            b.qwY = 1;
            b.qwZ = 640000;
            AppMethodBeat.o(18528);
            return;
        }
        ab.i("MicroMsg.SightInitTask", "load wechatsight");
        k.a("wechatsight", getClass().getClassLoader());
        Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
        b.qwW = 1;
        b.qwY = 1;
        b.qwZ = 640000;
        AppMethodBeat.o(18528);
    }

    public final String name() {
        return "boot-sight-init";
    }
}
