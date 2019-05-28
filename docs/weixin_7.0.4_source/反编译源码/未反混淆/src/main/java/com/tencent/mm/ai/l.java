package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.r.a;
import com.tencent.mm.protocal.r.b;

public final class l extends k {
    private final a ftd = new a();
    private final b fte = new b();

    public l() {
        AppMethodBeat.i(58161);
        AppMethodBeat.o(58161);
    }

    /* Access modifiers changed, original: protected|final */
    public final d ZR() {
        return this.ftd;
    }

    public final e ZS() {
        return this.fte;
    }

    public final int getType() {
        return 381;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getcert";
    }

    public final int acC() {
        return 1;
    }
}
