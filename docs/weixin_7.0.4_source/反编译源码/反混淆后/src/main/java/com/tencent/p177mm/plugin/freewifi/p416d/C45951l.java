package com.tencent.p177mm.plugin.freewifi.p416d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.byb;
import com.tencent.p177mm.protocal.protobuf.byc;

/* renamed from: com.tencent.mm.plugin.freewifi.d.l */
public final class C45951l extends C43104c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.m2504i(20798);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new byb();
        c1196a.fsK = new byc();
        c1196a.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
        c1196a.fsI = 1761;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(20798);
    }

    public final int getType() {
        return 1761;
    }

    public C45951l(String str, int i, String str2) {
        AppMethodBeat.m2504i(20799);
        bzd();
        byb byb = (byb) this.ehh.fsG.fsP;
        byb.appId = str;
        byb.mzT = i;
        byb.cxb = str2;
        AppMethodBeat.m2505o(20799);
    }
}
