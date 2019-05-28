package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aex;
import com.tencent.p177mm.protocal.protobuf.aey;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.e */
public final class C43787e extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public aey ttO;

    public C43787e(String str) {
        AppMethodBeat.m2504i(46500);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aex();
        c1196a.fsK = new aey();
        c1196a.uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
        c1196a.fsO = C36391e.atB(str);
        this.ehh = c1196a.acD();
        aex aex = (aex) this.ehh.fsG.fsP;
        C4990ab.m7411d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", str);
        aex.cBT = str;
        AppMethodBeat.m2505o(46500);
    }

    public final int getType() {
        return 1667;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46501);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(46501);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(46502);
        C4990ab.m7417i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.ttO = (aey) this.ehh.fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(46502);
    }
}
