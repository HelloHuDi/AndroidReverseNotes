package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aaf;
import com.tencent.p177mm.protocal.protobuf.aag;
import com.tencent.p177mm.protocal.protobuf.axh;
import com.tencent.p177mm.protocal.protobuf.blr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.facedetect.b.l */
public final class C45916l extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    private LinkedList<axh> lSF = null;
    public blr lSG = null;
    public String lSH;
    public String lSI;
    public String lSJ = null;
    public String lSK = null;
    public String lSL = null;
    public float lSM;
    public int lSN;
    public String lSO;

    public C45916l(String str, String str2, int i) {
        AppMethodBeat.m2504i(78);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aaf();
        c1196a.fsK = new aag();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
        c1196a.fsI = 1147;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        aaf aaf = (aaf) this.ehh.fsG.fsP;
        aaf.csB = str;
        aaf.wfo = str2;
        aaf.lSN = i;
        AppMethodBeat.m2505o(78);
    }

    public final int getType() {
        return 1147;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(79);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(79);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(80);
        C4990ab.m7417i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "alvinluo errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        aag aag = (aag) ((C7472b) c1929q).fsH.fsP;
        if (aag != null) {
            this.lSF = aag.vWz;
            this.lSG = aag.wfp;
            this.lSJ = aag.wfr;
            this.lSK = aag.wfs;
            this.lSL = aag.wft;
            this.lSM = aag.wfu;
            this.lSN = aag.lSN;
            this.lSO = aag.lSO;
            this.lSH = aag.wfv;
            this.lSI = aag.wfq;
            C4990ab.m7410d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "Light threshold is A : " + this.lSM);
            C4990ab.m7410d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "check_alive_type is  : " + this.lSN);
            if (this.ehi != null) {
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
        }
        AppMethodBeat.m2505o(80);
    }

    public final String toString() {
        AppMethodBeat.m2504i(81);
        String str = "NetSceneFaceGetConfirmPageInfo{callback=" + this.ehi + ", rr=" + this.ehh + ", mFaceConfirmInfoList=" + this.lSF + ", mPromptButtonInfo=" + this.lSG + ", bizHeadUrl='" + this.lSH + '\'' + ", bizNickName='" + this.lSI + '\'' + ", mHeaderPrompt='" + this.lSJ + '\'' + ", mFeedbackUrl='" + this.lSK + '\'' + ", mComplainUrl='" + this.lSL + '\'' + ", mLight_threshold=" + this.lSM + ", check_alive_type=" + this.lSN + ", business_tips='" + this.lSO + '\'' + '}';
        AppMethodBeat.m2505o(81);
        return str;
    }
}
