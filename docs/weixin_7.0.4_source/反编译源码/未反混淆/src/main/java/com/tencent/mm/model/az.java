package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;

public final class az extends k {
    private final a flU = new a();
    private final b flV = new b();

    public az() {
        AppMethodBeat.i(58106);
        AppMethodBeat.o(58106);
    }

    public final d ZR() {
        return this.flU;
    }

    public final e ZS() {
        return this.flV;
    }

    public final int getType() {
        return 126;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/newreg";
    }
}
