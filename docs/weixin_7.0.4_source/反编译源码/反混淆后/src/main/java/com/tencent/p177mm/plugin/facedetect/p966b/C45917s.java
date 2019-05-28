package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cms;
import com.tencent.p177mm.protocal.protobuf.cmt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.facedetect.b.s */
public final class C45917s extends C1207m implements C1918k, C27916e {
    private C7472b ehh;
    private C1202f ehi;
    private boolean lSP = false;

    public C45917s(long j, String str, String str2) {
        AppMethodBeat.m2504i(101);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cms();
        c1196a.fsK = new cmt();
        c1196a.uri = "/cgi-bin/micromsg-bin/verifyface";
        c1196a.fsI = 797;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        cms cms = (cms) this.ehh.fsG.fsP;
        cms.wmO = j;
        cms.wTm = str;
        cms.wTn = str2;
        AppMethodBeat.m2505o(101);
    }

    public final int getType() {
        return 797;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(102);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(102);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103);
        cmt cmt = (cmt) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            this.lSP = cmt.wTp == 0;
            i3 = cmt.wTp;
            C4990ab.m7417i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", Boolean.valueOf(this.lSP));
        } else if (!(cmt == null || cmt.wTp == 0)) {
            C4990ab.m7416i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
            i3 = cmt.wTp;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(103);
    }

    public final boolean bsg() {
        return true;
    }

    public final String bsh() {
        return null;
    }
}
