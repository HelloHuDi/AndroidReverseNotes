package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.plugin.facedetect.b.k.a;
import com.tencent.mm.plugin.facedetect.b.k.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class g extends k {
    a lSv = new a();
    b lSw = new b();

    g() {
        AppMethodBeat.i(64);
        AppMethodBeat.o(64);
    }

    public final int getType() {
        return 930;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/verifyfacersa";
    }

    public final e ZS() {
        return this.lSw;
    }

    public final d ZR() {
        return this.lSv;
    }

    public final int acC() {
        return 1;
    }
}
