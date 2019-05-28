package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aep;
import com.tencent.p177mm.protocal.protobuf.aeq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.h */
public final class C22561h extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private aep ttU;
    public aeq ttV;
    public long ttW;

    public C22561h(String str, long j) {
        AppMethodBeat.m2504i(46509);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aep();
        c1196a.fsK = new aeq();
        c1196a.uri = "/cgi-bin/mmpay-bin/mktgetaward";
        this.gme = c1196a.acD();
        this.ttU = (aep) this.gme.fsG.fsP;
        this.ttU.wmr = str;
        this.ttW = j;
        C4990ab.m7417i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", str, Long.valueOf(j));
        AppMethodBeat.m2505o(46509);
    }

    public final int getType() {
        return 2948;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46510);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(46510);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(46511);
        C4990ab.m7417i("MicroMsg.NetSceneMktGetAward", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ttV = (aeq) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            C4990ab.m7417i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", Integer.valueOf(this.ttV.kdT), this.ttV.kdU, Integer.valueOf(this.ttV.wms), this.ttV.wmt, this.ttV.wmu);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(46511);
    }
}
