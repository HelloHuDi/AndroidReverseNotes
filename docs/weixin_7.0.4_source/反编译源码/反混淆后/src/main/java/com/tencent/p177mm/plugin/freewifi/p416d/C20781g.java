package com.tencent.p177mm.plugin.freewifi.p416d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.protocal.protobuf.ajv;
import com.tencent.p177mm.protocal.protobuf.ajw;

/* renamed from: com.tencent.mm.plugin.freewifi.d.g */
public final class C20781g extends C43104c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.m2504i(20787);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ajv();
        c1196a.fsK = new ajw();
        c1196a.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
        c1196a.fsI = 1746;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(20787);
    }

    public final int getType() {
        return 1746;
    }

    public C20781g(String str, String str2, String str3) {
        AppMethodBeat.m2504i(20788);
        bzd();
        ajv ajv = (ajv) this.ehh.fsG.fsP;
        ajv.mvO = str;
        ajv.mvP = str2;
        ajv.mvQ = str3;
        ajv.vBe = C34189m.byv();
        AppMethodBeat.m2505o(20788);
    }

    public final String bzm() {
        return ((ajw) this.ehh.fsH.fsP).wpv;
    }
}
