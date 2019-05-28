package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23466xq;
import com.tencent.p177mm.protocal.protobuf.C46597xp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.g */
public final class C43789g extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private C46597xp ttR;
    public C23466xq ttS;
    private boolean ttT;

    public C43789g(String str, int i, boolean z) {
        AppMethodBeat.m2504i(46506);
        this.ttT = z;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46597xp();
        c1196a.fsK = new C23466xq();
        if (z) {
            c1196a.fsI = 1859;
            c1196a.uri = "/cgi-bin/mmpay-bin/mktdrawf2flottery";
        } else {
            c1196a.fsI = 2547;
            c1196a.uri = "/cgi-bin/mmpay-bin/mktdrawlottery";
        }
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.ttR = (C46597xp) this.gme.fsG.fsP;
        this.ttR.wdr = str;
        this.ttR.wds = i;
        C4990ab.m7417i("MicroMsg.NetSceneMktDrawLottery", "NetSceneMktDrawLottery, drawLotteryParams: %s, drawLotteryType: %s, isF2f: %s", str, Integer.valueOf(i), Boolean.valueOf(z));
        AppMethodBeat.m2505o(46506);
    }

    public final int getType() {
        if (this.ttT) {
            return 1859;
        }
        return 2547;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46507);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(46507);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(46508);
        C4990ab.m7417i("MicroMsg.NetSceneMktDrawLottery", "onGYNetEnd netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ttS = (C23466xq) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(46508);
    }
}
