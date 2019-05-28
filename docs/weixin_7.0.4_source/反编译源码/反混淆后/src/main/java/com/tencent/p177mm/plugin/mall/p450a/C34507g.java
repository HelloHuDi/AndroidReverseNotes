package com.tencent.p177mm.plugin.mall.p450a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ame;
import com.tencent.p177mm.protocal.protobuf.amf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.mall.a.g */
public final class C34507g extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private ame okU;
    public amf okV;

    public C34507g() {
        AppMethodBeat.m2504i(43102);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ame();
        c1196a.fsK = new amf();
        c1196a.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.okU = (ame) this.gme.fsG.fsP;
        AppMethodBeat.m2505o(43102);
    }

    public final int getType() {
        return 1754;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43103);
        C4990ab.m7410d("MicroMsg.NetSceneGetPayMenu", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(43103);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(43104);
        C4990ab.m7417i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            int size;
            this.okV = (amf) this.gme.fsH.fsP;
            String str2 = "MicroMsg.NetSceneGetPayMenu";
            String str3 = "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s";
            Object[] objArr = new Object[3];
            objArr[0] = this.okV.title;
            objArr[1] = this.okV.wrk;
            if (this.okV.wrk != null) {
                size = this.okV.wrk.size();
            } else {
                size = 0;
            }
            objArr[2] = Integer.valueOf(size);
            C4990ab.m7417i(str2, str3, objArr);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(43104);
    }
}
