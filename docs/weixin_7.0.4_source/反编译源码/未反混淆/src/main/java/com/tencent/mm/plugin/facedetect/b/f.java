package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.plugin.facedetect.b.j.a;
import com.tencent.mm.plugin.facedetect.b.j.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class f extends k {
    a lSt = new a();
    b lSu = new b();

    f() {
        AppMethodBeat.i(63);
        AppMethodBeat.o(63);
    }

    public final int getType() {
        return 931;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/registerfacersa";
    }

    public final e ZS() {
        return this.lSu;
    }

    public final d ZR() {
        return this.lSt;
    }

    public final int acC() {
        return 1;
    }
}
