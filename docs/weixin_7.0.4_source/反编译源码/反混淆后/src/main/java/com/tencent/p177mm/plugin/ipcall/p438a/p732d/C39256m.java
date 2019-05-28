package com.tencent.p177mm.plugin.ipcall.p438a.p732d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bxb;
import com.tencent.p177mm.protocal.protobuf.bxc;
import com.tencent.p177mm.protocal.protobuf.cru;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d.m */
public final class C39256m extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi;
    private bxb nyE = null;
    public bxc nyF = null;

    public C39256m(int i, int i2, LinkedList<cru> linkedList) {
        AppMethodBeat.m2504i(21872);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bxb();
        c1196a.fsK = new bxc();
        c1196a.fsI = 871;
        c1196a.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.nyE = (bxb) this.ehh.fsG.fsP;
        this.nyE.wGh = i2;
        this.nyE.wXk = linkedList;
        this.nyE.wXj = linkedList.size();
        this.nyE.wXl = i;
        C4990ab.m7417i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(linkedList.size()));
        AppMethodBeat.m2505o(21872);
    }

    public final int getType() {
        return 871;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(21873);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(21873);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(21874);
        C4990ab.m7417i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyF = (bxc) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(21874);
    }
}
