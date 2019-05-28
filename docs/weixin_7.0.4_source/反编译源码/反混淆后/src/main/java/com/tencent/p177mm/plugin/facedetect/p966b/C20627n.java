package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bqx;
import com.tencent.p177mm.protocal.protobuf.bqy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.facedetect.b.n */
public final class C20627n extends C1207m implements C1918k, C27916e {
    private C7472b ehh;
    private C1202f ehi;
    private boolean lSP = false;
    private String lST = null;

    public C20627n(long j, String str, String str2) {
        AppMethodBeat.m2504i(85);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bqx();
        c1196a.fsK = new bqy();
        c1196a.uri = "/cgi-bin/micromsg-bin/registerface";
        c1196a.fsI = 918;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bqx bqx = (bqx) this.ehh.fsG.fsP;
        bqx.wmO = j;
        bqx.wTm = str;
        bqx.wTn = str2;
        AppMethodBeat.m2505o(85);
    }

    public final int getType() {
        return 918;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(86);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(86);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87);
        bqy bqy = (bqy) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            this.lSP = bqy.wTp == 0;
            this.lST = bqy.wTo;
            i3 = bqy.wTp;
            C4990ab.m7417i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", Boolean.valueOf(this.lSP));
        } else if (!(bqy == null || bqy.wTp == 0)) {
            C4990ab.m7416i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
            i3 = bqy.wTp;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(87);
    }

    public final boolean bsg() {
        return true;
    }

    public final String bsh() {
        return this.lST;
    }
}
