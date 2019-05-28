package com.tencent.p177mm.plugin.product.p481b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35905au;
import com.tencent.p177mm.protocal.protobuf.C35968ze;
import com.tencent.p177mm.protocal.protobuf.bli;
import com.tencent.p177mm.protocal.protobuf.blj;
import com.tencent.p177mm.protocal.protobuf.btx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.product.b.j */
public final class C34681j extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public String pgQ;
    public LinkedList<C35968ze> phb;
    public LinkedList<C35905au> phc;

    public C34681j(LinkedList<btx> linkedList, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(43994);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bli();
        c1196a.fsK = new blj();
        c1196a.uri = "/cgi-bin/micromsg-bin/presubmitorder";
        this.ehh = c1196a.acD();
        bli bli = (bli) this.ehh.fsG.fsP;
        bli.vRM = linkedList;
        if (linkedList != null) {
            i2 = linkedList.size();
        }
        bli.pdi = i2;
        bli.wOo = i;
        AppMethodBeat.m2505o(43994);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(43995);
        blj blj = (blj) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0 && blj.vKp == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + blj.wpD);
            C4990ab.m7410d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + blj.vRN);
            this.phb = blj.wOp;
            this.pgQ = blj.vRN;
            this.phc = blj.wOq;
        }
        if (i3 == 0 && blj.vKp != 0) {
            i3 = blj.vKp;
            str = blj.vKq;
        }
        C4990ab.m7410d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(43995);
    }

    public final int getType() {
        return 554;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43996);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(43996);
        return a;
    }
}
