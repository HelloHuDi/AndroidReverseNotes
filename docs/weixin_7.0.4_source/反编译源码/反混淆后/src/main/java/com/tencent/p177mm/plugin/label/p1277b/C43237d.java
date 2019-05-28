package com.tencent.p177mm.plugin.label.p1277b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bcs;
import com.tencent.p177mm.protocal.protobuf.bct;
import com.tencent.p177mm.protocal.protobuf.cmh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.label.b.d */
public final class C43237d extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private LinkedList<cmh> nHy = new LinkedList();

    public C43237d(LinkedList<cmh> linkedList) {
        AppMethodBeat.m2504i(22530);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bcs();
        c1196a.fsK = new bct();
        c1196a.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
        c1196a.fsI = 638;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.nHy = linkedList;
        AppMethodBeat.m2505o(22530);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(22531);
        C4990ab.m7411d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(22531);
    }

    public final int getType() {
        return 638;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(22532);
        C4990ab.m7410d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
        this.ehi = c1202f;
        bcs bcs = (bcs) this.ehh.fsG.fsP;
        bcs.wHh = this.nHy;
        bcs.wnW = this.nHy.size();
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(22532);
        return a;
    }
}
