package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bnt;
import com.tencent.p177mm.protocal.protobuf.bnu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.k */
public final class C29618k extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    public String ssr;
    private bnt tub;
    public bnu tuc;

    public C29618k(String str, String str2) {
        AppMethodBeat.m2504i(46518);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bnt();
        c1196a.fsK = new bnu();
        c1196a.uri = "/cgi-bin/mmpay-bin/mktqueryawardstatus";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.tub = (bnt) this.gme.fsG.fsP;
        this.tub.tIJ = str;
        this.ssr = str2;
        C4990ab.m7417i("MicroMsg.NetSceneMtkQueryAwardStatus", "NetSceneMtkQueryAwardStatus, query_award_status_params: %s, activityId: %s", str, str2);
        AppMethodBeat.m2505o(46518);
    }

    public final int getType() {
        return 2710;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46519);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(46519);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(46520);
        C4990ab.m7417i("MicroMsg.NetSceneMtkQueryAwardStatus", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tuc = (bnu) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            C4990ab.m7417i("MicroMsg.NetSceneMtkQueryAwardStatus", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.tuc.kdT), this.tuc.kdU);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(46520);
    }
}
