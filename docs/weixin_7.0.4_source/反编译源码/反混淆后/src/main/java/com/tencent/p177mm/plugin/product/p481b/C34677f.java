package com.tencent.p177mm.plugin.product.p481b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15365ng;
import com.tencent.p177mm.protocal.protobuf.C46569nf;
import com.tencent.p177mm.protocal.protobuf.btx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.product.b.f */
public final class C34677f extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C34677f(LinkedList<btx> linkedList, String str) {
        int i = 0;
        AppMethodBeat.m2504i(43982);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46569nf();
        c1196a.fsK = new C15365ng();
        c1196a.uri = "/cgi-bin/micromsg-bin/cancelpreorder";
        this.ehh = c1196a.acD();
        C46569nf c46569nf = (C46569nf) this.ehh.fsG.fsP;
        c46569nf.vRM = linkedList;
        if (linkedList != null) {
            i = linkedList.size();
        }
        c46569nf.pdi = i;
        c46569nf.vRN = str;
        C4990ab.m7410d("MicroMsg.NetSceneMallCancelPreOrder", "lockId ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(43982);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(43983);
        C15365ng c15365ng = (C15365ng) ((C7472b) c1929q).fsH.fsP;
        if (i3 == 0 && c15365ng.vKp != 0) {
            i3 = c15365ng.vKp;
            str = c15365ng.vKq;
        }
        C4990ab.m7410d("MicroMsg.NetSceneMallCancelPreOrder", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(43983);
    }

    public final int getType() {
        return 555;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43984);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(43984);
        return a;
    }
}
