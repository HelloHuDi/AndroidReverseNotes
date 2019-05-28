package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.akl;
import com.tencent.p177mm.protocal.protobuf.akm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.i */
public final class C35472i extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private boolean ttT;
    private akl ttX;
    public akm ttY;

    public C35472i(String str, boolean z) {
        AppMethodBeat.m2504i(46512);
        this.ttT = z;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new akl();
        c1196a.fsK = new akm();
        if (z) {
            c1196a.fsI = 2803;
            c1196a.uri = "/cgi-bin/mmpay-bin/mktgetf2flottery";
        } else {
            c1196a.fsI = 2508;
            c1196a.uri = "/cgi-bin/mmpay-bin/mktgetlottery";
        }
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.ttX = (akl) this.gme.fsG.fsP;
        this.ttX.wqf = str;
        C4990ab.m7417i("MicroMsg.NetSceneMktGetLottery", "NetSceneMktGetLottery, getLotteryParams: %s, isF2f: %s", str, Boolean.valueOf(z));
        AppMethodBeat.m2505o(46512);
    }

    public final int getType() {
        if (this.ttT) {
            return 2803;
        }
        return 2508;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46513);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(46513);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(46514);
        C4990ab.m7417i("MicroMsg.NetSceneMktGetLottery", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ttY = (akm) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(46514);
    }
}
