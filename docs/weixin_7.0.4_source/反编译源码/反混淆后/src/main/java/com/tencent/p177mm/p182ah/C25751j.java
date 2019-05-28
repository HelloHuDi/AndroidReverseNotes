package com.tencent.p177mm.p182ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15348ii;
import com.tencent.p177mm.protocal.protobuf.C7542ij;
import com.tencent.p177mm.protocal.protobuf.auk;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ah.j */
public final class C25751j extends C1207m implements C1918k {
    private C1202f ehi;
    LinkedList<bts> fsa = null;
    LinkedList<auk> fsb = null;

    public C25751j(LinkedList<bts> linkedList) {
        this.fsa = linkedList;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(77930);
        if (this.fsa == null || this.fsa.size() <= 0) {
            C4990ab.m7412e("MicroMsg.NetSceneBatchGetHeadImg", C1447g.m3075Mq() + "doScene ReqSize==0");
            AppMethodBeat.m2505o(77930);
            return -1;
        }
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15348ii();
        c1196a.fsK = new C7542ij();
        c1196a.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
        c1196a.fsI = 123;
        c1196a.fsL = 15;
        c1196a.fsM = 1000000015;
        C7472b acD = c1196a.acD();
        C15348ii c15348ii = (C15348ii) acD.fsG.fsP;
        c15348ii.vEg = this.fsa;
        c15348ii.jBv = this.fsa.size();
        int a = mo4457a(c1902e, acD, this);
        AppMethodBeat.m2505o(77930);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 20;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(77931);
        C4990ab.m7410d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + i2 + " errCode:" + i3);
        this.fsb = ((C7542ij) ((C7472b) c1929q).fsH.fsP).vKC;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(77931);
    }

    public final int getType() {
        return 123;
    }
}
