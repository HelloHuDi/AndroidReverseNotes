package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.amj;

public final class h extends c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.i(20789);
        a aVar = new a();
        aVar.fsJ = new ami();
        aVar.fsK = new amj();
        aVar.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
        aVar.fsI = 1760;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(20789);
    }

    public final int getType() {
        return 1760;
    }

    public h(String str, int i, String str2) {
        AppMethodBeat.i(20790);
        bzd();
        ami ami = (ami) this.ehh.fsG.fsP;
        ami.appId = str;
        ami.mzT = i;
        ami.cxb = str2;
        AppMethodBeat.o(20790);
    }

    public final acq bzh() {
        amj amj = (amj) this.ehh.fsH.fsP;
        if (amj != null) {
            return amj.vAY;
        }
        return null;
    }
}
