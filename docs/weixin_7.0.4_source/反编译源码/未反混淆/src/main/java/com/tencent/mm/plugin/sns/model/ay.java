package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bau;

final class ay {
    bau cNr;
    String cwT;
    int egD;
    int egF;
    int fDG;
    String fUL;
    String qNS;

    ay() {
    }

    public final String toString() {
        AppMethodBeat.i(36741);
        String str = "cdnMediaId " + this.fUL + " isPlayMode " + this.egD + " createTime " + this.fDG + " snsLocalId " + this.cwT + " postName " + this.qNS + " url " + this.cNr.Url;
        AppMethodBeat.o(36741);
        return str;
    }
}
