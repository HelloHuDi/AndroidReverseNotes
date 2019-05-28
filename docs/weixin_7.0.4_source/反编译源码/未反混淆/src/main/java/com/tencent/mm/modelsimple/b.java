package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.w.a;

final class b extends k {
    private final a fOn = new a();
    private final com.tencent.mm.protocal.w.b fOo = new com.tencent.mm.protocal.w.b();

    b() {
        AppMethodBeat.i(78563);
        AppMethodBeat.o(78563);
    }

    public final d ZR() {
        return this.fOn;
    }

    public final e ZS() {
        return this.fOo;
    }

    public final int getType() {
        return 26;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/sendcard";
    }
}
