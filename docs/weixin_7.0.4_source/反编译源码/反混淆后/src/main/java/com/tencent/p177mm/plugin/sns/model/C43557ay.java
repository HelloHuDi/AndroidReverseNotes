package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.bau;

/* renamed from: com.tencent.mm.plugin.sns.model.ay */
final class C43557ay {
    bau cNr;
    String cwT;
    int egD;
    int egF;
    int fDG;
    String fUL;
    String qNS;

    C43557ay() {
    }

    public final String toString() {
        AppMethodBeat.m2504i(36741);
        String str = "cdnMediaId " + this.fUL + " isPlayMode " + this.egD + " createTime " + this.fDG + " snsLocalId " + this.cwT + " postName " + this.qNS + " url " + this.cNr.Url;
        AppMethodBeat.m2505o(36741);
        return str;
    }
}
