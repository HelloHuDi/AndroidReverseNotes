package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.model.ba.b;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class a extends k {
    com.tencent.mm.model.ba.a sKQ = new com.tencent.mm.model.ba.a();
    b sKR = new b();

    a() {
        AppMethodBeat.i(26075);
        AppMethodBeat.o(26075);
    }

    public final int getType() {
        return bd.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintresourcersa";
    }

    public final e ZS() {
        return this.sKR;
    }

    public final d ZR() {
        return this.sKQ;
    }

    public final int acC() {
        return 1;
    }
}
