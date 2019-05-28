package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C30252zb;
import com.tencent.p177mm.protocal.protobuf.C40593zc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.j */
public final class C22562j extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private boolean ttT;
    private C30252zb ttZ;
    public C40593zc tua;

    public C22562j(String str, boolean z) {
        AppMethodBeat.m2504i(46515);
        this.ttT = z;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30252zb();
        c1196a.fsK = new C40593zc();
        if (z) {
            c1196a.fsI = 2529;
            c1196a.uri = "/cgi-bin/mmpay-bin/mktf2fmodifyexposure";
        } else {
            c1196a.fsI = 2888;
            c1196a.uri = "/cgi-bin/mmpay-bin/mktmodifyexposure";
        }
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.ttZ = (C30252zb) this.gme.fsG.fsP;
        this.ttZ.wev = str;
        AppMethodBeat.m2505o(46515);
    }

    public final int getType() {
        if (this.ttT) {
            return 2529;
        }
        return 2888;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46516);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(46516);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(46517);
        C4990ab.m7417i("MicroMsg.NetSceneMktModifyExposure", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tua = (C40593zc) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(46517);
    }
}
