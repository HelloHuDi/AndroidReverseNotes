package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.model.bc.a;
import com.tencent.mm.model.bc.b;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class c extends k {
    a sKU = new a();
    b sKV = new b();

    c() {
        AppMethodBeat.i(26077);
        AppMethodBeat.o(26077);
    }

    public final int getType() {
        return be.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/verifyvoiceprintrsa";
    }

    public final e ZS() {
        return this.sKV;
    }

    public final d ZR() {
        return this.sKU;
    }

    public final int acC() {
        return 1;
    }
}
