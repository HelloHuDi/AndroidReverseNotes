package com.tencent.p177mm.plugin.freewifi.p416d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15380re;
import com.tencent.p177mm.protocal.protobuf.C30219rf;

/* renamed from: com.tencent.mm.plugin.freewifi.d.d */
public final class C39101d extends C43104c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.m2504i(20779);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15380re();
        c1196a.fsK = new C30219rf();
        c1196a.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
        c1196a.fsI = 1155;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(20779);
    }

    public final int getType() {
        return 1155;
    }

    public C39101d(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7) {
        AppMethodBeat.m2504i(20780);
        bzd();
        C15380re c15380re = (C15380re) this.ehh.fsG.fsP;
        c15380re.vYm = str;
        c15380re.vYn = str2;
        c15380re.vYo = str3;
        c15380re.vYp = str4;
        c15380re.vYq = str5;
        c15380re.vYr = j;
        c15380re.vYs = str6;
        c15380re.vYt = str7;
        AppMethodBeat.m2505o(20780);
    }

    public final C30219rf bzk() {
        return (C30219rf) this.ehh.fsH.fsP;
    }
}
