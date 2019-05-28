package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cft;
import com.tencent.p177mm.protocal.protobuf.cfu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.facedetect.b.q */
public final class C27919q extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public boolean lSY = false;
    public boolean lSZ = false;

    public C27919q(int i) {
        AppMethodBeat.m2504i(95);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cft();
        c1196a.fsK = new cfu();
        c1196a.uri = "/cgi-bin/micromsg-bin/switchopface";
        c1196a.fsI = 938;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((cft) this.ehh.fsG.fsP).OpCode = i;
        AppMethodBeat.m2505o(95);
    }

    public final int getType() {
        return 938;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(96);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(96);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(97);
        cfu cfu = (cfu) ((C7472b) c1929q).fsH.fsP;
        this.lSY = cfu.xeT;
        this.lSZ = cfu.xeU;
        C4990ab.m7417i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.lSY), Boolean.valueOf(this.lSZ));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(97);
    }
}
