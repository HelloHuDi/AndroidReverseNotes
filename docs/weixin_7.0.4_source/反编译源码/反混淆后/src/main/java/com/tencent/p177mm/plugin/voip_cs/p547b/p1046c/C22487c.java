package com.tencent.p177mm.plugin.voip_cs.p547b.p1046c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.cot;
import com.tencent.p177mm.protocal.protobuf.cou;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.c.c */
public final class C22487c extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C22487c(int i, String str, int i2, byte[] bArr, byte[] bArr2, String str2) {
        AppMethodBeat.m2504i(135377);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cot();
        c1196a.fsK = new cou();
        c1196a.uri = "/cgi-bin/micromsg-bin/csvoipinvite";
        this.ehh = c1196a.acD();
        cot cot = (cot) this.ehh.fsG.fsP;
        cot.wOQ = i;
        cot.xmv = str;
        cot.vZF = i2;
        cot.xmw = C1332b.m2847bI(bArr);
        cot.xmx = C1332b.m2847bI(bArr2);
        cot.wOP = System.currentTimeMillis();
        if (!(str2 == null || str2.equals(""))) {
            cot.xmy = str2;
        }
        AppMethodBeat.m2505o(135377);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(135378);
        C4990ab.m7417i("MicroMsg.NetSceneVoipCSInvite", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(135378);
    }

    public final int getType() {
        return 823;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(135379);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(135379);
        return a;
    }
}
