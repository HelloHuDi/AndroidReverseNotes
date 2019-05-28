package com.tencent.p177mm.plugin.product.p481b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33337c;
import com.tencent.p177mm.protocal.protobuf.C35968ze;
import com.tencent.p177mm.protocal.protobuf.C40508cx;
import com.tencent.p177mm.protocal.protobuf.akb;
import com.tencent.p177mm.protocal.protobuf.akc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.product.b.g */
public final class C34678g extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public LinkedList<C35968ze> phb;
    public String phj;

    public C34678g(String str, String str2, C40508cx c40508cx) {
        AppMethodBeat.m2504i(43985);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new akb();
        c1196a.fsK = new akc();
        c1196a.uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
        c1196a.fsI = C33337c.CTRL_INDEX;
        this.ehh = c1196a.acD();
        akb akb = (akb) this.ehh.fsG.fsP;
        this.phj = str;
        akb.vQq = str;
        C4990ab.m7410d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid ".concat(String.valueOf(str)));
        akb.vRN = str2;
        akb.wpB = c40508cx;
        AppMethodBeat.m2505o(43985);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(43986);
        akc akc = (akc) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0 && akc.vKp == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + akc.wpD);
            this.phb = akc.wpC;
        }
        if (i3 == 0 && akc.vKp != 0) {
            i3 = akc.vKp;
            str = akc.vKq;
        }
        C4990ab.m7410d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(43986);
    }

    public final int getType() {
        return C33337c.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43987);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(43987);
        return a;
    }
}
