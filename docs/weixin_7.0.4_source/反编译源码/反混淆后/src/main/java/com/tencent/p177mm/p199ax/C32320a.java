package com.tencent.p177mm.p199ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bmp;
import com.tencent.p177mm.protocal.protobuf.bmq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ax.a */
public final class C32320a extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    int fKA = 0;
    boolean fKz = false;

    public C32320a(int i, String str) {
        AppMethodBeat.m2504i(78417);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bmp();
        c1196a.fsK = new bmq();
        c1196a.uri = "/cgi-bin/micromsg-bin/pushnewtips";
        c1196a.fsI = 597;
        this.ehh = c1196a.acD();
        bmp bmp = (bmp) this.ehh.fsG.fsP;
        bmp.wPz = i;
        bmp.wPA = 1;
        bmp.vMU = str;
        this.fKA = i;
        AppMethodBeat.m2505o(78417);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78418);
        if (i2 == 0 && i3 == 0) {
            this.fKz = ((bmq) ((C7472b) c1929q).fsH.fsP).wPB;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(78418);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetScenePushNewTips", "errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78418);
    }

    public final int getType() {
        return 597;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78419);
        C4990ab.m7410d("MicroMsg.NetScenePushNewTips", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78419);
        return a;
    }
}
