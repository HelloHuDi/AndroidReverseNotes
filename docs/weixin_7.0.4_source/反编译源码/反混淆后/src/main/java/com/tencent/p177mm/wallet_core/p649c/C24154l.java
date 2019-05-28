package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.C15366nh;
import com.tencent.p177mm.protocal.protobuf.C30206ni;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.wallet_core.c.l */
public final class C24154l extends C36378u {
    private C7472b ehh;
    private C1202f ehi;

    public C24154l(String str, String str2) {
        AppMethodBeat.m2504i(49058);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15366nh();
        c1196a.fsK = new C30206ni();
        c1196a.uri = "/cgi-bin/mmpay-bin/cancelqrpay";
        c1196a.fsL = C27011o.CTRL_INDEX;
        c1196a.fsM = 1000000198;
        c1196a.fsO = C36391e.atB(str2);
        this.ehh = c1196a.acD();
        C15366nh c15366nh = (C15366nh) this.ehh.fsG.fsP;
        c15366nh.vRO = str;
        c15366nh.vHD = str2;
        c15366nh.vRP = C22594k.cPy();
        AppMethodBeat.m2505o(49058);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(49059);
        C4990ab.m7410d("MicroMsg.NetSceneCancelQRPay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(49059);
    }

    public final int getType() {
        return 410;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(49060);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(49060);
        return a;
    }
}
