package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.byh;
import com.tencent.p177mm.protocal.protobuf.byi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.h */
public final class C14199h extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private byi tqA;
    public byh tqz;

    public C14199h(boolean z) {
        AppMethodBeat.m2504i(46178);
        C1196a c1196a = new C1196a();
        byh byh = new byh();
        byh.vzS = System.currentTimeMillis();
        if (z) {
            byh.wXF = 1;
        } else {
            byh.wXF = 0;
        }
        this.tqz = byh;
        c1196a.fsJ = byh;
        c1196a.fsK = new byi();
        c1196a.uri = "/cgi-bin/mmpay-bin/setwalletentrancebalanceswitchstate";
        c1196a.fsI = 2554;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(46178);
    }

    public final int getType() {
        return 2554;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46179);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(46179);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(46180);
        C4990ab.m7421w("MicroMsg.NetSceneSetWalletEntranceBalanceSwitchState", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.tqA = (byi) ((C7472b) c1929q).fsH.fsP;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(46180);
    }

    public final byi cOn() {
        AppMethodBeat.m2504i(46181);
        byi byi;
        if (this.tqA == null) {
            byi = new byi();
            AppMethodBeat.m2505o(46181);
            return byi;
        }
        byi = this.tqA;
        AppMethodBeat.m2505o(46181);
        return byi;
    }
}
