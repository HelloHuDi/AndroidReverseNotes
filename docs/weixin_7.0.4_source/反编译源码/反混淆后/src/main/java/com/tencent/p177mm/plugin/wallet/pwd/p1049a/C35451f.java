package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.boi;
import com.tencent.p177mm.protocal.protobuf.boj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.f */
public final class C35451f extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private boj tqy;

    public C35451f() {
        AppMethodBeat.m2504i(46172);
        C1196a c1196a = new C1196a();
        boi boi = new boi();
        boi.vzS = System.currentTimeMillis();
        c1196a.fsJ = boi;
        c1196a.fsK = new boj();
        c1196a.uri = "/cgi-bin/mmpay-bin/querywalletentrancebalanceswitchstate";
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(46172);
    }

    public final int getType() {
        return 2635;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46173);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(46173);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(46174);
        C4990ab.m7421w("MicroMsg.NetSceneQueryWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.tqy = (boj) ((C7472b) c1929q).fsH.fsP;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(46174);
    }

    public final boj cOm() {
        AppMethodBeat.m2504i(46175);
        boj boj;
        if (this.tqy == null) {
            boj = new boj();
            AppMethodBeat.m2505o(46175);
            return boj;
        }
        boj = this.tqy;
        AppMethodBeat.m2505o(46175);
        return boj;
    }
}
