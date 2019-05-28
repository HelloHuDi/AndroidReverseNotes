package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aah;
import com.tencent.p177mm.protocal.protobuf.aai;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.facedetect.b.m */
public final class C43030m extends C1207m implements C1918k, C27916e {
    private C7472b ehh;
    private C1202f ehi;
    private boolean lSP = false;
    public String lSQ = null;
    public boolean lSR = false;
    private String lSS = "";

    public C43030m(long j, String str, String str2, String str3, String str4, int i, float f, int i2) {
        AppMethodBeat.m2504i(82);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aah();
        c1196a.fsK = new aai();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        aah aah = (aah) this.ehh.fsG.fsP;
        aah.csB = str;
        aah.wfw = j;
        aah.wfo = str2;
        aah.wfy = str3;
        aah.wfx = str4;
        aah.lSN = i;
        aah.wfA = f;
        aah.wfB = i2;
        C4990ab.m7417i("MicroMsg.NetSceneFaceVerifyFace", "create NetSceneFacePicThirdVerifyFace, checkAliveType: %s  ,light:%f ,upload_video:%d", Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2));
        AppMethodBeat.m2505o(82);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(83);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(83);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(84);
        C4990ab.m7411d("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        aai aai = (aai) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", aai.wfC);
        this.lSQ = aai.wfC;
        this.lSR = aai.wfD;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(84);
    }

    public final String bsh() {
        return this.lSQ;
    }

    public final boolean bsg() {
        return this.lSR;
    }
}
