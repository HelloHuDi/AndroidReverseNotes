package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.model.bb.a;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class b extends k {
    a sKS = new a();
    com.tencent.mm.model.bb.b sKT = new com.tencent.mm.model.bb.b();

    b() {
        AppMethodBeat.i(26076);
        AppMethodBeat.o(26076);
    }

    public final int getType() {
        return bb.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintticketrsa";
    }

    public final e ZS() {
        return this.sKT;
    }

    public final d ZR() {
        return this.sKS;
    }

    public final int acC() {
        return 1;
    }
}
