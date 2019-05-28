package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.soter.b.c.a;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class b extends k {
    a rNC = new a();
    com.tencent.mm.plugin.soter.b.c.b rND = new com.tencent.mm.plugin.soter.b.c.b();

    b() {
        AppMethodBeat.i(59297);
        AppMethodBeat.o(59297);
    }

    public final int getType() {
        return ag.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/updatesoteraskrsa";
    }

    public final e ZS() {
        return this.rND;
    }

    public final d ZR() {
        return this.rNC;
    }

    public final int acC() {
        return 1;
    }
}
