package com.tencent.p177mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.C44198ys;
import com.tencent.p177mm.protocal.protobuf.C44199yt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.order.model.f */
public final class C21422f extends C36378u {
    private C7472b ehh;
    private C1202f ehi;

    public C21422f(String str, String str2, int i) {
        AppMethodBeat.m2504i(43775);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44198ys();
        c1196a.fsK = new C44199yt();
        c1196a.uri = "/cgi-bin/micromsg-bin/evaluateorder";
        this.ehh = c1196a.acD();
        C44198ys c44198ys = (C44198ys) this.ehh.fsG.fsP;
        c44198ys.wes = str;
        c44198ys.fKh = str2;
        c44198ys.pXD = i;
        c44198ys.vRP = C22594k.cPy();
        AppMethodBeat.m2505o(43775);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(43776);
        C4990ab.m7410d("MicroMsg.NetSceneEvaluateOrder", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(43776);
    }

    public final int getType() {
        return 583;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43777);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(43777);
        return a;
    }
}
