package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.plugin.facedetect.b.i.a;
import com.tencent.mm.plugin.facedetect.b.i.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;

final class h extends k {
    a lSx = new a();
    b lSy = new b();

    h() {
        AppMethodBeat.i(65);
        AppMethodBeat.o(65);
    }

    public final int getType() {
        return 733;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getbioconfigrsa";
    }

    public final e ZS() {
        return this.lSy;
    }

    public final d ZR() {
        return this.lSx;
    }

    public final int acC() {
        return 1;
    }
}
