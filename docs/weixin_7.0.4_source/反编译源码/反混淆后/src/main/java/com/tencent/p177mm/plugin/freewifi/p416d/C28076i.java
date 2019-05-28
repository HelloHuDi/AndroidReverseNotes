package com.tencent.p177mm.plugin.freewifi.p416d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.amm;
import com.tencent.p177mm.protocal.protobuf.amn;

/* renamed from: com.tencent.mm.plugin.freewifi.d.i */
public final class C28076i extends C43104c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.m2504i(20791);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new amm();
        c1196a.fsK = new amn();
        c1196a.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
        c1196a.fsI = 1709;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(20791);
    }

    public final int getType() {
        return 1709;
    }

    public C28076i(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(20792);
        bzd();
        amm amm = (amm) this.ehh.fsG.fsP;
        amm.cuH = str;
        amm.mvO = str2;
        amm.mvP = str3;
        amm.mvQ = str4;
        amm.cxb = str5;
        amm.vAN = str6;
        AppMethodBeat.m2505o(20792);
    }

    public final String bzn() {
        return ((amn) this.ehh.fsH.fsP).mwV;
    }

    public final String bzo() {
        return ((amn) this.ehh.fsH.fsP).mwW;
    }
}
